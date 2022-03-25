@FunctionalTest, @Regression
Feature: Verify the HomePage of FedEx


  Scenario Outline: Verify the user is in Home Page
    Given I am on the FedEx Home Page
    When I Search for "<stringValue>" button
    Then the page title should start with FedEx

    Examples: 
      | stringValue |
      | TRACK       |
      | ENTER				| 
