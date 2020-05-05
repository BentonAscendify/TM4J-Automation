@End-to-End
Feature: Requisitions Tab

  Scenario: Create and apply for a requisition
    Given I navigate to "Test Community login" page REQ
    When I sign in as super admin with credentials "tessy.anicattumathew@ascendify.com" and "Mac123q!" REQ
    And I create a person's profile with role Recruiter REQ
    And I sign out REQ
    Then I sign in as the new Recruiter REQ
    And I create a new requisition REQ
    And I change status to Open REQ
    And I sign out REQ
    Then I navigate to "TC Login" page REQ
    And I search for that requisition REQ
    And I apply for that requisition REQ
    And I sign out from Talent Community REQ
    Then I navigate to "Test Community login" page REQ
    And I sign in as the new Recruiter REQ
    And I go to my new requisition REQ
    And make sure the new applicant is visible REQ
    Then I delete the new requisition REQ
    And I sign out REQ
    Then I sign in as super admin with credentials "tessy.anicattumathew@ascendify.com" and "Mac123q!" REQ
    And I delete the new applicant REQ
    And I delete the new Recruiter REQ