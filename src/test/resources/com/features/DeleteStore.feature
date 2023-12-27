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
Feature: Delete Store Data

  @tag1
  Scenario Outline: Delete data using API
    Given the api is available
    When the endpoint "/stores/" invoked using delete method<storeId>
    Then validate status code of 200 in response body

    Examples: 
      | storeId |
      |    8946 |

  Scenario Outline:   : Attempt to delete non-existent data

    Given the api is available
    When the endpoint "/stores/" invoked using delete method<storeId>
    Then validate status code of 404 in response body

    Examples: 
      | storeId |
      |    8946 |
