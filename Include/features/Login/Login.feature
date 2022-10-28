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
@Login
Feature: Login Feature
  As a user, I want to login to upbanx.com

  @Valid
  Scenario Outline: Login with Valid Credential
    When I Hit Login API Endpoint with <username> and <password>
    Then The response should be <status>

    Examples: 
      | username           | password | status  |
      | creator@upbanx.com | password | success |
  
  @NotValid
  Scenario Outline: Login with NotValid Credential
    When I Hit Login API Endpoint with <username> and <password>
    Then The response should be <status>

    Examples: 
      | username           | password     | status |
      | creator@upbanx.com | not_password | failed |
