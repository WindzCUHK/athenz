//
// This file generated by rdl 1.5.1. Do not modify!
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;

//
// Access - Access can be checked and returned as this resource.
//
public class Access {
    public boolean granted;

    public Access setGranted(boolean granted) {
        this.granted = granted;
        return this;
    }
    public boolean getGranted() {
        return granted;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Access.class) {
                return false;
            }
            Access a = (Access) another;
            if (granted != a.granted) {
                return false;
            }
        }
        return true;
    }
}
