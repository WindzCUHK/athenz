//
// This file generated by rdl 1.4.11. Do not modify!
//
package com.yahoo.athenz.zts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
// ResourceContext
//
public interface ResourceContext {
    public HttpServletRequest request();
    public HttpServletResponse response();
    public void authenticate();
    public void authorize(String action, String resource, String trustedDomain);
}
