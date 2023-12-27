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
Feature: View Category Details

  @GetAllCategoriess @regression
  Scenario: Validate response for getting All Category Details
    Given the api is available
    When the endpoint "/categories" invoked
    Then validate status code of 200 in response body

  @GetAllCategoriesNegative @regression
  Scenario: Validate Error Code With Invalid Endpoint
    Given the api is available
    When the endpoint "/categorie" invoked
    Then validate status code of 404 in response body

  @GetAllCategoriesById @regression
  Scenario Outline: Validate Response For All Products With Valid Id
    Given the api is available
    When the endpoint "/categories/" invoked with <id>
    Then validate status code of 200 in response body

    Examples: 
      | id |
      |  1 |
      |  5 |

  @GetAllCategoriesByIdNegative @regression
  Scenario Outline: Validate Error Status Code  With Invalid Ids
    Given the api is available
    When the endpoint "/categories/" invoked with <id>
    Then validate status code of 404 in response body

    Examples: 
      | id  |
      | 200 |
      | 301 |
