Feature: Validating trust basic details using Lixi Model

Scenario: Success reponse status code 200

Given Loan Market broker is on the validate API
When  the user enter valid details
Then  the validation should be successfull
And   the status code should be 200



Scenario: Failure reponse status code 400 
Given Loan Market broker is on the validate API
When  the user enter invalid details
Then  the validation should not be successfull
And   the status code should come 400
