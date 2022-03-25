@Regression
Feature: FedEx Default Language Selection

@SmokeTest
  Scenario: Selecting Default Location and Language settings
    Given Open Chrome
    And Launch the Application
    And verify the default location
    And Click on the default Language
    Then Click on Accept Cookies
    
 