Feature: Party Consent deletion

Background:
Given launch salesforce application
And Enter username as 'cypress@testleaf.com'
And Enter password as 'Selbootcamp@1234'
Then Click on Login button

Scenario: Delete Party Consent record and verify

Then Click on Toggle button
And Click on View All Link
Given Enter application name as 'Party Consent'
Then Click on 'Party Consent' link
And search for existing record 'Raj Praveen'
And click on delete record 'Raj Praveen'
And click on confirm delete
And clear search record
When verify if record 'Raj Praveen' is deleted successfully