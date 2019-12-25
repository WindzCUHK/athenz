/*
 * Copyright 2019 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class JavaHttpsClient {

	public static void main(String[] args) {
		try {
			// check args
			if (args.length != 2) {
				throw new IllegalArgumentException("args.length != 2");
			}
			String apiType = args[0];
			if (!"zms".equals(apiType) && !"zts".equals(apiType)) {
				throw new IllegalArgumentException("NOT <zms|zts>");
			}
			int port = Integer.valueOf(args[1]);

			// disable hostname checking
			final HostnameVerifier defaultHv = HttpsURLConnection.getDefaultHostnameVerifier();
			HttpsURLConnection.setDefaultHostnameVerifier(new LocalhostHostnameVerifier(defaultHv));

			// HTTPS GET
			URL statusUrl = new URL(String.format("https://127.0.0.1:%d/%s/v1/status", port, apiType));
			HttpsURLConnection conn = (HttpsURLConnection) statusUrl.openConnection();
			String responseBody;
			if (conn.getResponseCode() == 200) {
				try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {
					while((responseBody = br.readLine()) != null) {
						System.out.println(responseBody);
					}
					System.exit(0);
				}
			}

			// print error
			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));) {
				while((responseBody = br.readLine()) != null) {
					System.err.println(responseBody);
				}
			}

		} catch (RuntimeException | MalformedURLException ex) {
			System.err.println(ex.getMessage());
			System.err.println("Usage: java com.yahoo.athenz.docker.JavaHttpsClient <zms|zts> <server_port>");
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

		System.exit(1);
	}

}

class LocalhostHostnameVerifier implements HostnameVerifier {
	private HostnameVerifier defaultHv;
	public LocalhostHostnameVerifier(HostnameVerifier defaultHv) {
		this.defaultHv = defaultHv;
	}

	@Override
	public boolean verify(String hostname, SSLSession session) {
		if ("127.0.0.1".equals(hostname)) {
			return true;
		}
		return defaultHv.verify(hostname, session);
	}
}
