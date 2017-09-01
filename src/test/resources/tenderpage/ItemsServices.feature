Feature: Add, Delete, Update Items/Services


  Background:
    When  Open ETender system login page
    And Input valid user name and pwd and click login button
    And Click create tender button and create a tender

  @itemsAndServices
  Scenario: At least one section should exist under Items/Services
    And user goes to items/services tab
    Then 1 sections should be existing
    And user at section #1 choose the action Delete from section drop down menu
    Then 1 sections should be existing
    And user save the tender

  @itemsAndServices
  Scenario: Section Add and Delete functions are working well
    And user goes to items/services tab
    And user at section #1 choose the action Add Section from section drop down menu
    Then 2 sections should be existing
    And user at section #2 choose the action Delete from section drop down menu
    Then 1 sections should be existing
    And user at section #1 item #1 choose the action Add Section from item drop down menu
    Then 2 sections should be existing
    And user save the tender


  @itemsAndServices
  Scenario: Item Add and Delete functions are working well
    And user goes to items/services tab
    And user at section #1 choose the action Add Line from section drop down menu
    Then 2 items should be existing under section #1
    And user at section #1 item #1 choose the action Add Line from item drop down menu
    Then 3 items should be existing under section #1
    And user at section #1 item #3 choose the action Delete from item drop down menu
    Then 2 items should be existing under section #1
    And user save the tender

  @itemsAndServices
  Scenario: Option Add and Delete functions are working well
    And user goes to items/services tab
    And user at section #1 item #1 choose the action Add Option from item drop down menu
    Then 1 options should be existing under section #1 item #1
    And user at section #1 item #1 option #1 choose the action Add Option from option drop down menu
    Then 2 options should be existing under section #1 item #1
    And user at section #1 item #1 option #2 choose the action Delete from option drop down menu
    Then 1 options should be existing under section #1 item #1
    And user save the tender

  @itemsAndServices
  Scenario: Add multiple sections and line items into a Tender
    And user goes to items/services tab
    And user add 2 more sections and at every section add 2 more items and input value for all
    And user save the tender