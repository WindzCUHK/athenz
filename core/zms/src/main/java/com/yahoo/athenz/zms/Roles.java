//
// This file generated by rdl 1.4.13. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;

//
// Roles - The representation for a list of roles with full details
//
public class Roles {
    public List<Role> list;

    public Roles setList(List<Role> list) {
        this.list = list;
        return this;
    }
    public List<Role> getList() {
        return list;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Roles.class) {
                return false;
            }
            Roles a = (Roles) another;
            if (list == null ? a.list != null : !list.equals(a.list)) {
                return false;
            }
        }
        return true;
    }
}
