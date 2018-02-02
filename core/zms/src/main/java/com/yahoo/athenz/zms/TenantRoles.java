//
// This file generated by rdl 1.5.0. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;

//
// TenantRoles - A representation of tenant roles to be provisioned.
//
public class TenantRoles {
    public String domain;
    public String service;
    public String tenant;
    public List<TenantRoleAction> roles;

    public TenantRoles setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    public String getDomain() {
        return domain;
    }
    public TenantRoles setService(String service) {
        this.service = service;
        return this;
    }
    public String getService() {
        return service;
    }
    public TenantRoles setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }
    public String getTenant() {
        return tenant;
    }
    public TenantRoles setRoles(List<TenantRoleAction> roles) {
        this.roles = roles;
        return this;
    }
    public List<TenantRoleAction> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != TenantRoles.class) {
                return false;
            }
            TenantRoles a = (TenantRoles) another;
            if (domain == null ? a.domain != null : !domain.equals(a.domain)) {
                return false;
            }
            if (service == null ? a.service != null : !service.equals(a.service)) {
                return false;
            }
            if (tenant == null ? a.tenant != null : !tenant.equals(a.tenant)) {
                return false;
            }
            if (roles == null ? a.roles != null : !roles.equals(a.roles)) {
                return false;
            }
        }
        return true;
    }
}
