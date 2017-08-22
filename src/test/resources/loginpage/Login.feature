Feature:Test function on login page

  @Login
  Scenario: Test valid login for HKLD engineer
    Given  Open ETender system login page
    When Input valid user name and pwd and click login button
    Then HKLD engineer login to ETender system succeed

#  @EngineerLogout @logout
#  Scenario: Test valid login for HKLD engineer
#    Given  Open ETender system login page
#    When Input valid user name and pwd and click login button
#    Then HKLD engineer login to ETender system succeed
#    Then user logs out ETender
#    Then Logout Successfully

  @InvalidLogin
  Scenario: Test invalid login for HKLD engineer
    Given  Open ETender system login page
    When Input invalid user name and pwd and click login button
    Then HKLD engineer login disalbed

  @VendorLogin
  Scenario: Test valid login for contractor
    Given  Open contractor login page
    When Input valid contractor name and pwd and click login button
    Then Contractor login to ETender system succeed
#    Then  user logs out ETender

  @VendorInvalidLogin
  Scenario: Test invalid login for contractor
    Given  Open contractor login page
    When Input invalid contractor name and pwd and click login button
    Then Contractor login fail

  @VendorForgotPwd
  Scenario: Test contractor forget password
    Given  Open contractor login page
    And Click forgot passowrd link to send email
    Then Check the reset passord info is correct