@End-to-End
Feature: Talent Matching Tab

  Scenario: Add person from PDL data set
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "Talent Matching" tab TM
    And I select a requisition TM
    And I add a person to the job folder TM
    Then a new account is created for that person TM
    And I make sure that person is added to the job folder TM
    And I clean up "PDL User" TM