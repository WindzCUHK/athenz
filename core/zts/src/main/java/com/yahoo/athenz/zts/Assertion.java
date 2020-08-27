//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zts;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// Assertion - A representation for the encapsulation of an action to be
// performed on a resource by a principal.
//
public class Assertion {
    public String role;
    public String resource;
    public String action;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public AssertionEffect effect;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long id;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean caseSensitive;

    public Assertion setRole(String role) {
        this.role = role;
        return this;
    }
    public String getRole() {
        return role;
    }
    public Assertion setResource(String resource) {
        this.resource = resource;
        return this;
    }
    public String getResource() {
        return resource;
    }
    public Assertion setAction(String action) {
        this.action = action;
        return this;
    }
    public String getAction() {
        return action;
    }
    public Assertion setEffect(AssertionEffect effect) {
        this.effect = effect;
        return this;
    }
    public AssertionEffect getEffect() {
        return effect;
    }
    public Assertion setId(Long id) {
        this.id = id;
        return this;
    }
    public Long getId() {
        return id;
    }
    public Assertion setCaseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }
    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Assertion.class) {
                return false;
            }
            Assertion a = (Assertion) another;
            if (role == null ? a.role != null : !role.equals(a.role)) {
                return false;
            }
            if (resource == null ? a.resource != null : !resource.equals(a.resource)) {
                return false;
            }
            if (action == null ? a.action != null : !action.equals(a.action)) {
                return false;
            }
            if (effect == null ? a.effect != null : !effect.equals(a.effect)) {
                return false;
            }
            if (id == null ? a.id != null : !id.equals(a.id)) {
                return false;
            }
            if (caseSensitive == null ? a.caseSensitive != null : !caseSensitive.equals(a.caseSensitive)) {
                return false;
            }
        }
        return true;
    }
}
