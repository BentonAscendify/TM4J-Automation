@End-to-End
Feature: People Tab

  Scenario: Add new user by uploading a CSV file
    Given I navigate to "Test Community login" page
    When I type "email" as "tessy.anicattumathew@ascendify.com"
    And I type "password" as "Mac123q!"
    And I click on "Sign In" button
    Then "Main Menu" page is displayed
    And I click on "People" tab
    And I click on "New" button
    And I navigate to "Upload a CSV file"
    And I choose my file to be uploaded by clicking "Upload a File" button
#    NOTE:Paste the path to your file in step defs
    Then "Data Mapping" page is displayed
    And I map the fields in the .CSV file to the appropriate fields in the application
    And I click on "Import" button
    Then "CSV processing" message is displayed

  Scenario: Bulk Add People
    Given I navigate to "Test Community login" page
    When I type "email" as "tessy.anicattumathew@ascendify.com"
    And I type "password" as "Mac123q!"
    And I click on "Sign In" button
    Then "Main Menu" page is displayed
    And I click on "People" tab
    And I click on "New" button
    And I navigate to "Bulk Add"
    And I choose my file to be uploaded by clicking "Drop Files" button
#    NOTE:Paste the path to your folder containing the files in step defs
    And I fill in empty fields
    And I click on "Add Profiles" button
    Then "Bulk Add processing" message is displayed

  Scenario: Consider candidates for an opportunity
    Given I navigate to "Test Community login" page
    When I type "email" as "tessy.anicattumathew@ascendify.com"
    And I type "password" as "Mac123q!"
    And I click on "Sign In" button
    Then "Main Menu" page is displayed
    And I click on "People" tab
    And I click on the right arrow of a candidate
    And I consider for new opportunity
    Then candidate has been "Applied to Opportunity"

  Scenario: Moving candidates through different hiring status
    Given I navigate to "Test Community login" page
    When I type "email" as "tessy.anicattumathew@ascendify.com"
    And I type "password" as "Mac123q!"
    And I click on "Sign In" button
    Then "Main Menu" page is displayed
    And I click on "People" tab
    And I click on the right arrow of a candidate
    And I consider for new opportunity
    Then candidate has been "Applied to Opportunity"
    And I move the candidate through different hiring status

  Scenario: Set up Interview kit

  Scenario: Edit/save responses
    Given I navigate to "Test Community login" page
    When I type "email" as "tessy.anicattumathew@ascendify.com"
    And I type "password" as "Mac123q!"
    And I click on "Sign In" button
    Then "Main Menu" page is displayed
    And I click on "People" tab
    And I click on the right arrow of a candidate
    And I consider for new opportunity
    Then candidate has been "Applied to Opportunity"
    And I click on "Responses" tab
    And I edit and save all questions

  Scenario: Drag n Drop candidates to folder
    Given I navigate to "Test Community login" page
    When I type "email" as "tessy.anicattumathew@ascendify.com"
    And I type "password" as "Mac123q!"
    And I click on "Sign In" button
    Then "Main Menu" page is displayed
    And I click on "People" tab
    And I drag and drop candidates to folder