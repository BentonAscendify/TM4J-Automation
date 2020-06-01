@End-to-End
Feature: Organizations

  Scenario: Add new user via Hiring Team
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed ORG
    And I go to "Organizations" Tab ORG
    And I choose an organization ORG
    And I go to "Hiring Team" Tab ORG
    Then I manually add new user's profile ORG
    And I click on "Add Profile" button ORG
    Then "New user was added" message is displayed ORG
    And I make sure that Organize functions in the form are working as expected ORG
    And I clean up "Manual User" ORG