@Regression
Feature: Validate the Open Personal Account Feature

Scenario Outline: Validate the Open a Personal Account Functionality

Given User is on the Open Account Page

When User clicks on the Open a Personal Account button

Then user navigates to the Contact details Page of Personal Account creation

And Enter the "<firstName>", "<lastName>", "<country>","<Address>", "<postalcode>","<city>", "<phone>", "<email>"

Then click on Enter Login Details

Examples:
|firstName|lastName|country|Address|postalcode|city|phone|email|
|Sunitha|Shiju|Netherlands|24 test address|2134|test|654658764|test@gmail.com|
|Aditi|Rao|India|abc test address|2135|test|654657764|test1@gmail.com|