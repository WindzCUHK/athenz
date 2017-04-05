//
// This file generated by rdl 1.4.12. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// SignedDomains - A list of signed domain objects
//
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class SignedDomains {
    public List<SignedDomain> domains;

    public SignedDomains setDomains(List<SignedDomain> domains) {
        this.domains = domains;
        return this;
    }
    public List<SignedDomain> getDomains() {
        return domains;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != SignedDomains.class) {
                return false;
            }
            SignedDomains a = (SignedDomains) another;
            if (domains == null ? a.domains != null : !domains.equals(a.domains)) {
                return false;
            }
        }
        return true;
    }
}
