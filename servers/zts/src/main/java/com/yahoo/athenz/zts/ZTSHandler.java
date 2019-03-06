//
// This file generated by rdl 1.5.2. Do not modify!
//
package com.yahoo.athenz.zts;

import com.yahoo.rdl.*;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
// ZTSHandler is the interface that the service implementation must implement
//
public interface ZTSHandler { 
    ResourceAccess getResourceAccess(ResourceContext context, String action, String resource, String domain, String checkPrincipal);
    ResourceAccess getResourceAccessExt(ResourceContext context, String action, String resource, String domain, String checkPrincipal);
    ServiceIdentity getServiceIdentity(ResourceContext context, String domainName, String serviceName);
    ServiceIdentityList getServiceIdentityList(ResourceContext context, String domainName);
    PublicKeyEntry getPublicKeyEntry(ResourceContext context, String domainName, String serviceName, String keyId);
    HostServices getHostServices(ResourceContext context, String host);
    Response getDomainSignedPolicyData(ResourceContext context, String domainName, String matchingTag);
    RoleToken getRoleToken(ResourceContext context, String domainName, String role, Integer minExpiryTime, Integer maxExpiryTime, String proxyForPrincipal);
    RoleToken postRoleCertificateRequest(ResourceContext context, String domainName, String roleName, RoleCertificateRequest req);
    Access getAccess(ResourceContext context, String domainName, String roleName, String principal);
    RoleAccess getRoleAccess(ResourceContext context, String domainName, String principal);
    TenantDomains getTenantDomains(ResourceContext context, String providerDomainName, String userName, String roleName, String serviceName);
    Identity postInstanceRefreshRequest(ResourceContext context, String domain, String service, InstanceRefreshRequest req);
    AWSTemporaryCredentials getAWSTemporaryCredentials(ResourceContext context, String domainName, String role, Integer durationSeconds, String externalId);
    Identity postOSTKInstanceInformation(ResourceContext context, OSTKInstanceInformation info);
    Identity postOSTKInstanceRefreshRequest(ResourceContext context, String domain, String service, OSTKInstanceRefreshRequest req);
    Response postInstanceRegisterInformation(ResourceContext context, InstanceRegisterInformation info);
    InstanceIdentity postInstanceRefreshInformation(ResourceContext context, String provider, String domain, String service, String instanceId, InstanceRefreshInformation info);
    void deleteInstanceIdentity(ResourceContext context, String provider, String domain, String service, String instanceId);
    DomainMetrics postDomainMetrics(ResourceContext context, String domainName, DomainMetrics req);
    Status getStatus(ResourceContext context);
    Response postSSHCertRequest(ResourceContext context, SSHCertRequest certRequest);
    JWKList getJWKList(ResourceContext context);
    Schema getRdlSchema(ResourceContext context);
    ResourceContext newResourceContext(HttpServletRequest request, HttpServletResponse response);
}
