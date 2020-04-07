@TalentCommunity
Feature: Join via email
  Scenario: Join community via email
    Given I navigate to "TC login" page
    When I click on "Join Our Team" button
    And I click on link text "email address"
    Then "Application" page is displayed
    And I type "First Name" as "Tessy"
    And I type "Last Name" as "Mathew"
    And I type an unused email
    And I type password "Ascendify246!" on "sign up" page
    And I type "Country or Region" as "India"
    And I click and agree to Privacy Policy
    And I click on "Submit" button
    Then "Dashboard" page is displayed

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
    And I type an unused email
    And I type password "Ascendify246!" on "sign up" page
    And I type "Most Recent School" as "Bellevue University"
    And I type "Grad Year" as "2000"
    And I type "Degree Type" as "Management Information Systems"
    And I type "Degree" as "MBA"
    And I sign to confirm
    And I click on "Submit" button
    Then "Dashboard" page is displayed

  Scenario: Search for opportunity and apply
    Given I navigate to "TC login" page
    When I click on link text "Search Careers"
    And I search for "Tessy QA" in search box
    And I click on link text "Tessy QA"
    And I click on "Apply Now" button
    And I click on link text "email address"
    Then "Application" page is displayed
    And I type "First Name" as "Tessy"
    And I type "Last Name" as "Mathew"
    And I type an unused email
    And I type password "Ascendify246!" on "sign up" page
    And I type "Most Recent School" as "Bellevue University"
    And I type "Grad Year" as "2000"
    And I type "Degree Type" as "Management Information Systems"
    And I type "Degree" as "MBA"
    And I sign to confirm
    And I click on "Submit" button
    Then "Dashboard" page is displayed

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