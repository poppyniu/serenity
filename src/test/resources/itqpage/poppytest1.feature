Feature:Test open baidu home page and check home page logo exist

  @poppy1
  Scenario: Test open baidu home page and check home page logo exist
    Given  Open baidu home page with Browser
    When See baidu home logo
    Then Close browser
