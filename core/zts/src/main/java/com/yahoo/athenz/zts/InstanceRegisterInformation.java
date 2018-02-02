//
// This file generated by rdl 1.5.0. Do not modify!
//

package com.yahoo.athenz.zts;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// InstanceRegisterInformation -
//
public class InstanceRegisterInformation {
    public String provider;
    public String domain;
    public String service;
    public String attestationData;
    public String csr;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String ssh;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean token;

    public InstanceRegisterInformation setProvider(String provider) {
        this.provider = provider;
        return this;
    }
    public String getProvider() {
        return provider;
    }
    public InstanceRegisterInformation setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    public String getDomain() {
        return domain;
    }
    public InstanceRegisterInformation setService(String service) {
        this.service = service;
        return this;
    }
    public String getService() {
        return service;
    }
    public InstanceRegisterInformation setAttestationData(String attestationData) {
        this.attestationData = attestationData;
        return this;
    }
    public String getAttestationData() {
        return attestationData;
    }
    public InstanceRegisterInformation setCsr(String csr) {
        this.csr = csr;
        return this;
    }
    public String getCsr() {
        return csr;
    }
    public InstanceRegisterInformation setSsh(String ssh) {
        this.ssh = ssh;
        return this;
    }
    public String getSsh() {
        return ssh;
    }
    public InstanceRegisterInformation setToken(Boolean token) {
        this.token = token;
        return this;
    }
    public Boolean getToken() {
        return token;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != InstanceRegisterInformation.class) {
                return false;
            }
            InstanceRegisterInformation a = (InstanceRegisterInformation) another;
            if (provider == null ? a.provider != null : !provider.equals(a.provider)) {
                return false;
            }
            if (domain == null ? a.domain != null : !domain.equals(a.domain)) {
                return false;
            }
            if (service == null ? a.service != null : !service.equals(a.service)) {
                return false;
            }
            if (attestationData == null ? a.attestationData != null : !attestationData.equals(a.attestationData)) {
                return false;
            }
            if (csr == null ? a.csr != null : !csr.equals(a.csr)) {
                return false;
            }
            if (ssh == null ? a.ssh != null : !ssh.equals(a.ssh)) {
                return false;
            }
            if (token == null ? a.token != null : !token.equals(a.token)) {
                return false;
            }
        }
        return true;
    }
}
