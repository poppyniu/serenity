Feature:Test function on tender page

  Background:
    Given Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed


  @TenderFlow
  Scenario Outline: Create a Tender until Review, and check status along the whole flow
    And clear tender data of the PR number <PRNumber>
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input scope of work tab info <GeneralDescriptionofWork> <GeneralSpecifications> <ParticularSpecifications>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And Input attachments tab info <ProjectDescription> and save tender
    And user go back to dashboard page
    Then the tender of PR number <PRNumber> shows the status as DRAFT
    And Submit the new tender for approve
    And user go back to dashboard page
    Then the tender of PR number <PRNumber> shows the status as WAPPR
    And HKLD Admin login to approve tender
    And HKLD engineer login to issue tender
    And user go back to dashboard page
    Then the tender of PR number <PRNumber> shows the status as ISSUED
    And <Contractor> login to submit tender
    And user go back to dashboard page
    Then the tender of PR number <PRNumber> shows the status as SUBMITTED
    And HKLD engineer login to check if contractor has submitted tender
    And Change tender status in db by <PRNumber>
    And HKLD engineer check current tender status
    And clear tender data of the PR number <PRNumber>
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |Contractor|
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 58668    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |tender|



  Scenario Outline: Validate PR Number
    And clear tender data of the PR number 52155
    And Click create tender button and create a tender
    And user input PR number 52155
    And user save the PR info
    And user save the tender
    And user go back to dashboard page
    And Click create tender button and create a tender
    And user input PR number <PR Number>
    Then user gets the expected header message <Expected Message>

    Examples:
      |PR Number|Expected Message|
      |52155    |This PR number is in use                         |
      |59004    |The PR amount does not match with the TENDER type|
      #|58682    |You are not allowed to view this PR              |
      |00000    |Not Found                                        |


  @ViewTender
  Scenario Outline: View all tenders
    And clear tender data of the PR number <PRNumber>
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And user save the tender
    And user go back to dashboard page
    Then the tender of PR number <PRNumber> shows the status as DRAFT
    And Click view all tenders button
    Then Check view all tenders page search function
    And clear tender data of the PR number <PRNumber>
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |Contractor|
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 58668    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |tender|

  @CancelTender
  Scenario Outline: Cancel a tender
    And clear tender data of the PR number <PRNumber>
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And user save the tender
    And user go back to dashboard page
    Then the tender of PR number <PRNumber> shows the status as DRAFT
    And Open the new created dashboard tender item
    Then Cancel this tender and check cancel result
    And clear tender data of the PR number <PRNumber>
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |Contractor|
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 58668    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |tender|


  @RejectTender
  Scenario Outline: Reject a tender
    And clear tender data of the PR number <PRNumber>
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And user save the tender
    And Submit the new tender for approve
    And HKLD Admin login to reject tender
    Then HKLD engineer to check tender <Status>
    And clear tender data of the PR number <PRNumber>
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |Contractor|Status|
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 58668    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |tender|REJECTED|


  @ResetToDraft
  Scenario Outline: Reset tender to draft
    And clear tender data of the PR number <PRNumber>
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And user save the tender
    And Submit the new tender for approve
    And HKLD Admin login to reset tender to draft
    Then HKLD engineer to check tender <Status>
    And clear tender data of the PR number <PRNumber>
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |Contractor|Status|
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 58668    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |tender|DRAFT     |

