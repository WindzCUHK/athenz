//
// This file generated by rdl 1.4.14. Do not modify!
//

package com.yahoo.athenz.zms;
import com.yahoo.rdl.*;

//
// DanglingPolicy - A dangling policy where the assertion is referencing a role
// name that doesn't exist in the domain
//
public class DanglingPolicy {
    public String policyName;
    public String roleName;

    public DanglingPolicy setPolicyName(String policyName) {
        this.policyName = policyName;
        return this;
    }
    public String getPolicyName() {
        return policyName;
    }
    public DanglingPolicy setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
    public String getRoleName() {
        return roleName;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != DanglingPolicy.class) {
                return false;
            }
            DanglingPolicy a = (DanglingPolicy) another;
            if (policyName == null ? a.policyName != null : !policyName.equals(a.policyName)) {
                return false;
            }
            if (roleName == null ? a.roleName != null : !roleName.equals(a.roleName)) {
                return false;
            }
        }
        return true;
    }
}
