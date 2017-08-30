Feature: Create a sample tender with sample info for items/services. (No need to run regression)

  @exclude
  Scenario: Create a sample tender
    Given Clear tender test data in db
    When  Open ETender system login page
    And Input valid user name and pwd and click login button
    And Click create tender button and create a tender
    And user input PR number 59000
    And user save the PR info
    And user goes to items/services tab
    And user input sample info for items and services
    And user save the tender
