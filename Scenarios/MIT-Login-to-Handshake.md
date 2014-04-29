# Scenario:
MIT login to Handshake

## Classification:

MITRE as RP, MIT as IdP

## Description:
The Handshake site allows MITRE users to invite non-MITRE users to participate on the Handshake site. The goal is to allow MIT-affiliated users to log in with the [MIT IdP](https://oidc.mit.edu/) directly instead of requiring an account through MITRE Partnership Accounts (MPA). MIT affiliated users would still need to be invited by a MITRE user, they just wouldn't have a MITRE username/password anymore.

## People:
* Role: Inviter 
 * Parties: MITRE users
* Role: Invitee 
 * Parties: MIT affiliated user
* Role: Identity Providers (IdP)
 * Parties: MIT IdP

User Authority: MITRE employees invite particular email addresses, MIT binds that address to a particular credential account.

## Interactions:
* Inviter invites invitee
 * MITRE user invites external participant by entering email address in Handshake form. Handshake recognizes `@mit.edu` email address and sends custom invitation form.

## Data:
* IdP PII Released to MITRE: ("Basic User Info", Name/Email for Google, etc ...)
* Other? (Business Reporting? Log Data?)

## Lists:


###List contents:

* MIT IdP whitelisted by Handshake RP (logins limited to invited users only -- no standing invitation, no login)
* Handshake RP graylisted at MIT IdP

# Systems:
## Technology Systems:
* [Handshake](http://handshake.mitre.org/)
* [MIT OpenID Connect IdP](https://oidc.mit.edu/)
* Other?

## Business Systems:
* Handshake
* MITRE Partnership Network
* Other?

## Legal Systems:
* MITRE Partnership Network
* Handshake terms of service
* Other?

##Motivations:
* Business Drivers: 
 * Ease login and invitation for a class of external partners
* Business Inhibitors:
 * Security considerations of allowing non-MITRE IdP access to Handshake
 * Ability of Handshake to classify all users coming from MIT
* Goals:
 * TBD