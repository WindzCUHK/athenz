//
// This file generated by rdl 1.4.12. Do not modify!
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;

//
// RoleCertificateRequest - RoleCertificateRequest - a certificate signing
// request
//
public class RoleCertificateRequest {
    public String csr;
    public long expiryTime;

    public RoleCertificateRequest setCsr(String csr) {
        this.csr = csr;
        return this;
    }
    public String getCsr() {
        return csr;
    }
    public RoleCertificateRequest setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }
    public long getExpiryTime() {
        return expiryTime;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != RoleCertificateRequest.class) {
                return false;
            }
            RoleCertificateRequest a = (RoleCertificateRequest) another;
            if (csr == null ? a.csr != null : !csr.equals(a.csr)) {
                return false;
            }
            if (expiryTime != a.expiryTime) {
                return false;
            }
        }
        return true;
    }
}
