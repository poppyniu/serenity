Feature:Test create an ITQ in ETender system

  @ETender
  Scenario Outline: Test create an ITQ
    Given  Open ETender system home page with <Browser>
    When Click create New ITQ button and input PR number with enter button
    And Go to create ITQ page input general info and upload files and save
    Then Check if create ITQ succeed
    Then Close browser
    Examples:
      | Browser |
      | ie      |
#      | chrome  |



