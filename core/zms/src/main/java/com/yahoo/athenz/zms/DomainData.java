//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import com.yahoo.rdl.*;

//
// DomainData - A domain object that includes its roles, policies and services.
//
public class DomainData {
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String description;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String org;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean enabled;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean auditEnabled;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String account;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer ypmId;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String applicationId;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String certDnsDomain;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer memberExpiryDays;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer tokenExpiryMins;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer serviceCertExpiryMins;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer roleCertExpiryMins;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String signAlgorithm;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer serviceExpiryDays;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String userAuthorityFilter;
    public String name;
    public List<Role> roles;
    public SignedPolicies policies;
    public List<ServiceIdentity> services;
    public List<Entity> entities;
    public Timestamp modified;

    public DomainData setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public DomainData setOrg(String org) {
        this.org = org;
        return this;
    }
    public String getOrg() {
        return org;
    }
    public DomainData setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public DomainData setAuditEnabled(Boolean auditEnabled) {
        this.auditEnabled = auditEnabled;
        return this;
    }
    public Boolean getAuditEnabled() {
        return auditEnabled;
    }
    public DomainData setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getAccount() {
        return account;
    }
    public DomainData setYpmId(Integer ypmId) {
        this.ypmId = ypmId;
        return this;
    }
    public Integer getYpmId() {
        return ypmId;
    }
    public DomainData setApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }
    public String getApplicationId() {
        return applicationId;
    }
    public DomainData setCertDnsDomain(String certDnsDomain) {
        this.certDnsDomain = certDnsDomain;
        return this;
    }
    public String getCertDnsDomain() {
        return certDnsDomain;
    }
    public DomainData setMemberExpiryDays(Integer memberExpiryDays) {
        this.memberExpiryDays = memberExpiryDays;
        return this;
    }
    public Integer getMemberExpiryDays() {
        return memberExpiryDays;
    }
    public DomainData setTokenExpiryMins(Integer tokenExpiryMins) {
        this.tokenExpiryMins = tokenExpiryMins;
        return this;
    }
    public Integer getTokenExpiryMins() {
        return tokenExpiryMins;
    }
    public DomainData setServiceCertExpiryMins(Integer serviceCertExpiryMins) {
        this.serviceCertExpiryMins = serviceCertExpiryMins;
        return this;
    }
    public Integer getServiceCertExpiryMins() {
        return serviceCertExpiryMins;
    }
    public DomainData setRoleCertExpiryMins(Integer roleCertExpiryMins) {
        this.roleCertExpiryMins = roleCertExpiryMins;
        return this;
    }
    public Integer getRoleCertExpiryMins() {
        return roleCertExpiryMins;
    }
    public DomainData setSignAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
        return this;
    }
    public String getSignAlgorithm() {
        return signAlgorithm;
    }
    public DomainData setServiceExpiryDays(Integer serviceExpiryDays) {
        this.serviceExpiryDays = serviceExpiryDays;
        return this;
    }
    public Integer getServiceExpiryDays() {
        return serviceExpiryDays;
    }
    public DomainData setUserAuthorityFilter(String userAuthorityFilter) {
        this.userAuthorityFilter = userAuthorityFilter;
        return this;
    }
    public String getUserAuthorityFilter() {
        return userAuthorityFilter;
    }
    public DomainData setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public DomainData setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public DomainData setPolicies(SignedPolicies policies) {
        this.policies = policies;
        return this;
    }
    public SignedPolicies getPolicies() {
        return policies;
    }
    public DomainData setServices(List<ServiceIdentity> services) {
        this.services = services;
        return this;
    }
    public List<ServiceIdentity> getServices() {
        return services;
    }
    public DomainData setEntities(List<Entity> entities) {
        this.entities = entities;
        return this;
    }
    public List<Entity> getEntities() {
        return entities;
    }
    public DomainData setModified(Timestamp modified) {
        this.modified = modified;
        return this;
    }
    public Timestamp getModified() {
        return modified;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != DomainData.class) {
                return false;
            }
            DomainData a = (DomainData) another;
            if (description == null ? a.description != null : !description.equals(a.description)) {
                return false;
            }
            if (org == null ? a.org != null : !org.equals(a.org)) {
                return false;
            }
            if (enabled == null ? a.enabled != null : !enabled.equals(a.enabled)) {
                return false;
            }
            if (auditEnabled == null ? a.auditEnabled != null : !auditEnabled.equals(a.auditEnabled)) {
                return false;
            }
            if (account == null ? a.account != null : !account.equals(a.account)) {
                return false;
            }
            if (ypmId == null ? a.ypmId != null : !ypmId.equals(a.ypmId)) {
                return false;
            }
            if (applicationId == null ? a.applicationId != null : !applicationId.equals(a.applicationId)) {
                return false;
            }
            if (certDnsDomain == null ? a.certDnsDomain != null : !certDnsDomain.equals(a.certDnsDomain)) {
                return false;
            }
            if (memberExpiryDays == null ? a.memberExpiryDays != null : !memberExpiryDays.equals(a.memberExpiryDays)) {
                return false;
            }
            if (tokenExpiryMins == null ? a.tokenExpiryMins != null : !tokenExpiryMins.equals(a.tokenExpiryMins)) {
                return false;
            }
            if (serviceCertExpiryMins == null ? a.serviceCertExpiryMins != null : !serviceCertExpiryMins.equals(a.serviceCertExpiryMins)) {
                return false;
            }
            if (roleCertExpiryMins == null ? a.roleCertExpiryMins != null : !roleCertExpiryMins.equals(a.roleCertExpiryMins)) {
                return false;
            }
            if (signAlgorithm == null ? a.signAlgorithm != null : !signAlgorithm.equals(a.signAlgorithm)) {
                return false;
            }
            if (serviceExpiryDays == null ? a.serviceExpiryDays != null : !serviceExpiryDays.equals(a.serviceExpiryDays)) {
                return false;
            }
            if (userAuthorityFilter == null ? a.userAuthorityFilter != null : !userAuthorityFilter.equals(a.userAuthorityFilter)) {
                return false;
            }
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (roles == null ? a.roles != null : !roles.equals(a.roles)) {
                return false;
            }
            if (policies == null ? a.policies != null : !policies.equals(a.policies)) {
                return false;
            }
            if (services == null ? a.services != null : !services.equals(a.services)) {
                return false;
            }
            if (entities == null ? a.entities != null : !entities.equals(a.entities)) {
                return false;
            }
            if (modified == null ? a.modified != null : !modified.equals(a.modified)) {
                return false;
            }
        }
        return true;
    }
}
