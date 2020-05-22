@Smoke Test
Feature: Main Menu Tab

  Scenario: Check whether all tabs are loading properly
    Given I navigate to "Test Community login" page
    When I sign in as super admin
    And I check whether "Main Menu Tab" is loading properly MM
    And I check whether "Admin Console" is loading properly MM
    And I check whether "Talent Matching Tab" is loading properly MM
    And I check whether "Dashboard Tab" is loading properly MM
    And I check whether "Insights Tab" is loading properly MM
    And I check whether "Career Navigator Tab" is loading properly MM
    And I check whether "Analytics Tab" is loading properly MM
    And I check whether "Assessments Tab" is loading properly MM
    And I check whether "Collections Tab" is loading properly MM
    And I check whether "Community Tab" is loading properly MM
    And I check whether "Candidate Review Tab" is loading properly MM
    And I check whether "Pipelines Tab" is loading properly MM
    And I check whether "Opportunities Tab" is loading properly MM
    And I check whether "Organizations Tab" is loading properly MM
    And I check whether "People Tab" is loading properly MM
    And I check whether "Requisitions Tab" is loading properly MM
    And I check whether "Succession Planning Tab" is loading properly MM
    And I check whether "Campaigns Tab" is loading properly MM
    And I check whether "Referrals Tab" is loading properly MM
    And I check whether "Learning Repository Tab" is loading properly MM
    And I check whether "Reporting Tab" is loading properly MM
    And I check whether "Marketplace Tab" is loading properly MM



