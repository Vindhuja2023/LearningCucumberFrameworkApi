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
@tag
Feature: Create Categories

  @CreateCategory
  Scenario: Validate categoryId is generated when posted a req to create a category
    Given the api is available
    And the request body is created for category
      | name        | id         |
      | Electronics | ASFT123456 |
    When the endpoint "/categories" invoked for category using post method
    Then validate status code of 201 in response body
    And validate category id field in response body
