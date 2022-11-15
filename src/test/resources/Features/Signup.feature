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

Feature: Signup
    Background: New user login
    Given launch facebook url

    Scenario: New user login
    #Given launch facebook url
    And enter user details
    When signup
    And enter facebook home 
    Then signout
    
    Scenario: New user login
    #Given launch facebook url
    And enter user details by using oneD map
    |first name|saravanan|
    |surname|s|
    |emailid|saravananrtr180@gamil.com|
    |re mailid|saravananrtr180@gmail.com|
    |password|apache134|
    |day|15|
    |month|May|
    |year|1990|
    |gender|Male|
    When signup
    And signup confirmation
    And enter facebook home 
    Then signout
    
    Scenario Outline: New user login
    #Given launch facebook url
    And enter user details "<first name>","<surname>","<emailid>","<re mailid>","<password>","<day>","<month>","<year>","<gender>"
    When signup
    And signup confirmation
    And enter facebook home 
    Then signout
    Examples:
    |first name|surname|emailid|re mailid|password|day|month|year|gender|
    |suresh|k|suresh@gmail.com|suresh@gmail.com|suresh123|16|May|1985|Male|
    |vivek|p|vivek@gmail.com|vivek@gmail.com|vivek123|12|Nov|1992|Male|
    

  
 