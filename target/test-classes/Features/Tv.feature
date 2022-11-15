#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Tv
Background:
Given user login to flipkart

#Scenario: Tv purchage
#When user search Tv
#And user choose the Tv
#And user doing payment by using UPI
#Then user receives confirmation message
#
#Scenario: Tv purchage
#When user search Tv by using oneD list
#|realme|redme|poco|
#And user choose the Tv
#And user doing payment by using UPI
#Then user receives confirmation message
#
#Scenario: Tv purchage
#When user search Tv by using oneD map
#|Tv1|MI tv|
#|Tv2|samsung tv|
#|Tv3|readmi tv|
#And user choose the Tv
#And user doing payment by using UPI
#Then user receives confirmation message

Scenario Outline: Tv purchage
When user search Tv "<tv>"
And user choose the Tv
And user doing payment by using UPI
Then user receives confirmation message
Examples:
|tv|
|MI tv|
|samsung tv|
|readmi tv|
 