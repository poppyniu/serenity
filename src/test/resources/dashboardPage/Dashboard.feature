Feature: Functions on dashboard.


  Background:
    Given Clear tender test data in db

  @dashboard @Regression
  Scenario Outline: Dashboard and hamburger shows correct user name after HKLD user or vendor login
    Given Open ETender system login page
    And user logs in with user name <HKLD User Name> and password <HKLD Password>
    Then the Hello Name shown on dashboard is <HKLD User Name>
    And user click hamburger icon
    Then the Hello Name shown on hamburger is <HKLD User Name>
    And Open contractor login page
    And user logs in with user name <Vendor User> and password <Vendor Password>
    Then the Hello Name shown on dashboard is <Vendor User>
    And user click hamburger icon
    Then the Hello Name shown on hamburger is <Vendor User>
    And user logs out ETender
    Examples:
    |HKLD User Name|HKLD Password|Vendor User|Vendor Password|
    |sophie  |aaaaaa  |gino_zhu@epam.com     |aaaaaa         |
    |brad    |aaaaaa  |judy_zou@epam.com     |aaaaaa         |

  @dashboard @Regression
  Scenario: Different HKLD users can only view the Tender created by themselves.
    Given Open ETender system login page
    And user logs in with user name sophie and password aaaaaa
    And Click create tender button and create a tender
    And user input PR number 51120
    And user save the PR info
    And user save the tender
    And user go back to dashboard page
    Then the tender of PR number 51120 is existing in the dashboard
    And user click hamburger icon
    And user logs out ETender
    And Open ETender system login page
    And user logs in with user name elon and password aaaaaa
    Then the tender of PR number 51120 is not existing in the dashboard

  @dashboard @Regression
  Scenario: The bubble number on the top of the dashboard shows the correct number
    Given Open ETender system login page
    And user logs in with user name sophie and password aaaaaa
    And Click create tender button and create a tender
    And user input PR number 51120
    And user save the PR info
    And user save the tender
    And user go back to dashboard page
    And Click create tender button and create a tender
    And user save the tender
    And user go back to dashboard page
    And Click create itq button and create a itq
    And user save the tender
    And user go back to dashboard page
    Then the bubble number of tender is correct on the top of the dashboard

  @dashboard @Regression
  Scenario Outline: ITQ/Tender shows correct amount on the dashboard
    Given Open ETender system login page
    And user logs in as the user type HKLD Engineer
    And Click create tender button and create a tender
    And user input PR number <Tender PR>
    And user save the PR info
    And user save the tender
    Then the tender of PR number <Tender PR> shows correct amount on the dashboard
    And Click create itq button and create a itq
    And user input PR number <ITQ PR>
    And user save the PR info
    And user save the tender
    Then the tender of PR number <ITQ PR> shows correct amount on the dashboard

    Examples:
    |Tender PR|ITQ PR|
    |59000    |59004 |
    |52155    |57556 |

