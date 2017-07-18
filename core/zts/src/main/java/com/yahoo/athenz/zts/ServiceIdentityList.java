//
// This file generated by rdl 1.4.14. Do not modify!
//

package com.yahoo.athenz.zts;
import java.util.List;
import com.yahoo.rdl.*;

//
// ServiceIdentityList - The representation for an enumeration of services in
// the namespace.
//
public class ServiceIdentityList {
    public List<String> names;

    public ServiceIdentityList setNames(List<String> names) {
        this.names = names;
        return this;
    }
    public List<String> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ServiceIdentityList.class) {
                return false;
            }
            ServiceIdentityList a = (ServiceIdentityList) another;
            if (names == null ? a.names != null : !names.equals(a.names)) {
                return false;
            }
        }
        return true;
    }
}
