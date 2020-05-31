@End-to-End
Feature: Admin Console

  Scenario: Add new user via User Accounts
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed AC
    And I go to Admin Console AC
    And I click on "New" button AC
    Then I manually add new user's profile AC
    And I click on "Save" button AC
    Then "User saved" message is displayed AC
    And I click on "People" tab AC
    And I make sure that new user is visible in People tab AC
    And I clean up "Manual User" AC