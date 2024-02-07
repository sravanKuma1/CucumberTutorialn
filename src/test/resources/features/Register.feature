Feature: Register Functionality

Scenario: User creates account only with mandatory fields
Given User navigates to RegisterAccount Page
When User enters below fields
|FirstName			|Sravan						|
|LastName				|Kumar						|
|Email					|Sravan@gmail.com	|
|Telephone			|8121288888				|
|password				|123456						|
And User selects privacy policy 
And User clicks on continue button
Then User account should be created


Scenario: User creates account with all fields
Given User navigates to RegisterAccount Page
When User enters below fields
|FirstName			|Sravan						|
|LastName				|Kumar						|
|Email					|Sravan@gmail.com	|
|Telephone			|8121288888				|
|password				|123456						|
And User selects Yes for NewsLetter
And User selects privacy policy 
And User clicks on continue button
Then User account should be created

Scenario: User creates account with duplicate Email
Given User navigates to RegisterAccount Page
When User enters below fields with duplicate email
|FirstName			|Sravan									|
|LastName				|Kumar									|
|Email					|sravank5160@gmail.com	|
|Telephone			|8121288888							|
|password				|123456									|
And User selects Yes for NewsLetter
And User selects privacy policy 
And User clicks on continue button
Then User Should get proper warning message about duplicate email 


Scenario: User creates an account without filling any details
Given User navigates to RegisterAccount Page
When User dont enter any details into fields 
And User clicks on continue button
Then User Should get proper warning message for every mandatory field 

