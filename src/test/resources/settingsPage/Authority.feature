Feature: Users of different security groups should have correct authorities.


  Scenario: Settings link from hamburger is visible to Admin user
    Given Open ETender system login page
    When user logs in as the user type HKLD Admin
    And user click hamburger icon
    Then the setting link is displayed in hamburger menu


  Scenario: Settings link from hamburger is not visible to non-Admin user
    Given Open ETender system login page
    When user logs in as the user type HKLD Engineer
    And user click hamburger icon
    Then the setting link is not displayed in hamburger menu


  Scenario Outline: Settings link from hamburger is visible to the new added Admin user
    Given Open ETender system login page
    When user logs in as the user type HKLD Admin
    And user click hamburger icon
    And user access settings page
    And user access Users setting
    And he selects the user <User Name> from the user list
    And he clicks Edit button for the single user
    And he add attribute Admin for the single user
    And he saves the attributes for the single user
    And Open ETender system login page
    And user logs in with user name <User Name> and password <Password>
    And user click hamburger icon
    Then the setting link is displayed in hamburger menu
    Then user access settings page
    And user access Users setting
    And he selects the user <User Name> from the user list
    And he clicks Edit button for the single user
    And he removes attribute Admin for the single user
    And he saves the attributes for the single user
    Examples:
    |User Name|Password|
    |brad     |aaaaaa  |