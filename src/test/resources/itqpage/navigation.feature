Feature:Test the navigation function on the hamburger menu bar

  @navigation
  Scenario: Test the page navigation function
    Given  Open ETender home page with Browser
    When Click hamburger button and click ITQ/Tenders
    Then Navigate to ITQ/Tenders page
