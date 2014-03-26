The following scenario template format is being used by the MIT Big Data Privacy Work Group.  It represents the approach of identifying the people (their roles/relaetionships), interactions among the people, the data in play and the relevant systems (business, legal and technical systems as relevant).

-----

#Privacy Impact Assessment Template
Daniel “Dazza” Greenwood, MIT. & Simon Thompson, BT.   
MIT Big Data Privacy Working Group, Feb 25, 2014   

# Elements of Privacy Impact Assessment: 

# 1. Components of scenario

* Actors? (ie: Who are the parties, their respective roles and relationships?  Who is data owner?  Who is using the data? Who are the data subjects?)

* Interactions? (ie: What transactions or other exchanges between Actors?)

* Data (ie: What kind of personal data?  What is type of big data models, analytics or other outputs result from this scenario? What’s the Data Lifecycle? What constraints apply:  e.g. Retention, liability for breach, and accuracy?)

* Systems? (ie What business, legal, technical or social system matter most?)
Business Systems (Ethics committees, sign-off by authorized officers, record keeping, audit) 
Legal Systems (Contracts, Employee rules/procedures, certification/accreditations, compliance reviews, insurance/bonding requirements, industry standard policy/guidelines, etc) 
Technical Systems (System permissions and security, alarms & automated detection of PAI, automatic anonymization of data, cryptography, etc) 

* Also, consider asking what the "Social Systems" are (What social systems and context exists?)

# 2. Analysis of scenario

* Goals (ie: What are the incentives and the benefits driving the Actors? who benefits? what are financial incentives?)

* Rules: (ie: What are the relevant laws and regulations, other enforceable rules)

* Risks: What are the risks? To whom? If the risk is an externality, how might it be mitigated?

# 3. Assessment of scenario

Existing or related best practices for context of this scenario
What business, legal and/or technical best practices 

# 4. Gap  

Issues Not Addressed by Existing Practices and Solutions
Short Fall Between Current and Needed Practices and Solutions

# Instructions 

Use the elements (context, practice and gap) in the privacy impact assessment above to create a structured assessment of the scenario you are working on. The objective is to produce something analogous to an abstract for a conference paper or the executive summary for a board paper. Check that each section for the assessment of a scenario has attempted to address each of the questions or examples in the sub bullets of the elements.

# Example PIA of Scenario

* Worked Example:

We have chosen one of the scenarios to use as a worked example; however the output that we have created is just a strawman to illustrate how to use the impact assessment and is not intended as the end product impact assessment to be delivered by the scenario sub team to the working group. 
Scenario #2: Research Infrastructure for Social Media

Social media represents rich grounds for researchers to obtain valuable ethnographic, epidemiological, and sociological data in order to study a wide variety of social phenomena. However, it is obvious that use of such data can infringe on user privacy, and must therefore be conducted with care. Aside from the initial use of the data, there are also questions about expectations for the life cycle and retention of the data.

# 1. Context of Research Infrastructure for Social Media Scenario

* Abstract:  

Study Participants are the subjects of data and have provided informed consent for the data to be transmitted by Social Media Provider to Researcher for purposes of research study.  Researchers receive data from Social Media Providers by permission of Subjects. The Researchers become data controllers of the copy of the data as of the time they receive it. The Social Media Providers remain as data controllers for the data set that they continue to maintain.

More Detailed Narrative: 

The incentive for the Study Participants and Social Media Providers is to act for the public good. The risk for the Study Participants is that they will be exposed to a breach of privacy. The Researchers may be acting for the public good or they may be acting to develop their career. 

The data exchanged may contain all aspects of personal identifying data including race, sexual and gender choice and political views. The data copy may be disposed of by the Researchers after the study or may be retained in a corpus for further study. The data copy must be held securely and the Researchers are liable for a breach. However the Social Media Provider may be liable if they have not assured that the Researchers are acting properly and also may risk collateral damage in the case of a breach even if the proper processes have been followed.  A variety of technology and systems will be used to store and transmit the data including internet links and various databases.  The data must be held according to the various Data Protection regulations in the territory that the data has been exported to (provided that the export is legal) 

# 1. Identify Components of the Scenario: 

Actors? (ie: Who are the parties, their respective roles and relationships?  Who is data owner?  Who is using the data? Who are the data subjects?)

Interactions? (eg What transactions or other exchanges between Actors?)

Data? (ie: What kind of personal data? what’s the  Data lifecycle? what constraints apply, eg: Retention, liability for breach, and accuracy?)

Systems? (ie What system are in play? What services, apps, other systems are being used by the Actors?)

# 2. Analyze the Scenario

Goals? (ie: What are the incentives and the benefits driving the Actors? who benefits? what are financial incentives?)

Risks? (ie What are the risks? :To whom? If the risk is an externality, how might it be mitigated?

Rules? (ie: What are the relevant laws and regulations, other enforceable rules)

Time? (ie: Is this scenario describing a situation that in reality happens now, or is this a prediction of how things may be in 1 year, 3 years, etc?) 

# 3. Existing or related best practices for context of this scenario

Typically an ethics committee would be required to give approval for work of this kind and an appropriate risk assessment undertaken to validate the arrangements that have been put in place to manage the data security and disclosure. 

In the UK organizations like the UK Data Archive can be consulted to manage the privacy processes and publication of results without breaching privacy. 

# 4. Gap

The management of access to data and the risks associated with publication present an impediment to the use of social media data. Gathering informed consent from social media users is particularly problematic. To enable research of this kind we need to streamline these processes and provide automatic verification of the safety of disclosures. 

__________________

Notes on scenario and relevant resources

This example is based on a study that is currently happening at the Technical University of Denmark in collaboration with the MIT Human Dynamics Lab.  However, references to potential downstream sharing arrangements by Participants and Researchers represent prospective future phase research and assume a future state of perhaps 1 - 3 years hence. 

Relevant Resources (related to applicable rules): 

* When Facebook as the data, these terms apply:

Platform Policy (Applies via Researcher’s Registered “Client” App/Service)
https://developers.facebook.com/policy
(see especially: https://developers.facebook.com/policy#data and https://developers.facebook.com/policy#definitions) 

Statement of Rights and Responsibilities
https://www.facebook.com/legal/terms

Data Use Policy
https://www.facebook.com/about/privacy

Facebook Community Standards
https://www.facebook.com/communitystandards

Facebook Principles [Note/Query: Does this constitute an enforceable source of rules?]
https://www.facebook.com/principles.php

* When the Researchers Receive the Data

SensibleDTU Example Computational Social Science Research Study 
https://www.sensible.dtu.dk/?page_id=89 

* When the Participants Share Downstream Via Personal Data Services

Placeholder 1: MIT Human Dynamics Lab Model Personal Data System Rules 
https://github.com/HumanDynamics/SystemRules/blob/master/Model_Personal_Data_System_Rules.md

Placeholder 2: Draft Data Rights Services Agreement
https://github.com/HumanDynamics/LegalAgreements/blob/master/DataRightsServicesAgreement.md
