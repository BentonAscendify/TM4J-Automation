@java
Feature: Ascendify Sidekick

  Scenario: Add user from a resume database
    Given I navigate to "LinkedIn" page
    When I click on "Sign In" button on "LinkedIn Sign In" page TC
    And I sign in to LinkedIn
    And I click on "Sign In" button on "LinkedIn 2nd Sign In" page TC
    And save a candidate's resume to pdf
    Then I navigate to "CRM login" page
    And I sign in as super admin
    And "Main Menu" page is displayed PT
    Then I open Ascendify Sidekick Extension
    And I add the URL of my Ascendify app
    And  sign in to Ascendify Sidekick
    And I choose my file to be uploaded by clicking "Browse" button
    And I fill in the empty fields SK
    Then I navigate to "CRM login" page
    And "Main Menu" page is displayed PT
    And I clean up "LinkedIn" candidate