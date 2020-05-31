@java
Feature: Talent Community

  Scenario: Join community via email
    Given I navigate to "TC login" page
    When I click on "Join Our Team" button TC
    And I click on link text "email address" TC
    Then "Application" page is displayed TC
    And I fill in "Your Information" fields TC
    And I fill in "Additional Information" fields TC
    And I fill in "Profile Information" fields TC
    And I fill in "Automatic Routing to Pipelines" fields TC
    And I click and agree to Privacy Policy TC
    And I click on "Submit" button TC
    And "Dashboard" page is displayed TC
    Then I navigate to "CRM login" page
    And I sign in as super admin
    And I clean up TC

  Scenario: Apply to a job by uploading your resume
    Given I navigate to "TC login" page
    When I click on link text "Search Careers" TC
    And I search for "Tessy QA" in search box TC
    And I click on link text "Tessy QA" TC
    And I click on "Apply Now" button TC
    And I choose my file to be uploaded by clicking "Upload Your Resume" button TC
    Then "Application" page is displayed TC
    And I fill in empty fields TC
    And I click and agree to Privacy Policy TC
    And I sign to confirm TC
    And I click on "Submit" button TC
    Then "Dashboard" page is displayed TC
    Then I navigate to "CRM login" page
    And I sign in as super admin
    And I clean up TC

  Scenario: Login/SignUp via Social
    Given I navigate to "LinkedIn" page
    When I click on "Sign In" button on "LinkedIn Sign In" page TC
#    NOTE:Use a valid LinkedIn email and password that is not present in the Ascendify Database
    And I sign in to LinkedIn
    And I click on "Sign In" button on "LinkedIn 2nd Sign In" page TC
    Given I navigate to "TC login" page
    When I click on "Join Our Team" button TC
    And I click on "Apply with LinkedIn" button TC
    Then "Application" page is displayed TC
    And I copy the LinkedIn email TC
    And I fill in "Your Information" fields TC
    And I fill in "Additional Information" fields TC
    And I fill in "Profile Information" fields TC
    And I fill in "Automatic Routing to Pipelines" fields TC
    And I fill in empty fields TC
    And I click and agree to Privacy Policy TC
    And I click on "Submit" button TC
    Then "Dashboard" page is displayed TC
    Then I navigate to "CRM login" page
    And I sign in as super admin
    And I clean up TC

  Scenario: Search for opportunity and apply with email
    Given I navigate to "TC login" page
    When I click on link text "Search Careers" TC
    And I search for "Tessy QA" in search box TC
    And I click on link text "Tessy QA" TC
    And I click on "Apply Now" button TC
    And I click on link text "email address" TC
    Then "Application" page is displayed TC
    And I fill in empty fields TC
    And I click and agree to Privacy Policy TC
    And I sign to confirm TC
    And I click on "Submit" button TC
    Then "Dashboard" page is displayed TC
    Then I navigate to "CRM login" page
    And I sign in as super admin
    And I clean up TC

  Scenario: Apply to a job by sign-in to a community
    Given I navigate to "TC login" page
    When I click on link text "Search Careers" TC
    And I search for "Tessy QA" in search box TC
    And I click on link text "Tessy QA" TC
    And I click on "Apply Now" button TC
    And I click on link text "Sign In" TC
    Then "Sign In" page is displayed TC
    And I sign in to TalentCommunity as a candidate
    And I click on "Sign In" button on "Sign In" page TC
    And I make sure I haven't applied to that job already TC
    And I click on "Apply Now" button TC
    And I sign to confirm TC
    And I click on "Submit Application" button TC
    Then success message is displayed TC

  Scenario: Login as a candidate and apply to a job
    Given I navigate to "TC login" page
    When I click on "Sign In" button on "Home" page TC
    And I sign in to TalentCommunity as a candidate
    And I click on "Sign In" button on "Sign In" page TC
    Then "Dashboard" page is displayed TC
    And I click on link text "Search Careers" TC
    And I search for "Tessy QA" in search box TC
    And I make sure I haven't applied to that job already TC
    And I click on link text "Tessy QA" TC
    And I click on "Apply Now" button TC
    And I click and agree to Privacy Policy TC
    And I sign to confirm TC
    And I click on "Submit Application" button TC
    Then success message is displayed TC

  Scenario: Add all other personal and basic info
    Given I navigate to "TC login" page
    When I click on "Sign In" button on "Home" page TC
    And I sign in to TalentCommunity as a candidate
    And I click on "Sign In" button on "Sign In" page TC
    Then "Dashboard" page is displayed TC
    And I add "Profile" info TC
    And I add "Personal" info TC

  Scenario: Org Sign Up
    Given I navigate to "TC login" page
    When I click on link text "Search Careers" TC
    And I search for "Tessy's Org" in search box TC
    And I click on link text "Opportunity under Tessy's Org" TC
    And I click on "Apply Now" button TC
    And I click on link text "email address" TC
    Then "Application" page is displayed TC
    And I fill in "Your Information" fields TC
    And I fill in "Additional Information" fields TC
    And I fill in "Profile Information" fields TC
    And I fill in empty fields TC
    And I answer the survey questions TC
    And I click and agree to Privacy Policy TC
    And I sign to confirm TC
    And I click on "Submit" button TC
    Then "Dashboard" page is displayed TC
    Then I navigate to "CRM login" page
    And I sign in as super admin
    And I clean up TC



