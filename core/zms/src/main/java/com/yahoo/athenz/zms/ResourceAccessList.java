//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;

//
// ResourceAccessList -
//
public class ResourceAccessList {
    public List<ResourceAccess> resources;

    public ResourceAccessList setResources(List<ResourceAccess> resources) {
        this.resources = resources;
        return this;
    }
    public List<ResourceAccess> getResources() {
        return resources;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ResourceAccessList.class) {
                return false;
            }
            ResourceAccessList a = (ResourceAccessList) another;
            if (resources == null ? a.resources != null : !resources.equals(a.resources)) {
                return false;
            }
        }
        return true;
    }
}
