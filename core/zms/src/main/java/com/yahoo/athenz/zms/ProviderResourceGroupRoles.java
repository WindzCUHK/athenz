//
// This file generated by rdl 1.5.0. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;

//
// ProviderResourceGroupRoles - A representation of provider roles to be
// provisioned.
//
public class ProviderResourceGroupRoles {
    public String domain;
    public String service;
    public String tenant;
    public List<TenantRoleAction> roles;
    public String resourceGroup;

    public ProviderResourceGroupRoles setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    public String getDomain() {
        return domain;
    }
    public ProviderResourceGroupRoles setService(String service) {
        this.service = service;
        return this;
    }
    public String getService() {
        return service;
    }
    public ProviderResourceGroupRoles setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }
    public String getTenant() {
        return tenant;
    }
    public ProviderResourceGroupRoles setRoles(List<TenantRoleAction> roles) {
        this.roles = roles;
        return this;
    }
    public List<TenantRoleAction> getRoles() {
        return roles;
    }
    public ProviderResourceGroupRoles setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
        return this;
    }
    public String getResourceGroup() {
        return resourceGroup;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ProviderResourceGroupRoles.class) {
                return false;
            }
            ProviderResourceGroupRoles a = (ProviderResourceGroupRoles) another;
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
            if (resourceGroup == null ? a.resourceGroup != null : !resourceGroup.equals(a.resourceGroup)) {
                return false;
            }
        }
        return true;
    }
}
