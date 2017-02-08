//
// This file generated by rdl 1.4.10. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// Role - The representation for a Role with set of members.
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Role {
    public String name;
    @RdlOptional
    public Timestamp modified;
    @RdlOptional
    public List<String> members;
    @RdlOptional
    public List<RoleMember> roleMembers;
    @RdlOptional
    public String trust;
    @RdlOptional
    public List<RoleAuditLog> auditLog;

    public Role setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public Role setModified(Timestamp modified) {
        this.modified = modified;
        return this;
    }
    public Timestamp getModified() {
        return modified;
    }
    public Role setMembers(List<String> members) {
        this.members = members;
        return this;
    }
    public List<String> getMembers() {
        return members;
    }
    public Role setRoleMembers(List<RoleMember> roleMembers) {
        this.roleMembers = roleMembers;
        return this;
    }
    public List<RoleMember> getRoleMembers() {
        return roleMembers;
    }
    public Role setTrust(String trust) {
        this.trust = trust;
        return this;
    }
    public String getTrust() {
        return trust;
    }
    public Role setAuditLog(List<RoleAuditLog> auditLog) {
        this.auditLog = auditLog;
        return this;
    }
    public List<RoleAuditLog> getAuditLog() {
        return auditLog;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Role.class) {
                return false;
            }
            Role a = (Role) another;
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (modified == null ? a.modified != null : !modified.equals(a.modified)) {
                return false;
            }
            if (members == null ? a.members != null : !members.equals(a.members)) {
                return false;
            }
            if (roleMembers == null ? a.roleMembers != null : !roleMembers.equals(a.roleMembers)) {
                return false;
            }
            if (trust == null ? a.trust != null : !trust.equals(a.trust)) {
                return false;
            }
            if (auditLog == null ? a.auditLog != null : !auditLog.equals(a.auditLog)) {
                return false;
            }
        }
        return true;
    }
}
