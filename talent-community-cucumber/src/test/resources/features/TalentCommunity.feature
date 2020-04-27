@java
Feature: Talent Community

  Scenario: Join community via email
    Given I navigate to "TC login" page
    When I click on "Join Our Team" button
    And I click on link text "email address"
    Then "Application" page is displayed
    And I fill in "Your Information" fields
    And I fill in "Additional Information" fields
    And I fill in "Profile Information" fields
    And I fill in "Automatic Routing to Pipelines" fields
    And I click and agree to Privacy Policy
    And I click on "Submit" button
    Then "Dashboard" page is displayed
    And I clean up

  Scenario: Apply to a job by sign-in to a community
    Given I navigate to "TC login" page
    When I click on link text "Search Careers"
    And I search for "Tessy QA" in search box
    And I click on link text "Tessy QA"
    And I click on "Apply Now" button
    And I click on link text "Sign In"
    Then "Sign In" page is displayed
    And I type "email" as "tessy@gmail.com"
    And I type password "Ascendify246!" on "sign in" page
    And I click on "Sign In" button on "Sign In" page
    And I make sure I haven't applied to that job already
    And I click on "Apply Now" button
    And I sign to confirm
    And I click on "Submit Application" button
    Then success message is displayed

  Scenario: Apply to a job by uploading your resume
    Given I navigate to "TC login" page
    When I click on link text "Search Careers"
    And I search for "Tessy QA" in search box
    And I click on link text "Tessy QA"
    And I click on "Apply Now" button
    And I choose my file to be uploaded by clicking "Upload Your Resume" button
    Then "Application" page is displayed
    And I fill in empty fields
    And I sign to confirm
    And I click on "Submit" button
    Then "Dashboard" page is displayed
    And I clean up

  Scenario: Search for opportunity and apply
    Given I navigate to "TC login" page
    When I click on link text "Search Careers"
    And I search for "Tessy QA" in search box
    And I click on link text "Tessy QA"
    And I click on "Apply Now" button
    And I click on link text "email address"
    Then "Application" page is displayed
    And I fill in empty fields
    And I sign to confirm
    And I click on "Submit" button
    Then "Dashboard" page is displayed
    And I clean up

  Scenario: Login as a candidate and apply to a job
    Given I navigate to "TC login" page
    When I click on "Sign In" button on "Home" page
    And I type "email" as "tessy@gmail.com"
    And I type password "Ascendify246!" on "sign in" page
    And I click on "Sign In" button on "Sign In" page
    Then "Dashboard" page is displayed
    And I click on link text "Search Careers"
    And I search for "Tessy QA" in search box
    And I make sure I haven't applied to that job already
    And I click on link text "Tessy QA"
    And I click on "Apply Now" button
    And I sign to confirm
    And I click on "Submit Application" button
    Then success message is displayed

  Scenario: Add all other personal and basic info
    Given I navigate to "TC login" page
    When I click on "Sign In" button on "Home" page
    And I type "email" as "tessy@gmail.com"
    And I type password "Ascendify246!" on "sign in" page
    And I click on "Sign In" button on "Sign In" page
    Then "Dashboard" page is displayed
    And I add "Profile" info
    And I add "Personal" info

  Scenario: Org Sign Up
    Given I navigate to "TC login" page
    When I click on link text "Search Careers"
    And I search for "Tessy's Org" in search box
    And I click on link text "Opportunity under Tessy's Org"
    And I click on "Apply Now" button
    And I click on link text "email address"
    Then "Application" page is displayed
    And I fill in "Your Information" fields
    And I fill in "Additional Information" fields
    And I fill in "Profile Information" fields
    And I fill in empty fields
    And I answer the survey questions
    And I sign to confirm
    And I click on "Submit" button
    Then "Dashboard" page is displayed
    And I clean up

  Scenario: Login/SignUp via Social
    Given I navigate to "LinkedIn" page
    When I click on "Sign In" button on "LinkedIn Sign In" page
#    NOTE:Use a valid LinkedIn email and password that is not present in the Ascendify Database
    And I type "LinkedIn email" as "2arjunsreekumar9@unoutta.cf"
    And I type password "Mac123q!" on "LinkedIn Sign In" page
    And I click on "Sign In" button on "LinkedIn 2nd Sign In" page
    Given I navigate to "TC login" page
    When I click on "Join Our Team" button
    And I click on "Apply with LinkedIn" button
    Then "Application" page is displayed
    And I copy the LinkedIn email
    And I fill in "Your Information" fields
    And I fill in "Additional Information" fields
    And I fill in "Profile Information" fields
    And I fill in "Automatic Routing to Pipelines" fields
    And I fill in empty fields
    And I click and agree to Privacy Policy
    And I click on "Submit" button
    Then "Dashboard" page is displayed
    And I clean up