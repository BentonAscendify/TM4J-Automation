@End-to-End
Feature: Requisitions Tab

  Scenario: Create and apply for a requisition
    Given I navigate to "Test Community login" page
    When I sign in as super admin with credentials "tessy.anicattumathew@ascendify.com" and "Mac123q!"
    And I create a person's profile with role Recruiter
    And I sign out
    Then I sign in as the new Recruiter
    And I create a new requisition
    And I change status to Open
    And I sign out
    Then I navigate to "TC Login" page
    And I search for that requisition
    And I apply for that requisition
    And I sign out from Talent Community
    Then I navigate to "Test Community login" page
    And I sign in as the new Recruiter
    And I go to my new requisition
    And make sure the new applicant is visible
    Then I delete the new requisition
    And I sign out
    Then I sign in as super admin with credentials "tessy.anicattumathew@ascendify.com" and "Mac123q!"
    And I delete the new applicant
    And I delete the new Recruiter