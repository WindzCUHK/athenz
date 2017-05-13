//
// This file generated by rdl 1.4.13. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import com.yahoo.rdl.*;

//
// PolicyList - The representation for an enumeration of policies in the
// namespace, with pagination.
//
public class PolicyList {
    public List<String> names;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String next;

    public PolicyList setNames(List<String> names) {
        this.names = names;
        return this;
    }
    public List<String> getNames() {
        return names;
    }
    public PolicyList setNext(String next) {
        this.next = next;
        return this;
    }
    public String getNext() {
        return next;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != PolicyList.class) {
                return false;
            }
            PolicyList a = (PolicyList) another;
            if (names == null ? a.names != null : !names.equals(a.names)) {
                return false;
            }
            if (next == null ? a.next != null : !next.equals(a.next)) {
                return false;
            }
        }
        return true;
    }
}
