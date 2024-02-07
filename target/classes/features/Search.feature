Feature: Search Functionality

Scenario: User searchs for a valid product
Given User navigates to Searchpage
When User enters Valid product "HP" into search box field
And Clicks on search button
Then User should get valid product displayed in search results

Scenario: User searchs for a invalid product
Given User navigates to Searchpage
When User enters inValid product "Honda" into search box field
And Clicks on search button
Then User should get a message about no prdouct match

Scenario: User searchs without any product
Given User navigates to Searchpage
When User dont enter any product name into search box field
And Clicks on search button
Then User should get a message about no prdouct match

