# Scenario:
[Journal of Social Media for Organizations](http://www2.mitre.org/public/jsmo/)

## Classification:

MITRE-facilitate RP (possibly on remote host)

MITRE as IdP (for MITRE people), other third party IdPs (for other people)

## Description:
The Journal of Social Media for Organizations (JSMO) is a peer-reviewed electronic journal published by MITRE. The journal is openly available a public web server (possibly run by MITRE, possibly run by a third party). There is a desire for public comments and discussion threads on the articles published, with participants from the general public. 

Desire is to allow anyone to comment but to cut down on spam and to have a chance of tracing back individual commenters for follow-up. 

Identity proofing of commenters is not required, pseudonymity is acceptable. 

## People:
* Role: Publisher 
 * Parties: MITRE via Jill Drury, Others?
* Role: Readers/Commenters 
 * Parties: MITRE Employees, MITRE partners, Identified Public
* Role: Identity Providers (IdP)
 * Parties: MITRE (for MITRE employees and partners), Third party TBD: Google? MIT?

## Interactions:
* Commenters use Social Login to access MITRE Online Journal for Comments
 - Commenters Authorize MITRE Online Journal (OpenID Connect Client) to their IdP for Login
 - Commenters Revoke Authorization for MITRE Online Journal to their IdP for Login

## Data:
* IdP PII Released to MITRE: ("Basic User Info", Name/Email for Google, etc ...)
* Other? (Business Reporting? Log Data?)

## Lists:

Whitelist at JSMO RP includes these aspects:

* Simplified login via NASCAR button

Graylist at JSMO RP facilitated by webfinger-style login (user enters an email address)


###List contents:

* MITRE IdP to be whitelisted by JSMO RP
* Some third-party IdPs (Google? MIT?) potentially to be whitelisted by JSMO RP
* All other OpenID Connect IdPs to be graylisted by JSMO RP

* JSMO RP to be whitelisted by MITRE IdP
* JSMO RP to be graylisted by third-party IdPs

# Systems:
## Technology Systems:
* [MITRE Web Site Platform](http://www.mitre.org/)
* [Journal of Social Media for Organizations (JSMO)](http://www2.mitre.org/public/jsmo/)
* [MITREid](https://id.mitre.org/about)
* Third Party IdPs
* Other?

## Business Systems:
* MITRE Publishing Unit (Collaboration Center of Excellence?)
* Other?

## Legal Systems:
* MITRE Partnership Network
* MITRE Boilerplate Overlay? (eg Terms and Conditions, Privacy Policy, EULA?)
* Other?

##Motivations:
* Business Drivers: 
 * Enable/increase comments
 * Reduce barriers to comments
* Business Inhibitors:
 * Security considerations of allowing remote login to MITRE's www site
 * Ability to enable social login on one section of the site without affecting other sections
* Goals:
 * TBD