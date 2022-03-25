@Regression
Feature: Verify the Track Functionality

  Scenario: Negative Functionality to verify the Track button
    Given Track module is highlighted by default
    When user enter wrong trackingNumber
    And Click on Track button
    Then User should Navigate to the Detail tracking page
    And Error message should display
