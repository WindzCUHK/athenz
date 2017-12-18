//
// This file generated by rdl 1.4.14
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;

public class ZTSSchema {

    private final static Schema INSTANCE = build();
    public static Schema instance() {
        return INSTANCE;
    }

    private static Schema build() {
        SchemaBuilder sb = new SchemaBuilder("ZTS");
        sb.version(1);
        sb.namespace("com.yahoo.athenz.zts");
        sb.comment("Copyright 2016 Yahoo Inc. Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms. The Authorization Token Service (ZTS) API");

        sb.stringType("SimpleName")
            .comment("Copyright 2016 Yahoo Inc. Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms. Common name types used by several API definitions A simple identifier, an element of compound name.")
            .pattern("[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("CompoundName")
            .comment("A compound name. Most names in this API are compound names.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("DomainName")
            .comment("A domain name is the general qualifier prefix, as its uniqueness is managed.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityName")
            .comment("An entity name is a short form of a resource name, including only the domain and entity.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityList")
            .comment("An Entity list is comma separated compound Names")
            .pattern("(([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*,)*([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ServiceName")
            .comment("A service name will generally be a unique subdomain.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ActionName")
            .comment("An action (operation) name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ResourceName")
            .comment("A resource name Note that the EntityName part is optional, that is, a domain name followed by a colon is valid resource name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*(:([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*)?");

        sb.stringType("YBase64")
            .comment("The Y-specific URL-safe Base64 variant.")
            .pattern("[a-zA-Z0-9\\._-]+");

        sb.stringType("YEncoded")
            .comment("YEncoded includes ybase64 chars, as well as = and %. This can represent a user cookie and URL-encoded values.")
            .pattern("[a-zA-Z0-9\\._%=-]*");

        sb.stringType("AuthorityName")
            .comment("Used as the prefix in a signed assertion. This uniquely identifies a signing authority.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("SignedToken")
            .comment("A signed assertion if identity. i.e. the user cookie value. This token will only make sense to the authority that generated it, so it is beneficial to have something in the value that is cheaply recognized to quickly reject if it belongs to another authority. In addition to the YEncoded set our token includes ; to separate components and , to separate roles")
            .pattern("[a-zA-Z0-9\\._%=;,-]*");

        sb.stringType("PathElement")
            .comment("A uri-safe path element")
            .pattern("[a-zA-Z0-9-\\._~=+@$,:]*");

        sb.structType("ResourceAccess")
            .comment("ResourceAccess can be checked and returned as this resource. (same as ZMS.Access)")
            .field("granted", "Bool", false, "true (allowed) or false (denied)");

        sb.structType("PublicKeyEntry")
            .comment("The representation of the public key in a service identity object.")
            .field("key", "String", false, "the public key for the service")
            .field("id", "String", false, "the key identifier (version or zone name)");

        sb.structType("ServiceIdentity")
            .comment("The representation of the service identity object.")
            .field("name", "ServiceName", false, "the full name of the service, i.e. \"sports.storage\"")
            .arrayField("publicKeys", "PublicKeyEntry", true, "array of public keys for key rotation")
            .field("providerEndpoint", "String", true, "if present, then this service can provision tenants via this endpoint.")
            .field("modified", "Timestamp", true, "the timestamp when this entry was last modified")
            .field("executable", "String", true, "the path of the executable that runs the service")
            .arrayField("hosts", "String", true, "list of host names that this service can run on")
            .field("user", "String", true, "local (unix) user name this service can run as")
            .field("group", "String", true, "local (unix) group name this service can run as");

        sb.structType("ServiceIdentityList")
            .comment("The representation for an enumeration of services in the namespace.")
            .arrayField("names", "EntityName", false, "list of service names");

        sb.structType("HostServices")
            .comment("The representation for an enumeration of services authorized to run on a specific host.")
            .field("host", "String", false, "name of the host")
            .arrayField("names", "EntityName", false, "list of service names authorized to run on this host");

        sb.enumType("AssertionEffect")
            .comment("Every assertion can have the effect of ALLOW or DENY.")
            .element("ALLOW")
            .element("DENY");

        sb.structType("Assertion")
            .comment("A representation for the encapsulation of an action to be performed on a resource by a principal.")
            .field("role", "String", false, "the subject of the assertion, a role")
            .field("resource", "String", false, "the object of the assertion. Must be in the local namespace. Can contain wildcards")
            .field("action", "String", false, "the predicate of the assertion. Can contain wildcards")
            .field("effect", "AssertionEffect", true, "the effect of the assertion in the policy language", AssertionEffect.ALLOW)
            .field("id", "Int64", true, "assertion id - auto generated by server");

        sb.structType("Policy")
            .comment("The representation for a Policy with set of assertions.")
            .field("name", "ResourceName", false, "name of the policy")
            .field("modified", "Timestamp", true, "last modification timestamp of this policy")
            .arrayField("assertions", "Assertion", false, "list of defined assertions for this policy");

        sb.structType("PolicyData")
            .field("domain", "DomainName", false, "name of the domain")
            .arrayField("policies", "Policy", false, "list of policies defined in this server");

        sb.structType("SignedPolicyData")
            .comment("A representation of policies object defined in a given server.")
            .field("policyData", "PolicyData", false, "list of policies defined in a domain")
            .field("zmsSignature", "String", false, "zms signature generated based on the domain policies object")
            .field("zmsKeyId", "String", false, "the identifier of the zms key used to generate the signature")
            .field("modified", "Timestamp", false, "when the domain itself was last modified")
            .field("expires", "Timestamp", false, "timestamp specifying the expiration time for using this set of policies");

        sb.structType("DomainSignedPolicyData")
            .comment("A signed bulk transfer of policies. The data is signed with server's private key.")
            .field("signedPolicyData", "SignedPolicyData", false, "policy data signed by ZMS")
            .field("signature", "String", false, "signature generated based on the domain policies object")
            .field("keyId", "String", false, "the identifier of the key used to generate the signature");

        sb.structType("RoleToken")
            .comment("A representation of a signed RoleToken")
            .field("token", "String", false, "")
            .field("expiryTime", "Int64", false, "");

        sb.structType("RoleCertificateRequest")
            .comment("RoleCertificateRequest - a certificate signing request")
            .field("csr", "String", false, "")
            .field("expiryTime", "Int64", false, "");

        sb.structType("Access")
            .comment("Access can be checked and returned as this resource.")
            .field("granted", "Bool", false, "true (allowed) or false (denied)");

        sb.structType("RoleAccess")
            .arrayField("roles", "EntityName", false, "");

        sb.structType("TenantDomains")
            .arrayField("tenantDomainNames", "DomainName", false, "");

        sb.structType("Identity")
            .comment("Identity - a signed assertion of service or human identity, the response could be either a client certificate or just a regular NToken (depending if the request contained a csr or not).")
            .field("name", "CompoundName", false, "name of the identity, fully qualified, i.e. my.domain.service1, or aws.1232321321312.myusername")
            .field("certificate", "String", true, "a certificate usable for both client and server in TLS connections")
            .field("caCertBundle", "String", true, "the CA certificate chain to use with all IMS-generated certs")
            .field("sshCertificate", "String", true, "the SSH certificate, signed by the CA (user or host)")
            .field("sshCertificateSigner", "String", true, "the SSH CA's public key for the sshCertificate (user or host)")
            .field("serviceToken", "SignedToken", true, "service token instead of TLS certificate")
            .mapField("attributes", "String", "String", true, "other config-like attributes determined at boot time");

        sb.structType("InstanceRefreshRequest")
            .comment("InstanceRefreshRequest - a certificate refresh request")
            .field("csr", "String", false, "Cert CSR signed by the service's private key (public key registered in ZMS)")
            .field("expiryTime", "Int32", true, "in seconds how long token should be valid for")
            .field("keyId", "String", true, "public key identifier");

        sb.stringType("AWSRoleName")
            .comment("AWS role name without the path")
            .pattern("[a-zA-Z0-9-\\._=+@,]*");

        sb.stringType("AWSRolePathElement")
            .comment("AWS role path single element")
            .pattern("[a-zA-Z0-9][a-zA-Z0-9-\\._]*");

        sb.stringType("AWSRolePath")
            .comment("AWS role path")
            .pattern("([a-zA-Z0-9][a-zA-Z0-9-\\._]*/)+");

        sb.stringType("AWSArnRoleName")
            .comment("AWS full role name with path")
            .pattern("(([a-zA-Z0-9][a-zA-Z0-9-\\._]*/)+)*[a-zA-Z0-9-\\._=+@,]*");

        sb.structType("AWSTemporaryCredentials")
            .field("accessKeyId", "String", false, "")
            .field("secretAccessKey", "String", false, "")
            .field("sessionToken", "String", false, "")
            .field("expiration", "Timestamp", false, "");

        sb.structType("OSTKInstanceInformation")
            .comment("Instance object that includes requested service details plus host document that is signed by Openstack as part of the host bootstrap process")
            .field("document", "String", false, "signed document containing attributes like IP address, instance-id, account#, etc.")
            .field("signature", "String", false, "the signature for the document")
            .field("keyId", "String", false, "the keyid used to sign the document")
            .field("domain", "CompoundName", false, "the domain of the instance")
            .field("service", "SimpleName", false, "the service this instance is supposed to run")
            .field("csr", "String", false, "return a certificate in the response");

        sb.structType("OSTKInstanceRefreshRequest")
            .comment("OSTKCertificateRequest - a certificate signing request")
            .field("csr", "String", true, "request an X.509 certificate");

        sb.structType("InstanceRegisterInformation")
            .field("provider", "ServiceName", false, "the provider service name (i.e. \"aws.us-west-2\", \"sys.openstack.cluster1\")")
            .field("domain", "DomainName", false, "the domain of the instance")
            .field("service", "SimpleName", false, "the service this instance is supposed to run")
            .field("attestationData", "String", false, "identity attestation data including document with its signature containing attributes like IP address, instance-id, account#, etc.")
            .field("csr", "String", false, "the Certificate Signing Request for the expected X.509 certificate in the response")
            .field("ssh", "String", true, "if present, return an SSH host certificate. Format is JSON.")
            .field("token", "Bool", true, "if true, return a service token signed by ZTS for this service");

        sb.structType("InstanceRefreshInformation")
            .field("attestationData", "String", true, "identity attestation data including document with its signature containing attributes like IP address, instance-id, account#, etc.")
            .field("csr", "String", true, "the Certificate Signing Request for the expected X.509 certificate in the response")
            .field("ssh", "String", true, "if present, return an SSH host certificate. Format is JSON.")
            .field("token", "Bool", true, "if true, return a service token signed by ZTS for this service");

        sb.structType("InstanceIdentity")
            .field("provider", "ServiceName", false, "the provider service name (i.e. \"aws.us-west-2\", \"sys.openstack.cluster1\")")
            .field("name", "ServiceName", false, "name of the identity, fully qualified, i.e. my.domain.service1")
            .field("instanceId", "PathElement", false, "unique instance id within provider's namespace")
            .field("x509Certificate", "String", true, "an X.509 certificate usable for both client and server in TLS connections")
            .field("x509CertificateSigner", "String", true, "the CA certificate chain to verify all generated X.509 certs")
            .field("sshCertificate", "String", true, "the SSH certificate, signed by the CA (user or host)")
            .field("sshCertificateSigner", "String", true, "the SSH CA's public key for the sshCertificate (user or host)")
            .field("serviceToken", "SignedToken", true, "service token instead of TLS certificate")
            .mapField("attributes", "String", "String", true, "other config-like attributes determined at boot time");

        sb.enumType("DomainMetricType")
            .comment("zpe metric attributes")
            .element("ACCESS_ALLOWED")
            .element("ACCESS_ALLOWED_DENY")
            .element("ACCESS_ALLOWED_DENY_NO_MATCH")
            .element("ACCESS_ALLOWED_ALLOW")
            .element("ACCESS_ALLOWED_ERROR")
            .element("ACCESS_ALLOWED_TOKEN_INVALID")
            .element("ACCESS_Allowed_TOKEN_EXPIRED")
            .element("ACCESS_ALLOWED_DOMAIN_NOT_FOUND")
            .element("ACCESS_ALLOWED_DOMAIN_MISMATCH")
            .element("ACCESS_ALLOWED_DOMAIN_EXPIRED")
            .element("ACCESS_ALLOWED_DOMAIN_EMPTY")
            .element("ACCESS_ALLOWED_TOKEN_CACHE_FAILURE")
            .element("ACCESS_ALLOWED_TOKEN_CACHE_NOT_FOUND")
            .element("ACCESS_ALLOWED_TOKEN_CACHE_SUCCESS")
            .element("ACCESS_ALLOWED_TOKEN_VALIDATE")
            .element("LOAD_FILE_FAIL")
            .element("LOAD_FILE_GOOD")
            .element("LOAD_DOMAIN_GOOD");

        sb.structType("DomainMetric")
            .field("metricType", "DomainMetricType", false, "")
            .field("metricVal", "Int32", false, "");

        sb.structType("DomainMetrics")
            .field("domainName", "DomainName", false, "name of the domain the metrics pertain to")
            .arrayField("metricList", "DomainMetric", false, "list of the domains metrics");

        sb.structType("Status")
            .comment("The representation for a status object")
            .field("code", "Int32", false, "status message code")
            .field("message", "String", false, "status message of the server");


        sb.resource("ResourceAccess", "GET", "/access/{action}/{resource}")
            .comment("Check access for the specified operation on the specified resource for the currently authenticated user. This is the slow centralized access for control-plane purposes. Use distributed mechanisms for decentralized (data-plane) access by fetching signed policies and role tokens for users. With this endpoint the resource is part of the uri and restricted to its strict definition of resource name. If needed, you can use the GetAccessExt api that allows resource name to be less restrictive.")
            .pathParam("action", "ActionName", "action as specified in the policy assertion, i.e. update or read")
            .pathParam("resource", "ResourceName", "the resource to check access against, i.e. \"media.news:articles\"")
            .queryParam("domain", "domain", "DomainName", null, "usually null. If present, it specifies an alternate domain for cross-domain trust relation")
            .queryParam("principal", "checkPrincipal", "EntityName", null, "usually null. If present, carry out the access check for this principal")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("ResourceAccess", "GET", "/access/{action}")
            .comment("Check access for the specified operation on the specified resource for the currently authenticated user. This is the slow centralized access for control-plane purposes.")
            .name("GetResourceAccessExt")
            .pathParam("action", "ActionName", "action as specified in the policy assertion, i.e. update or read")
            .queryParam("resource", "resource", "String", null, "the resource to check access against, i.e. \"media.news:articles\"")
            .queryParam("domain", "domain", "DomainName", null, "usually null. If present, it specifies an alternate domain for cross-domain trust relation")
            .queryParam("principal", "checkPrincipal", "EntityName", null, "usually null. If present, carry out the access check for this principal")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("ServiceIdentity", "GET", "/domain/{domainName}/service/{serviceName}")
            .comment("Get info for the specified ServiceIdentity.")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("serviceName", "ServiceName", "name of the service to be retrieved")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("ServiceIdentityList", "GET", "/domain/{domainName}/service")
            .comment("Enumerate services provisioned in this domain.")
            .pathParam("domainName", "DomainName", "name of the domain")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("PublicKeyEntry", "GET", "/domain/{domainName}/service/{serviceName}/publickey/{keyId}")
            .comment("Retrieve the specified public key from the service.")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("serviceName", "SimpleName", "name of the service")
            .pathParam("keyId", "String", "the identifier of the public key to be retrieved")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")
;

        sb.resource("HostServices", "GET", "/host/{host}/services")
            .comment("Enumerate services provisioned on a specific host")
            .pathParam("host", "String", "name of the host")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")
;

        sb.resource("DomainSignedPolicyData", "GET", "/domain/{domainName}/signed_policy_data")
            .comment("Get a signed policy enumeration from the service, to transfer to a local store. An ETag is generated for the PolicyList that changes when any item in the list changes. If the If-None-Match header is provided, and it matches the ETag that would be returned, then a NOT_MODIFIED response is returned instead of the list.")
            .pathParam("domainName", "DomainName", "name of the domain")
            .headerParam("If-None-Match", "matchingTag", "String", null, "Retrieved from the previous request, this timestamp specifies to the server to return any policies modified since this time")
            .output("ETag", "tag", "String", "The current latest modification timestamp is returned in this header")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")
;

        sb.resource("RoleToken", "GET", "/domain/{domainName}/token")
            .comment("Return a security token for the specific role in the namespace that the principal can assume. If the role is omitted, then all roles in the namespace that the authenticated user can assume are returned. the caller can specify how long the RoleToken should be valid for by specifying the minExpiryTime and maxExpiryTime parameters. The minExpiryTime specifies that the returned RoleToken must be at least valid (min/lower bound) for specified number of seconds, while maxExpiryTime specifies that the RoleToken must be at most valid (max/upper bound) for specified number of seconds. If both values are the same, the server must return a RoleToken for that many seconds. If no values are specified, the server's default RoleToken Timeout value is used.")
            .pathParam("domainName", "DomainName", "name of the domain")
            .queryParam("role", "role", "EntityList", null, "only interested for a token for these comma separated roles")
            .queryParam("minExpiryTime", "minExpiryTime", "Int32", null, "in seconds min expiry time")
            .queryParam("maxExpiryTime", "maxExpiryTime", "Int32", null, "in seconds max expiry time")
            .queryParam("proxyForPrincipal", "proxyForPrincipal", "EntityName", null, "optional this request is proxy for this principal")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("RoleCertificateRequest", "POST", "/domain/{domainName}/role/{roleName}/token")
            .comment("Return a TLS certificate for the specific role in the namespace that the principal can assume. Role certificates are valid for 30 days by default")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("roleName", "EntityName", "name of role")
            .input("req", "RoleCertificateRequest", "csr request")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("Access", "GET", "/access/domain/{domainName}/role/{roleName}/principal/{principal}")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("roleName", "EntityName", "name of the role to check access for")
            .pathParam("principal", "EntityName", "carry out the access check for this principal")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("RoleAccess", "GET", "/access/domain/{domainName}/principal/{principal}")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("principal", "EntityName", "carry out the role access lookup for this principal")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("TenantDomains", "GET", "/providerdomain/{providerDomainName}/user/{userName}")
            .comment("Get list of tenant domains user has access to for specified provider domain and service")
            .pathParam("providerDomainName", "DomainName", "name of the provider domain")
            .pathParam("userName", "EntityName", "name of the user to retrieve tenant domain access for")
            .queryParam("roleName", "roleName", "EntityName", null, "role name to filter on when looking for the tenants in provider")
            .queryParam("serviceName", "serviceName", "ServiceName", null, "service name to filter on when looking for the tenants in provider")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("InstanceRefreshRequest", "POST", "/instance/{domain}/{service}/refresh")
            .comment("Refresh Service tokens into TLS Certificate")
            .pathParam("domain", "CompoundName", "name of the domain requesting the refresh")
            .pathParam("service", "SimpleName", "name of the service requesting the refresh")
            .input("req", "InstanceRefreshRequest", "the refresh request")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("INTERNAL_SERVER_ERROR", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("AWSTemporaryCredentials", "GET", "/domain/{domainName}/role/{role}/creds")
            .comment("perform an AWS AssumeRole of the target role and return the credentials. ZTS must have been granted the ability to assume the role in IAM, and granted the ability to ASSUME_AWS_ROLE in Athenz for this to succeed.")
            .pathParam("domainName", "DomainName", "name of the domain containing the role, which implies the target account")
            .pathParam("role", "AWSArnRoleName", "the target AWS role name in the domain account, in Athenz terms, i.e. \"the.role\"")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("OSTKInstanceInformation", "POST", "/ostk/instance")
            .comment("Get a cert for service being bootstrapped by Openstack")
            .input("info", "OSTKInstanceInformation", "")
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("INTERNAL_SERVER_ERROR", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("OSTKInstanceRefreshRequest", "POST", "/ostk/instance/{domain}/{service}/refresh")
            .comment("Refresh self identity if the original identity was issued by ZTS The token must include the original requestor's name and the server will verify that the service still has authorization to grant inception to the current service requesting to refresh its identity")
            .pathParam("domain", "CompoundName", "name of the tenant domain")
            .pathParam("service", "SimpleName", "name of the tenant service")
            .input("req", "OSTKInstanceRefreshRequest", "the refresh request")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("INTERNAL_SERVER_ERROR", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("InstanceRegisterInformation", "POST", "/instance")
            .input("info", "InstanceRegisterInformation", "")
            .output("Location", "location", "String", "return location for subsequent patch requests")
            .expected("CREATED")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("INTERNAL_SERVER_ERROR", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("InstanceRefreshInformation", "POST", "/instance/{provider}/{domain}/{service}/{instanceId}")
            .comment("only TLS Certificate authentication is allowed")
            .pathParam("provider", "ServiceName", "the provider service name (i.e. \"aws.us-west-2\", \"paas.manhattan.corp-gq1\")")
            .pathParam("domain", "DomainName", "the domain of the instance")
            .pathParam("service", "SimpleName", "the service this instance is supposed to run")
            .pathParam("instanceId", "PathElement", "unique instance id within provider's namespace")
            .input("info", "InstanceRefreshInformation", "the refresh request")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("INTERNAL_SERVER_ERROR", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("InstanceIdentity", "DELETE", "/instance/{provider}/{domain}/{service}/{instanceId}")
            .pathParam("provider", "ServiceName", "the provider service name (i.e. \"aws.us-west-2\", \"paas.manhattan.corp-gq1\")")
            .pathParam("domain", "DomainName", "the domain of the instance")
            .pathParam("service", "SimpleName", "the service this instance is supposed to run")
            .pathParam("instanceId", "PathElement", "unique instance id within provider's namespace")
            .auth("delete", "{domain}:instance.{instanceId}")
            .expected("NO_CONTENT")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("INTERNAL_SERVER_ERROR", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("DomainMetrics", "POST", "/metrics/{domainName}")
            .comment("called to post multiple zpe related metric attributes")
            .pathParam("domainName", "DomainName", "name of the domain the metrics pertain to")
            .input("req", "DomainMetrics", "")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("Status", "GET", "/status")
            .comment("Retrieve the server status")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;


        return sb.build();
    }

}
