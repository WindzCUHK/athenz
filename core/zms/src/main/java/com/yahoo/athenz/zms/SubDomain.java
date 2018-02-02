//
// This file generated by rdl 1.5.0. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import com.yahoo.rdl.*;

//
// SubDomain - A Subdomain is a TopLevelDomain, except it has a parent.
//
public class SubDomain {
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
    public String name;
    public List<String> adminUsers;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public DomainTemplateList templates;
    public String parent;

    public SubDomain setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public SubDomain setOrg(String org) {
        this.org = org;
        return this;
    }
    public String getOrg() {
        return org;
    }
    public SubDomain setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public SubDomain setAuditEnabled(Boolean auditEnabled) {
        this.auditEnabled = auditEnabled;
        return this;
    }
    public Boolean getAuditEnabled() {
        return auditEnabled;
    }
    public SubDomain setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getAccount() {
        return account;
    }
    public SubDomain setYpmId(Integer ypmId) {
        this.ypmId = ypmId;
        return this;
    }
    public Integer getYpmId() {
        return ypmId;
    }
    public SubDomain setApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }
    public String getApplicationId() {
        return applicationId;
    }
    public SubDomain setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public SubDomain setAdminUsers(List<String> adminUsers) {
        this.adminUsers = adminUsers;
        return this;
    }
    public List<String> getAdminUsers() {
        return adminUsers;
    }
    public SubDomain setTemplates(DomainTemplateList templates) {
        this.templates = templates;
        return this;
    }
    public DomainTemplateList getTemplates() {
        return templates;
    }
    public SubDomain setParent(String parent) {
        this.parent = parent;
        return this;
    }
    public String getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != SubDomain.class) {
                return false;
            }
            SubDomain a = (SubDomain) another;
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
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (adminUsers == null ? a.adminUsers != null : !adminUsers.equals(a.adminUsers)) {
                return false;
            }
            if (templates == null ? a.templates != null : !templates.equals(a.templates)) {
                return false;
            }
            if (parent == null ? a.parent != null : !parent.equals(a.parent)) {
                return false;
            }
        }
        return true;
    }
}
