//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// UserDomain - A UserDomain is the user's own top level domain in user - e.g.
// user.hga
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDomain {
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
    public Integer groupExpiryDays;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String userAuthorityFilter;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String azureSubscription;
    public String name;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public DomainTemplateList templates;

    public UserDomain setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public UserDomain setOrg(String org) {
        this.org = org;
        return this;
    }
    public String getOrg() {
        return org;
    }
    public UserDomain setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public UserDomain setAuditEnabled(Boolean auditEnabled) {
        this.auditEnabled = auditEnabled;
        return this;
    }
    public Boolean getAuditEnabled() {
        return auditEnabled;
    }
    public UserDomain setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getAccount() {
        return account;
    }
    public UserDomain setYpmId(Integer ypmId) {
        this.ypmId = ypmId;
        return this;
    }
    public Integer getYpmId() {
        return ypmId;
    }
    public UserDomain setApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }
    public String getApplicationId() {
        return applicationId;
    }
    public UserDomain setCertDnsDomain(String certDnsDomain) {
        this.certDnsDomain = certDnsDomain;
        return this;
    }
    public String getCertDnsDomain() {
        return certDnsDomain;
    }
    public UserDomain setMemberExpiryDays(Integer memberExpiryDays) {
        this.memberExpiryDays = memberExpiryDays;
        return this;
    }
    public Integer getMemberExpiryDays() {
        return memberExpiryDays;
    }
    public UserDomain setTokenExpiryMins(Integer tokenExpiryMins) {
        this.tokenExpiryMins = tokenExpiryMins;
        return this;
    }
    public Integer getTokenExpiryMins() {
        return tokenExpiryMins;
    }
    public UserDomain setServiceCertExpiryMins(Integer serviceCertExpiryMins) {
        this.serviceCertExpiryMins = serviceCertExpiryMins;
        return this;
    }
    public Integer getServiceCertExpiryMins() {
        return serviceCertExpiryMins;
    }
    public UserDomain setRoleCertExpiryMins(Integer roleCertExpiryMins) {
        this.roleCertExpiryMins = roleCertExpiryMins;
        return this;
    }
    public Integer getRoleCertExpiryMins() {
        return roleCertExpiryMins;
    }
    public UserDomain setSignAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
        return this;
    }
    public String getSignAlgorithm() {
        return signAlgorithm;
    }
    public UserDomain setServiceExpiryDays(Integer serviceExpiryDays) {
        this.serviceExpiryDays = serviceExpiryDays;
        return this;
    }
    public Integer getServiceExpiryDays() {
        return serviceExpiryDays;
    }
    public UserDomain setGroupExpiryDays(Integer groupExpiryDays) {
        this.groupExpiryDays = groupExpiryDays;
        return this;
    }
    public Integer getGroupExpiryDays() {
        return groupExpiryDays;
    }
    public UserDomain setUserAuthorityFilter(String userAuthorityFilter) {
        this.userAuthorityFilter = userAuthorityFilter;
        return this;
    }
    public String getUserAuthorityFilter() {
        return userAuthorityFilter;
    }
    public UserDomain setAzureSubscription(String azureSubscription) {
        this.azureSubscription = azureSubscription;
        return this;
    }
    public String getAzureSubscription() {
        return azureSubscription;
    }
    public UserDomain setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public UserDomain setTemplates(DomainTemplateList templates) {
        this.templates = templates;
        return this;
    }
    public DomainTemplateList getTemplates() {
        return templates;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != UserDomain.class) {
                return false;
            }
            UserDomain a = (UserDomain) another;
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
            if (groupExpiryDays == null ? a.groupExpiryDays != null : !groupExpiryDays.equals(a.groupExpiryDays)) {
                return false;
            }
            if (userAuthorityFilter == null ? a.userAuthorityFilter != null : !userAuthorityFilter.equals(a.userAuthorityFilter)) {
                return false;
            }
            if (azureSubscription == null ? a.azureSubscription != null : !azureSubscription.equals(a.azureSubscription)) {
                return false;
            }
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (templates == null ? a.templates != null : !templates.equals(a.templates)) {
                return false;
            }
        }
        return true;
    }
}
