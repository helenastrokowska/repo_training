Feature: devTo basic features

  Scenario: Open first seeing blog
    Given I go to devto main page
    When I click on first blog displayed
    Then I should be redirected to blog page

  Scenario: Open first seeing podcast
    Given I click text podcast in main page
    When I click on first cast displayed
    Then I should be redirected to cast site