#Modules

## Roles

**IdP**: Identity provider, the service that asserts identities for users. Must use a federated identity protocol. Known as the Authorization Server (AS) in OAuth parlance. 

**RP**: Relying party, the site being logged into. Must use a federated identity protocol. Known as the Client in OAuth parlance.

## MITRE as IdP

This section lists the components as they come into play when MITRE is the IdP.

### Instances

MITRE runs three IdP Instances

* `id.mitre.org`: Current MITRE employees
* `cacproxy.mitre.org`: CAC holders
* `partnerid.mitre.org`: Invited non-MITRE users provisioned with a username and password at MITRE


### Lists

Lists are maintained on a per-IdP instance basis. A client may appear on multiple lists across different IdP instances.

#### Whitelist

A list of pre-authorized RPs and the conditions under which users will not be prompted (such as a list of pre-approved scopes). 

#### Blacklist

A list of forbidden RPs that authorized users MUST NOT log in to and will be prevented from doing so by the IdP. This usually takes the form of a set of redirect URIs that are not allowed to be registered.

#### Graylist

A list of RPs authorized by end-users during runtime security decisions. For any client not on the whitelist or the blacklist, it will be automatically put on the graylist and the end user will be prompted with an authorization screen. These decisions MUST track the initial login time and the latest access time. The IdP SHOULD log all authorizations and accesses into an event log.

### Static Clients

Clients that are registered with the IdP by an authorized system administrator. These clients may be whitelisted by a system administrator but are considered gray listed by default. Static clients can be registered with advanced access controls not available to dynamic clients.

### Dynamic Clients

Clients that are registered programmatically (using a Dynamic Registration protocol) or through a self-service portal, but not by a system administrator. These clients are almost always gray listed and only rarely are whitelisted. Dynamic clients will have access to a limited set of identity services when compared to a statically registered client.

## MITRE as RP

This section defines the components as they come into play when MITRE is the RP.

### Lists

Lists are maintained on a per-RP basis. 

#### Whitelist

A list of pre-authorized (and trusted) IdPs. Usually, the RP will be statically registered with one of these IdPs and may itself be whitelisted at the IdP, but neither of these are necessary conditions. The RP will provide to the user a list of authorized IdPs from which to choose or will automatically direct the user to the appropriate IdP.

#### Blacklist

A list of forbidden IdPs that are explicitly not trusted to provide identity. All users coming from a blacklisted IdP will be blocked by the RP from logging in.

#### Graylist

A list of IdPs that end users have provided to the RP for login purposes over time. The RP will usually present the user with an input field and use a discovery protocol like Webfinger to allow the user to specify an arbitrary IdP. 

### Static Registration

The RP has been (or must be) registered by an authorized system administrator at the IdP. This requires some form of out-of-band communication.

### Dynamic Registration

The RP is registered programmatically or through the use of some kind of self-service portal.