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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class JavaHttpsClient {

	public static void main(String[] args) {
		try {
			// check args
			if (args.length != 2) {
				throw new IllegalArgumentException();
			}
			String apiType = args[0];
			if (!"zms".equals(apiType) && !"zts".equals(apiType)) {
				throw new IllegalArgumentException();
			}
			int port = Integer.valueOf(args[1]);

			// disable hostname checking
			final HostnameVerifier defaultHv = HttpsURLConnection.getDefaultHostnameVerifier()
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					if ("127.0.0.1".equals(hostname)) {
						return true;
					}
					return defaultHv.verify(hostname, session);
				}
			});

			// HTTPS GET
			URL statusUrl = new URL(String.format("https://127.0.0.1:%d/%s/v1/status", port, apiType));
			HttpsURLConnection https = (HttpsURLConnection) statusUrl.openConnection();
			if (https.getResponseCode() == 200) {
				System.exit(0);
			}

		} catch (RuntimeException | MalformedURLException ex) {
			// print usage
			System.out.println("Usage: java com.yahoo.athenz.docker.JavaHttpsClient <zms|zts> <server_port>");
		} catch (IOException ex) {}

		System.exit(1);
	}

}
