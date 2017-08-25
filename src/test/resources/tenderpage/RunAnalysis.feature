Feature: HKLD user is able to run analysis when review a tender.
  Background:
    Given Clear tender test data in db

  @ITQFlow
  Scenario Outline: Multiple vendors submit bids and HKLD user can get comparison table
    When Open ETender system login page
    And user logs in as the user type HKLD Engineer
    And Click create itq button and create a itq
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And user goes to items/services tab
    And user add 1 more sections
    And user at section #1 add 1 more items
    And user at section #1 input section tile
    And user at section #2 input section tile
    And user input Description, QTY and UNIT for every line item
      |Section Index|Item Index|
      |1            |1         |
      |1            |2         |
      |2            |1         |
    And Input attachments tab info <ProjectDescription> and save tender
    And HKLD engineer preview and issue itq
    And user click hamburger icon
    And user logs out ETender
    And Open contractor login page
    And user logs in with user name <Contractor 1> and password <Contractor 1 pwd>
    And user select the tender of PR number <PRNumber> from the dashboard
    And contractor fill in tender info and submit
    And user click hamburger icon
    And user logs out ETender
    And Open contractor login page
    And user logs in with user name <Contractor 2> and password <Contractor 2 pwd>
    And user select the tender of PR number <PRNumber> from the dashboard
    And contractor fill in tender info and submit
    And user click hamburger icon
    And user logs out ETender
    And Change tender status in db by <PRNumber>
    And Open ETender system login page
    And user logs in as the user type HKLD Engineer
    And user select the tender of PR number <PRNumber> from the dashboard
    And user run analysis and get analysis table

    Examples:
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | ProjectDescription | Contractor 1 | Contractor 1 pwd | Contractor 2 | Contractor 2 pwd |
      | test        | test     | 3            | 3        | Monday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 59004   | test              | michelle_zhang@epam.com | aaaaaa | maggie_ping@epam.com | aaaaaa       |

