Feature:Test function on login page

  @Login @Regression
  Scenario: Test valid login for HKLD engineer
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed

  @EngineerLogout @logout @Regression
  Scenario: Test valid login for HKLD engineer
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed
    And user click hamburger icon
    And user logs out ETender
    Then Logout Successfully

  @InvalidLogin @Regression
  Scenario: Test invalid login for HKLD engineer
    Given  Open ETender system login page
    When Input invalid user name and pwd and click login button
    Then HKLD engineer login disalbed

  @VendorLogin @Regression
  Scenario: Test valid login for contractor
    Given  Open contractor login page
    When Input valid contractor name and pwd and click login button
    Then Contractor login to ETender system succeed
    Then  user logs out ETender

  @VendorInvalidLogin @Regression
  Scenario: Test invalid login for contractor
    Given  Open contractor login page
    When Input invalid contractor name and pwd and click login button
    Then Contractor login fail

  @VendorForgotPwd @Regression
  Scenario: Test contractor forget password
    Given  Open contractor login page
    And Click forgot password link to send email
    Then Check the reset password info is correct