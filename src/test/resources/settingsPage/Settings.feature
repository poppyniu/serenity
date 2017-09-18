Feature: HKLD admin user is able to do configuration on settings page.


  Background:
    Given Open ETender system login page
    And user logs in as the user type HKLD Admin
    And user click hamburger icon
    And user access settings page

  @setting @Regression
  Scenario: Add new locations
    And clear locations table from Database
    When user access Location setting
    And user add new locations with Location Short Form, Description and HKL Company
      |Location Short Form | Location Description    | HKL Company|
      |AH                  | AH description | HKLD       |
      |PB                  | PB description | HKLD       |
      |CH                  | CH description | HKLD       |
      |LM                  | LM description | HKLD       |
      |ES                  | ES description | HKLD       |
      |JH                  | JH description | HKLD       |


  @setting @Regression
  Scenario: Add new security groups
    #And clear roles table from Database (Note: In order to keep the initial ymal data, skip DB clear for now)
    When user access Security Groups setting
    And user add new security groups with Group Name and Group Description
      |Group Name     | Group Description |
      |Senior Manager       | HKLD Senior Manager   |
      |Auto Test       | Just For Test  |

  @settinga @Regression
  Scenario: Set security group with authorities
    When user access Security Groups setting
    And user set security groups with corresponding authority actions
      |Group Name     |Authority Actions |
      |Senior Manager |ITQ/Tender_Read All,Project_Read All|
      |Approver       |Project_Read All|

  @setting @Regression
  Scenario Outline: Edit a user to add setting attributes
    When user access Users setting
    And he selects the user <User Name> from the user list
    And he clicks Edit button for the single user
    And he add attribute <Attribute> for the single user
    And he saves the attributes for the single user
    Examples:
      |User Name|Attribute|
      |sophie|Engineer,AH,PB,CH,LM,ES,JH|
      |elon|Approver,AH,PB,CH,LM,ES,JH|
      |morgan |Engineer,AH,PB,CH,ES,JH|

  @setting @Regression
  Scenario: Set the threshold for ITQ/Tender
    And user access Threshold setting
    And user set threshold value as 300000

  @setting @Regression
  Scenario Outline: Add contractors under settings
    And user access Users setting
    And user add a new contractor with details info <vendorID>, <fullName>, <shortName>, <addressLine1>, <addressLine2>, <addressLine3>, <companyPhoneNumber>, <contactAdmin>, <contactPhoneNumber> and <emailAddress>
    Examples:
      | vendorID | fullName       | shortName | addressLine1 | addressLine2 | addressLine3 | companyPhoneNumber | contactAdmin | contactPhoneNumber | emailAddress |
      | 106676   | PROJEXASIA LIMITED | PROJEXASIA LIMITED     | Test address | Test address | Test address | 12345678           | Tester       | 87654321           | test@auto.com|
