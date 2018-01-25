//
// This file generated by rdl 1.4.15. Do not modify!
//

package com.yahoo.athenz.zts;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// InstanceRefreshRequest - InstanceRefreshRequest - a certificate refresh
// request
//
public class InstanceRefreshRequest {
    public String csr;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer expiryTime;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String keyId;

    public InstanceRefreshRequest setCsr(String csr) {
        this.csr = csr;
        return this;
    }
    public String getCsr() {
        return csr;
    }
    public InstanceRefreshRequest setExpiryTime(Integer expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }
    public Integer getExpiryTime() {
        return expiryTime;
    }
    public InstanceRefreshRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return keyId;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != InstanceRefreshRequest.class) {
                return false;
            }
            InstanceRefreshRequest a = (InstanceRefreshRequest) another;
            if (csr == null ? a.csr != null : !csr.equals(a.csr)) {
                return false;
            }
            if (expiryTime == null ? a.expiryTime != null : !expiryTime.equals(a.expiryTime)) {
                return false;
            }
            if (keyId == null ? a.keyId != null : !keyId.equals(a.keyId)) {
                return false;
            }
        }
        return true;
    }
}
