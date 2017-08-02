Feature:Test function on itq page

  Background:
    Then Clear tender test data in db
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed


  @ITQ
  Scenario Outline: HKLD engineer create and save itq
    And Click create itq button and create a itq
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input items services tab info <SectionTitle1> <DescriptionofWork1> <QTY1> <UNIT1>
    And Input attachments tab info <ProjectDescription> and save tender
    And HKLD engineer preview and issue itq
    Then Clear tender test data in db
    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications | SectionTitle1 | DescriptionofWork1 | QTY1 | UNIT1 | ProjectDescription |
      | test        | test     | 3            | 3        | Friday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 59004   | test                     | test                  | test                     | test          | test               | 3    | kg    | test               |

