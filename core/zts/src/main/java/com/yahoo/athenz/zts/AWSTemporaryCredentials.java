//
// This file generated by rdl 1.4.12. Do not modify!
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// AWSTemporaryCredentials -
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class AWSTemporaryCredentials {
    public String accessKeyId;
    public String secretAccessKey;
    public String sessionToken;
    public Timestamp expiration;

    public AWSTemporaryCredentials setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }
    public String getAccessKeyId() {
        return accessKeyId;
    }
    public AWSTemporaryCredentials setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }
    public String getSecretAccessKey() {
        return secretAccessKey;
    }
    public AWSTemporaryCredentials setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        return this;
    }
    public String getSessionToken() {
        return sessionToken;
    }
    public AWSTemporaryCredentials setExpiration(Timestamp expiration) {
        this.expiration = expiration;
        return this;
    }
    public Timestamp getExpiration() {
        return expiration;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != AWSTemporaryCredentials.class) {
                return false;
            }
            AWSTemporaryCredentials a = (AWSTemporaryCredentials) another;
            if (accessKeyId == null ? a.accessKeyId != null : !accessKeyId.equals(a.accessKeyId)) {
                return false;
            }
            if (secretAccessKey == null ? a.secretAccessKey != null : !secretAccessKey.equals(a.secretAccessKey)) {
                return false;
            }
            if (sessionToken == null ? a.sessionToken != null : !sessionToken.equals(a.sessionToken)) {
                return false;
            }
            if (expiration == null ? a.expiration != null : !expiration.equals(a.expiration)) {
                return false;
            }
        }
        return true;
    }
}
