Feature: HKLD admin user is able to do configuration on settings page.


  Background:
    Given Open ETender system login page
    And the user logs in as the user type HKLD Admin
    And user access settings page

  @setting
  Scenario: Add new locations
    And clear locations table from Database
    When user access Location setting
    And user add new locations with Location Short Form, Description and HKL Company
      |Location Short Form | Location Description    | HKL Company|
      |AH                  | AH description | HKLD       |
      |PB                  | PB description | HKLD       |


  @setting
  Scenario: Add new security Groups
    And clear roles table from Database
    When user access Security Groups setting
    And user add new security groups with Group Name and Group Description
      |Group Name     | Group Description |
      |General Users  | HKLD General Engineer|
      |Approver       | HKLD Tender Manager  |
      |IT Admin       | HKLD Administrator   |




  @setting
  Scenario Outline: Edit a user to add setting attributes
    When user access Users setting
    And he selects the user <User Name> from the user list
    And he clicks Edit button for the single user
    And he add attribute <Group Name> and <Location> for the single user
    And he saves the attributes for the single user
    Examples:
    |User Name|Group Name|Location|
    |sophie@hkland.com|General Users|AH,PB|
    |elon@hkland.com  |Approver     |AH   |

