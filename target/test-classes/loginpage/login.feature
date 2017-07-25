Feature:Test function on login page

  @Login
  Scenario: Test valid login for HKLD engineer
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed

  @InvalidLogin
  Scenario: Test invalid login for HKLD engineer
    Given  Open ETender system login page
    When Input invalid user name and pwd and click login button
    Then HKLD engineer login disalbed