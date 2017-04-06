//
// This file generated by rdl 1.4.12. Do not modify!
//

package com.yahoo.athenz.zms;
import com.yahoo.rdl.*;

//
// PublicKeyEntry - The representation of the public key in a service identity
// object.
//
public class PublicKeyEntry {
    public String key;
    public String id;

    public PublicKeyEntry setKey(String key) {
        this.key = key;
        return this;
    }
    public String getKey() {
        return key;
    }
    public PublicKeyEntry setId(String id) {
        this.id = id;
        return this;
    }
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != PublicKeyEntry.class) {
                return false;
            }
            PublicKeyEntry a = (PublicKeyEntry) another;
            if (key == null ? a.key != null : !key.equals(a.key)) {
                return false;
            }
            if (id == null ? a.id != null : !id.equals(a.id)) {
                return false;
            }
        }
        return true;
    }
}
