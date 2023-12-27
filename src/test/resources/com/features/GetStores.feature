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
Feature: View Store Details

  @GetAllStores @regression
  Scenario: Validate response for getting All Store Details
    Given the api is available
    When the endpoint "/stores" invoked
    Then validate status code of 200 in response body

  @GetAllStoresNegative @regression
  Scenario: Validate Error Code With Invalid Endpoint
    Given the api is available
    When the endpoint "/store" invoked
    Then validate status code of 404 in response body

  @GetAllStoresById @regression
  Scenario Outline: Validate Response For All Store With Valid Id
    Given the api is available
    When the endpoint "/stores/" invoked with <id>
    Then validate status code of 200 in response body

    Examples: 
      | id |
      |  4 |
      |  6 |

  @GetAllStoresByIdNegative @regression
  Scenario Outline: Validate Error Status Code  With Invalid Ids
    Given the api is available
    When the endpoint "/stores/" invoked with <id>
    Then validate status code of 404 in response body

    Examples: 
      | id |
      |  2 |
      |  3 |
