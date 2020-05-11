//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// RoleMeta - Set of metadata attributes that all roles may have and can be
// changed by domain admins.
//
public class RoleMeta {
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean selfServe;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer memberExpiryDays;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer tokenExpiryMins;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer certExpiryMins;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String signAlgorithm;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer serviceExpiryDays;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean reviewEnabled;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String notifyRoles;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String userAuthorityFilter;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String userAuthorityExpiration;

    public RoleMeta setSelfServe(Boolean selfServe) {
        this.selfServe = selfServe;
        return this;
    }
    public Boolean getSelfServe() {
        return selfServe;
    }
    public RoleMeta setMemberExpiryDays(Integer memberExpiryDays) {
        this.memberExpiryDays = memberExpiryDays;
        return this;
    }
    public Integer getMemberExpiryDays() {
        return memberExpiryDays;
    }
    public RoleMeta setTokenExpiryMins(Integer tokenExpiryMins) {
        this.tokenExpiryMins = tokenExpiryMins;
        return this;
    }
    public Integer getTokenExpiryMins() {
        return tokenExpiryMins;
    }
    public RoleMeta setCertExpiryMins(Integer certExpiryMins) {
        this.certExpiryMins = certExpiryMins;
        return this;
    }
    public Integer getCertExpiryMins() {
        return certExpiryMins;
    }
    public RoleMeta setSignAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
        return this;
    }
    public String getSignAlgorithm() {
        return signAlgorithm;
    }
    public RoleMeta setServiceExpiryDays(Integer serviceExpiryDays) {
        this.serviceExpiryDays = serviceExpiryDays;
        return this;
    }
    public Integer getServiceExpiryDays() {
        return serviceExpiryDays;
    }
    public RoleMeta setReviewEnabled(Boolean reviewEnabled) {
        this.reviewEnabled = reviewEnabled;
        return this;
    }
    public Boolean getReviewEnabled() {
        return reviewEnabled;
    }
    public RoleMeta setNotifyRoles(String notifyRoles) {
        this.notifyRoles = notifyRoles;
        return this;
    }
    public String getNotifyRoles() {
        return notifyRoles;
    }
    public RoleMeta setUserAuthorityFilter(String userAuthorityFilter) {
        this.userAuthorityFilter = userAuthorityFilter;
        return this;
    }
    public String getUserAuthorityFilter() {
        return userAuthorityFilter;
    }
    public RoleMeta setUserAuthorityExpiration(String userAuthorityExpiration) {
        this.userAuthorityExpiration = userAuthorityExpiration;
        return this;
    }
    public String getUserAuthorityExpiration() {
        return userAuthorityExpiration;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != RoleMeta.class) {
                return false;
            }
            RoleMeta a = (RoleMeta) another;
            if (selfServe == null ? a.selfServe != null : !selfServe.equals(a.selfServe)) {
                return false;
            }
            if (memberExpiryDays == null ? a.memberExpiryDays != null : !memberExpiryDays.equals(a.memberExpiryDays)) {
                return false;
            }
            if (tokenExpiryMins == null ? a.tokenExpiryMins != null : !tokenExpiryMins.equals(a.tokenExpiryMins)) {
                return false;
            }
            if (certExpiryMins == null ? a.certExpiryMins != null : !certExpiryMins.equals(a.certExpiryMins)) {
                return false;
            }
            if (signAlgorithm == null ? a.signAlgorithm != null : !signAlgorithm.equals(a.signAlgorithm)) {
                return false;
            }
            if (serviceExpiryDays == null ? a.serviceExpiryDays != null : !serviceExpiryDays.equals(a.serviceExpiryDays)) {
                return false;
            }
            if (reviewEnabled == null ? a.reviewEnabled != null : !reviewEnabled.equals(a.reviewEnabled)) {
                return false;
            }
            if (notifyRoles == null ? a.notifyRoles != null : !notifyRoles.equals(a.notifyRoles)) {
                return false;
            }
            if (userAuthorityFilter == null ? a.userAuthorityFilter != null : !userAuthorityFilter.equals(a.userAuthorityFilter)) {
                return false;
            }
            if (userAuthorityExpiration == null ? a.userAuthorityExpiration != null : !userAuthorityExpiration.equals(a.userAuthorityExpiration)) {
                return false;
            }
        }
        return true;
    }
}
