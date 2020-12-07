//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// ServiceIdentitySystemMeta - Set of system metadata attributes that all
// services may have and can be changed by system admins.
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceIdentitySystemMeta {
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String providerEndpoint;

    public ServiceIdentitySystemMeta setProviderEndpoint(String providerEndpoint) {
        this.providerEndpoint = providerEndpoint;
        return this;
    }
    public String getProviderEndpoint() {
        return providerEndpoint;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ServiceIdentitySystemMeta.class) {
                return false;
            }
            ServiceIdentitySystemMeta a = (ServiceIdentitySystemMeta) another;
            if (providerEndpoint == null ? a.providerEndpoint != null : !providerEndpoint.equals(a.providerEndpoint)) {
                return false;
            }
        }
        return true;
    }
}
