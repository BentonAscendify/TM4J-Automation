@End-to-End
Feature: Requisitions Tab

  Scenario: Create a requisition manually
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I create a new requisition REQ
    And I change status to Open REQ
    And I check each tab on the new requisition REQ
    Then I delete the new requisition REQ

  Scenario: Create bulk requisition by adding CSV file
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I upload a "CSV file" REQ
    And I map the fields and import the .CSV file REQ
    And I clean up "CSV" REQ

  Scenario: Edit and Add Custom Requisition field
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to a requisition with Test Community! org REQ
    Then I add and save custom requisition field questions' answers REQ

  Scenario: Add and Delete Document
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Documents" tab of a requisition REQ
    Then I upload a "Document" REQ
    And I delete the document REQ

  Scenario: Add and Remove Primary Users
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Team" tab of a requisition REQ
    Then I add and remove primary users REQ

  Scenario: Add and delete skills & categories
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Skills" tab of a requisition REQ
    Then I add and delete skills and categories REQ

  Scenario: Add and delete qualifying questions
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Qualifying Questions" tab of a requisition REQ
    Then I add and delete qualifying questions REQ

  Scenario: Add and delete screening questions
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Screening Questions" tab of a requisition REQ
    Then I add and delete screening questions REQ

  Scenario: Edit and save intake form
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Intake Form" tab of a requisition REQ
    Then I edit and save intake form REQ

  Scenario: Check activities
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Activity" tab of a requisition REQ
    Then I check all the activities REQ

  Scenario: Add and delete notes
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Notes" tab of a requisition REQ
    Then I add and delete private and public notes REQ

  Scenario: Add and delete workflow statuses
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Workflow Statuses" tab of a requisition REQ
    Then I add and delete workflow statuses REQ

  Scenario: Send approvals
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I navigate to "Approvals" tab of a requisition REQ
    Then I add and send approval request REQ

  Scenario: Create and apply for a requisition
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I create a person's profile with role Recruiter REQ
    And I sign out REQ
    Then I sign in as the new Recruiter REQ
    And I create a new requisition REQ
    And I change status to Open REQ
    And I sign out REQ
    Then I navigate to "TC Login" page
    And I search for that requisition REQ
    And I apply for that requisition REQ
    And I sign out from Talent Community REQ
    Then I navigate to "Test Community login" page
    And I sign in as the new Recruiter REQ
    And I go to my new requisition REQ
    And make sure the new applicant is visible REQ
    Then I delete the new requisition REQ
    And I sign out REQ
    Then I sign in as super admin
    And I delete the new applicant REQ
    And I delete the new Recruiter REQ