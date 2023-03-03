Feature: Open store
As a user 
I want to login into the store
So I can buy what I need

Scenario: Login into application
    Given I am in the login page
    When I enter standard_user in the username field
    And I enter secret_sauce in the password field
    And I click in Login button
    Then I should see the products page
    And I close the browser
