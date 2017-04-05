//
// This file generated by rdl 1.4.12. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// ServerTemplateList - List of solution templates available in the server
//
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class ServerTemplateList {
    public List<String> templateNames;

    public ServerTemplateList setTemplateNames(List<String> templateNames) {
        this.templateNames = templateNames;
        return this;
    }
    public List<String> getTemplateNames() {
        return templateNames;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ServerTemplateList.class) {
                return false;
            }
            ServerTemplateList a = (ServerTemplateList) another;
            if (templateNames == null ? a.templateNames != null : !templateNames.equals(a.templateNames)) {
                return false;
            }
        }
        return true;
    }
}
