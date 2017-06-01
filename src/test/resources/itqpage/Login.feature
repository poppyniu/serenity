Feature:Test open baidu home page

@poppy
  Scenario Outline: Test open baidu home page with different browsers
    Given  Open ETender system home page with <Browser>
    When Open Biadu home page
    Then Close browser

    Examples:
      | Browser |
      | ie      |

