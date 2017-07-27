Feature:Test function on tender page

  Background:
    Then Clear tender test data in db
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed


  @Tender
  Scenario Outline: HKLD engineer create and save tender and submit tender for approve
    Then Click create tender button and crate a tender
    Then Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
#    Then Input scope of work tab info <GeneralDescriptionofWork> <GeneralSpecifications> <ParticularSpecifications>
    Then Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    Then Input attachments tab info <ProjectDescription> and save tender
    Then Submit the new tender for approve
    Then HKLD Admin login to approve tender
    Then HKLD engineer login to issue tender
    Then Clear tender test data in db
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 57070    | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |
