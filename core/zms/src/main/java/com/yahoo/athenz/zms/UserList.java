//
// This file generated by rdl 1.4.13. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;

//
// UserList -
//
public class UserList {
    public List<String> names;

    public UserList setNames(List<String> names) {
        this.names = names;
        return this;
    }
    public List<String> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != UserList.class) {
                return false;
            }
            UserList a = (UserList) another;
            if (names == null ? a.names != null : !names.equals(a.names)) {
                return false;
            }
        }
        return true;
    }
}
