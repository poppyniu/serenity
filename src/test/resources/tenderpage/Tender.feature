Feature:Test function on tender page

  Background:
    Then Clear tender test data in db
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed


  @Tender
  Scenario Outline: HKLD engineer create and save tender and submit tender for approve
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input scope of work tab info <GeneralDescriptionofWork> <GeneralSpecifications> <ParticularSpecifications>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And Input attachments tab info <ProjectDescription> and save tender
    And Submit the new tender for approve
    And HKLD Admin login to approve tender
    And HKLD engineer login to issue tender
    Then Clear tender test data in db
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 51120    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |




  Scenario Outline: Validate PR Number
    And Click create tender button and create a tender
    And user input PR number <PR Number>
    Then user gets the expected header message <Expected Message>

    Examples:
      |PR Number|Expected Message|
      |59004    |The PR amount does not match with the TENDER type|
      |58347    |You are not allowed to view this PR              |
