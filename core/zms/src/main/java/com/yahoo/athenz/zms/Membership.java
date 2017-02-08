//
// This file generated by rdl 1.4.10. Do not modify!
//

package com.yahoo.athenz.zms;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// Membership - The representation for a role membership.
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Membership {
    public String memberName;
    @RdlOptional
    public Boolean isMember;
    @RdlOptional
    public String roleName;
    @RdlOptional
    public Timestamp expiration;

    public Membership setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }
    public String getMemberName() {
        return memberName;
    }
    public Membership setIsMember(Boolean isMember) {
        this.isMember = isMember;
        return this;
    }
    public Boolean getIsMember() {
        return isMember;
    }
    public Membership setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
    public String getRoleName() {
        return roleName;
    }
    public Membership setExpiration(Timestamp expiration) {
        this.expiration = expiration;
        return this;
    }
    public Timestamp getExpiration() {
        return expiration;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Membership.class) {
                return false;
            }
            Membership a = (Membership) another;
            if (memberName == null ? a.memberName != null : !memberName.equals(a.memberName)) {
                return false;
            }
            if (isMember == null ? a.isMember != null : !isMember.equals(a.isMember)) {
                return false;
            }
            if (roleName == null ? a.roleName != null : !roleName.equals(a.roleName)) {
                return false;
            }
            if (expiration == null ? a.expiration != null : !expiration.equals(a.expiration)) {
                return false;
            }
        }
        return true;
    }

    //
    // sets up the instance according to its default field values, if any
    //
    public Membership init() {
        if (isMember == null) {
            isMember = true;
        }
        return this;
    }
}
