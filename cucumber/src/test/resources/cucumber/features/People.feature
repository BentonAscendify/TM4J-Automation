@End-to-End
Feature: People Tab

  Scenario: Add new user manually
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on "New" button PT
    And I navigate to "Add Manually" PT
    Then I manually add new user's profile PT
    And I click on "Add Profile" button PT
    Then "New user was added" message is displayed PT
    And I make sure that Organize functions in the form are working as expected PT
    Then I search for user by email in the global bar at top PT
    And I clean up "Manual User" PT

  Scenario: Upload resume to upper right cloud icon
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I choose my file to be uploaded by clicking "Cloud Icon" button PT
    Then I fill in empty fields for the profile PT
    And I click on "Add Profile" button PT
    Then "New user was added" message is displayed PT
    And I clean up "Cloud User" PT

  Scenario: Add new user by uploading a CSV file
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on "New" button PT
    And I navigate to "Upload a CSV file" PT
    And I choose my file to be uploaded by clicking "Upload a File" button PT
    Then "Data Mapping" page is displayed PT
    And I map the fields in the .CSV file to the appropriate fields in the application PT
    And I click on "Import" button PT
    Then "CSV processing" message is displayed PT
    And I clean up "CSV" PT

  Scenario: Bulk Add 50 People
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on "New" button PT
    And I navigate to "Bulk Add" PT
    And I choose my file to be uploaded by clicking "Drop Files" button PT
    And I fill in empty fields PT
    And I click on "Add Profile" button PT
    Then "Bulk Add processing" message is displayed PT
    And I clean up "Bulk" PT

  Scenario: Consider candidates for an opportunity
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on the right arrow of a candidate PT
    And I consider for new opportunity PT
    Then candidate has been "Applied to Opportunity" PT

  Scenario: Moving candidates through different hiring status
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on the right arrow of a candidate PT
    And I consider for new opportunity PT
    Then candidate has been "Applied to Opportunity" PT
    And I move the candidate through different hiring status to Onsite Interview PT

  Scenario: Edit/save responses
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I click on the right arrow of a candidate PT
    And I click on "Responses" tab PT
    And I edit and save all questions PT

  Scenario: Drag n Drop candidates to folder
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I click on "People" tab PT
    And I drag and drop candidates to folder PT

  Scenario: Set up Interview kit
    Given I navigate to "CRM login" page
    When I sign in to CRM
    Then "Main Menu" page is displayed PT
    And I go to my profile to find my organization PT
    And I find an opportunity associated with my organization PT
    And I make sure interview is setup for this opportunity PT
    And I click on "People" tab PT
    And I choose a person who is associated with the same organization as mine PT
    And I consider for same opportunity PT
    Then candidate of same org has been "Applied to Opportunity" PT
    And I move the candidate through different hiring status to Onsite Interview PT
    And I go to Interview tab to set up Interview kit PT
    And I do the Interview setup PT
    Then I make sure the new interviewers are added as Team Members PT