//
// This file generated by rdl 1.5.1. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;

//
// DomainTemplateList - List of solution templates to be applied to a domain
//
public class DomainTemplateList {
    public List<String> templateNames;

    public DomainTemplateList setTemplateNames(List<String> templateNames) {
        this.templateNames = templateNames;
        return this;
    }
    public List<String> getTemplateNames() {
        return templateNames;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != DomainTemplateList.class) {
                return false;
            }
            DomainTemplateList a = (DomainTemplateList) another;
            if (templateNames == null ? a.templateNames != null : !templateNames.equals(a.templateNames)) {
                return false;
            }
        }
        return true;
    }
}
