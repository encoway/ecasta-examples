Feature: Search on Google
  As an user
  I want to search for encoway on Google

  Scenario: results are shown
    Given the user has started the application
    When I search for "encoway"
    Then a browser title should contains "encoway"