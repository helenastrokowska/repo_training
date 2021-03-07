Feature: devTo basic features

  Scenario: Open first seeing blog
    Given I go to devto main page
    When I click on first blog displayed
    Then I should be redirected to blog page

  Scenario: Open first seeing podcast
    Given I go to devto main page
    When I go to podcast section
    When I click on first cast displayed
    Then I should be redirected to cast site

  Scenario: Search the testing phrase
    Given I go to devto main page
    When I search for testing phrase
    Then Top 3 blogs found should have testing in title