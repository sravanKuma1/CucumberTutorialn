Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid EmailAddress <UserName> into email field
And User enters vaild Password <Password> into password field
And User clicks on login button
Then user should successfully logged in
Examples:
|UserName|Password|
|Sravank5160@gmail.com|Sravan@4164|
|kumarsravan526@gmail.com|Sravan@4164|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid EmailAddress into email field
And User enters invaild Password "Sravn@4164" into password field
And User clicks on login button
Then user should get a warning message about credentails mismatch

Scenario: Login with valid email and  invalid password
Given User navigates to login page
When User enters valid EmailAddress "KumarSravan526@gmail.com" into email field
And User enters invaild Password "Sravn@4164" into password field
And User clicks on login button
Then user should get a warning message about credentails mismatch

Scenario: Login with invalid email and  valid password
Given User navigates to login page
When User enters invalid EmailAddress into email field
And User enters vaild Password "Sravan@4164" into password field
And User clicks on login button
Then user should get a warning message about credentails mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enters EmailAddress into email field
And User dont enters Password into password field
And User clicks on login button
Then user should get a warning message about credentails mismatch

















