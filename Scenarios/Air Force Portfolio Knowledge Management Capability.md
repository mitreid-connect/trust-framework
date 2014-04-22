# Air Force Portfolio Knowledge Management Capability

## Description
The capability is a repository of work products (not necessarily approved for public release) created by MITRE under our Air Force work program. The products are accessible to MITRE and external sponsors, customers, and stakeholders.

The repository is currently piloted in MITRE Community Share Partners (SharePoint repository accessible to MITRE and external partners). Currently, users (including MITRE) need to be individually authorized to access the repository using the MITRE Partnership Accounts platform. Users first need to be pre-registered as valid users and then fully register for access/membership. 

The primary means of vectoring Air Force stakeholders to the site is from a newsletter emailed by MITRE managers. The e-newsletter (PDF) provides summaries of workproducts with links to the repository and email addresses of authors. When a user clicks on a link the newsletter, their browser directs them to the repository login/registration page.
  
There is a desire for registration to be opened (without invitation) to .mil and .gov domains and CAC card holders. Membership approval would still be driven by a list of pre-authorized users.    

## Roles

- **Current identity provider:** MITRE provides user name
- **Potential: OpenID Connect**
	- **RP:** MITRE Community Share Partners website
	- **IdP:** 
		- MITRE OpenID for MITRE employees
		- CAC for government holders
- **Content Publisher:** MITRE information repository manager provides quality assurance review prior to publishing on site
- **Inviter:** MITRE
- **Invitee:** Air Force stakeholders and MITRE users

## Interactions

- MITRE repository manager pre-registers valid usernames (email addresses)
- MITRE portfolio directors and other leaders email newsletters with links to the repository to Air Force stakeholders
- Air Force stakeholders register/login as needed

## Data
- Username and password
- Other profile information entered by users from MITRE Partnership Accounts platform
- Potentially when government is IdP: basic identity information released to MITRE

## Lists (if ID is federated)

- MITRE as IdP
	- MITRE RP SharePoint repository is whitelisted: MITRE users don't need to expressly login
- Government as IdP: CAC card
	- MITRE RP repository is greylisted
- MITRE repository as RP
	- OpenID is whitelisted
	- CACs are whitelisted

## Systems

- Currently "as is"
	- MITRE Community Share Partners: [Air Force Portfolio Vectors](https://partners.mitre.org/sites/afpa/default.aspx) site
	- [MITRE Partnership Accounts](https://partnership.mitre.org/MCAP/login.jsp): Invited non-MITRE users provisioned with a username and password at MITRE.
- Additionally, "could be" if ID is federated
	- [MITRE OpenID Connect](https://id.mitre.org/)
	- Government CAC


## Business Touchpoints
- MITRE nominates content for publication in SharePoint collection and MITRE collection manager approves and uploads
- MITRE portfolio managers and other MITRE leaders invite external stakeholders to be members of SharePoint collection
- External stakeholders interact with MPA and the Sharepoint collection 
- Potential future information sources for the collection: Quality Work Flow and CNS Technical Product Library  

## Legal Touchpoints
- MITRE Community Share Partners Terms of Service
- MITRE Partnership Accounts Terms of Service
- Potential future touchpoint: MITRE OpenID Connect Terms of Service

##Identity-Related Value Proposition
- Ease of login for stakeholders

##Risks and Mitigations

- **R1:** Unknown external stakeholders will have access to non-public MITRE information
- **M1:** Users will be individually invited and pre-authorized as valid users

##Challenges
- Maintaining list of pre-approved government users
  