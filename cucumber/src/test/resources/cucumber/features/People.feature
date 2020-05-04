@End-to-End
Feature: People Tab

  Scenario: Add new user by uploading a CSV file
    Given I navigate to "Test Community login" page PT
    When I sign in PT
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on "New" button PT
    And I navigate to "Upload a CSV file" PT
    And I choose my file to be uploaded by clicking "Upload a File" button PT
#    NOTE:Paste the path to your file in step defs
    Then "Data Mapping" page is displayed PT
    And I map the fields in the .CSV file to the appropriate fields in the application PT
    And I click on "Import" button PT
    Then "CSV processing" message is displayed PT

  Scenario: Bulk Add People
    Given I navigate to "Test Community login" page PT
    When I sign in PT
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on "New" button PT
    And I navigate to "Bulk Add" PT
    And I choose my file to be uploaded by clicking "Drop Files" button PT
#    NOTE:Paste the path to your folder containing the files in step defs
    And I fill in empty fields PT
    And I click on "Add Profiles" button PT
    Then "Bulk Add processing" message is displayed PT

  Scenario: Consider candidates for an opportunity
    Given I navigate to "Test Community login" page PT
    When I sign in PT
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on the right arrow of a candidate PT
    And I consider for new opportunity PT
    Then candidate has been "Applied to Opportunity" PT

  Scenario: Moving candidates through different hiring status
    Given I navigate to "Test Community login" page PT
    When I sign in PT
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on the right arrow of a candidate PT
    And I consider for new opportunity PT
    Then candidate has been "Applied to Opportunity" PT
    And I move the candidate through different hiring status PT

  Scenario: Edit/save responses
    Given I navigate to "Test Community login" page PT
    When I sign in PT
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on the right arrow of a candidate PT
    And I consider for new opportunity PT
    Then candidate has been "Applied to Opportunity" PT
    And I click on "Responses" tab PT
    And I edit and save all questions PT

  Scenario: Drag n Drop candidates to folder
    Given I navigate to "Test Community login" page PT
    When I sign in PT
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I drag and drop candidates to folder PT

  Scenario: Set up Interview kit