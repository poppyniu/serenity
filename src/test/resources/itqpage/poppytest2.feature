Feature:Test open baidu home page and click news

  @poppy2
  Scenario: Test open baidu home page
    Given  Open baidu home page with Browser
    When See baidu home logo
    Then Click news hyperlink
    Then Go to news page
    Then Close browser


