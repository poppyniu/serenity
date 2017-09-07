Feature:Test function on project page

  Background:
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed


  @ProjectFlow
  Scenario Outline: Test whole flow for project
    And Clear project test data in db by <PoNo>
    And Create project with <PoNo> and add doc type and invite vendor
    And Vendor login to do the first partial submission <Completion Amount>
    And Engineer approve the first partial submission and check project status
    And Vendor login to do the second partial submission <Completion Amount1>
    And Engineer approve the second partial submission and check project status
    And Vendor login to do the third partial final submission without uploading the needed docs <Completion Amount2>
    Then Check there is remind info for uploading docs
    And Vendor upload all the docs and do the third partial final submission
    And Engineer approve the third final submission without approve the docs
    Then Check there is remind info for approve all docs
    And Engineer re-approve the third final submission and check project status
    Then Clear project test data in db by <PoNo>
    Examples:
    |PoNo|Completion Amount|Completion Amount1|Completion Amount2|
    |333333|2000           |6000              |1000              |

  @RejectProject
  Scenario Outline: HKLD engineer reject a full submission of a project
    And Clear project test data in db by <PoNo>
    And Create project with <PoNo> and add doc type and invite vendor
    And Vendor login to do the full submission <Completion Amount> without uploading the needed docs
    Then Check there is remind info for uploading docs
    And Vendor do the full submission with all needed docs uploaded
    And Engineer reject the full submission and check project status
    And Vendor login to check project status
    Then Clear project test data in db by <PoNo>
    Examples:
      |PoNo|Completion Amount|
      |333333|2000           |


  @ProjectAmount @Regression
  Scenario Outline:  Check PO amount completion amount remaining balance
    And Clear project test data in db by <PoNo>
    And Create project with <PoNo> and add doc type and invite vendor
    And Vendor login to test po amount field <Completion Amount>
    Then Clear project test data in db by <PoNo>
    Examples:
      |PoNo|Completion Amount|
      |333333|2000           |
