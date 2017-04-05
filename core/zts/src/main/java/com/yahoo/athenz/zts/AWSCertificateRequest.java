//
// This file generated by rdl 1.4.12. Do not modify!
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// AWSCertificateRequest - AWSCertificateRequest - a certificate signing
// request
//
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class AWSCertificateRequest {
    @RdlOptional
    public String csr;
    @RdlOptional
    public String ssh;

    public AWSCertificateRequest setCsr(String csr) {
        this.csr = csr;
        return this;
    }
    public String getCsr() {
        return csr;
    }
    public AWSCertificateRequest setSsh(String ssh) {
        this.ssh = ssh;
        return this;
    }
    public String getSsh() {
        return ssh;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != AWSCertificateRequest.class) {
                return false;
            }
            AWSCertificateRequest a = (AWSCertificateRequest) another;
            if (csr == null ? a.csr != null : !csr.equals(a.csr)) {
                return false;
            }
            if (ssh == null ? a.ssh != null : !ssh.equals(a.ssh)) {
                return false;
            }
        }
        return true;
    }
}
