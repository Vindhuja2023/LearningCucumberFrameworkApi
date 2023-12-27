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
Feature: Update Produts Using Patch method

  @UpdateName
  Scenario Outline: Update data using API
    Given the api is available
    When the endpoint "/products/" invoked using patch method and productId<productId>
    Then validate status code of 200 in response body
    And validate updated data reflect in response of product
    Examples:
      | productId |
      |   9999713 |
