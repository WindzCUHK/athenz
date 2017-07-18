//
// This file generated by rdl 1.4.14. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// Quota - The representation for a quota object
//
public class Quota {
    public String name;
    public int subdomain;
    public int role;
    public int roleMember;
    public int policy;
    public int assertion;
    public int entity;
    public int service;
    public int serviceHost;
    public int publicKey;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Timestamp modified;

    public Quota setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public Quota setSubdomain(int subdomain) {
        this.subdomain = subdomain;
        return this;
    }
    public int getSubdomain() {
        return subdomain;
    }
    public Quota setRole(int role) {
        this.role = role;
        return this;
    }
    public int getRole() {
        return role;
    }
    public Quota setRoleMember(int roleMember) {
        this.roleMember = roleMember;
        return this;
    }
    public int getRoleMember() {
        return roleMember;
    }
    public Quota setPolicy(int policy) {
        this.policy = policy;
        return this;
    }
    public int getPolicy() {
        return policy;
    }
    public Quota setAssertion(int assertion) {
        this.assertion = assertion;
        return this;
    }
    public int getAssertion() {
        return assertion;
    }
    public Quota setEntity(int entity) {
        this.entity = entity;
        return this;
    }
    public int getEntity() {
        return entity;
    }
    public Quota setService(int service) {
        this.service = service;
        return this;
    }
    public int getService() {
        return service;
    }
    public Quota setServiceHost(int serviceHost) {
        this.serviceHost = serviceHost;
        return this;
    }
    public int getServiceHost() {
        return serviceHost;
    }
    public Quota setPublicKey(int publicKey) {
        this.publicKey = publicKey;
        return this;
    }
    public int getPublicKey() {
        return publicKey;
    }
    public Quota setModified(Timestamp modified) {
        this.modified = modified;
        return this;
    }
    public Timestamp getModified() {
        return modified;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Quota.class) {
                return false;
            }
            Quota a = (Quota) another;
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (subdomain != a.subdomain) {
                return false;
            }
            if (role != a.role) {
                return false;
            }
            if (roleMember != a.roleMember) {
                return false;
            }
            if (policy != a.policy) {
                return false;
            }
            if (assertion != a.assertion) {
                return false;
            }
            if (entity != a.entity) {
                return false;
            }
            if (service != a.service) {
                return false;
            }
            if (serviceHost != a.serviceHost) {
                return false;
            }
            if (publicKey != a.publicKey) {
                return false;
            }
            if (modified == null ? a.modified != null : !modified.equals(a.modified)) {
                return false;
            }
        }
        return true;
    }
}
