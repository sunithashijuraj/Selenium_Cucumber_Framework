@Regression

Feature: Verify user is able to select the default language under UK

Scenario: Select the default language as English under UK

Given user navigated to the home page
When Choose Geo popup is displayed
Then user is able to select the English Language under UK
