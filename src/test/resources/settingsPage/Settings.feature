Feature: HKLD admin user is able to do configuration on settings page.


  Background:
    Given Open ETender system login page
    And the user logs in as the user type HKLD Admin
    And user access settings page

  @setting
  Scenario Outline: Add a new location
    When user access Location setting
    And user add a new location with <Location Short Form> and <Description> and <HKL Company>
    Examples:
      |Location Short Form | Description    | HKL Company|
      |AH                  | AH description | HKLD       |
      |PB                  | PB description | HKLD       |

  @setting
  Scenario Outline: Add a new security Groups
    When user access Security Groups setting
    And user add a new security group with <Group Name> and <Description>
    Examples:
      |Group Name     | Description |
      |General Users  | HKLD General Engineer|
      |Approver       | HKLD Tender Manager  |
      |IT Admin       | HKLD Administrator   |
      |Super Admin    | Super Administrator  |



  @setting
  Scenario: Edit a user
    When user access Users setting
    And he selects a user name sophie@hkland.com from the user list
    And he clicks Edit button for the single user
    And he add attribute for the single user
      |attribute|
      |General Users|
      |Approver|
      |AH|
    And he saves the attributes for the single user