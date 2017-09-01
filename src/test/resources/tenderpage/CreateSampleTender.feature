Feature: Create a sample tender with sample info for items/services.
  # Notice: This feature is NO NEED to run regression, just for test data preparation

  @excludeFromRegression
  Scenario Outline: Create a sample tender
    Given clear tender data of the PR number <PRNumber>
    When  Open ETender system login page
    And user logs in as the user type HKLD Engineer
    And Click create tender button and create a tender
    And Input general tab info <Description> <Location> <ProjectStart> <Duration> <WorkingHours1> <WorkingHours2> <WorkingHours3> <WorkingHours4> <Period> <Retention> <DefectsLiabilityPeriod> <LiquidatedDamages> <SuretyBond> <PRNumber>
    And Input scope of work tab info <GeneralDescriptionofWork> <GeneralSpecifications> <ParticularSpecifications>
    And user goes to items/services tab
    And user input sample info for items and services
    And user save the tender
    And user upload attachments and input description <ProjectDescription>
    And preview and submit the tender
    And Open ETender system login page
    And user logs in as the user type HKLD Manager
    And the manager approve the tender of PR number <PRNumber>
    And Open ETender system login page
    And user logs in as the user type HKLD Engineer
    And user issue the tender of PR number <PRNumber>
    And user click hamburger icon
    And user logs out ETender
    And Open contractor login page
    And user logs in with user name <Contractor 1> and password <Contractor 1 pwd>
    And user select the tender of PR number <PRNumber> from the dashboard
    And contractor fill in tender info and submit
    And Open contractor login page
    And user logs in with user name <Contractor 2> and password <Contractor 2 pwd>
    And user select the tender of PR number <PRNumber> from the dashboard
    And contractor fill in tender info and submit
    And Open contractor login page
    And user logs in with user name <Contractor 3> and password <Contractor 3 pwd>
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
      | Description | Location | ProjectStart | Duration | WorkingHours1 | WorkingHours2 | WorkingHours3 | WorkingHours4 | Period | Retention | DefectsLiabilityPeriod | LiquidatedDamages | SuretyBond | PRNumber | GeneralDescriptionofWork | GeneralSpecifications | ParticularSpecifications |  ProjectDescription | Contractor 1 | Contractor 1 pwd | Contractor 2 | Contractor 2 pwd | Contractor 3 | Contractor 3 pwd |
      | test        | test     | 3            | 3        | Monday        | Friday        | 01:00         | 03:00         | 3      | 3         | 3                      | 3                 | 3          | 59000    | test                     | test                  | test                     |  test               | judy_zou@epam.com | aaaaaa      | poppy_zhang@epam.com | aaaaaa   | ason_yang@epam.com | aaaaaa     |
