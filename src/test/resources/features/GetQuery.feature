@queryEndpoint
Feature: Validate Query API Endpoint Filtering Patients Data

  Scenario: Get All Patients
    Given I make a GET request to query endpoint
    When I get response with status code 200
    Then  I should see a list of patients

  Scenario Outline: Filter Patients By Id
    Given I make a GET request with "<Id>" query parameter
    When I get response with status code 200
    Then  I should get only one patient in response body matching given "<Id>"
    Examples:
      | Id  |
      | 111 |
      | 222 |
      | 333 |
      | 444 |


  Scenario Outline: Filter Patients By Date Of Birth
    Given I make a GET request with "<DateOfBirth>" query param
    When I get response with status code 200
    Then  I should get only patients matching "<DateOfBirth>"
    Examples:
      | DateOfBirth |
      | 1934-06-01 |
      | 1956-05-01 |
      | 1966-04-01 |
      | 2000-03-01 |


 Scenario Outline: Filter Patients By Address
    Given I make a GET request with "<Address>" query params
    When I get response with status code 200
    Then  I should get only patients matching given "<Address>"
    Examples:
    | Address|
      | CA |
      | MD |
      | CA State |
      | Valley State |


  Scenario Outline: Filter Patients By Name
    Given I make a GET request with name query param "<Name>"
    When I get response with status code 200
    Then  I should get only patients matching provided "<Name>"
    Examples:
      | Name|
      | Jenn D. |
      | Jack    |
      | Bernard |
      | Ross C. |
      | Slava   |


  Scenario Outline: Filter Patients Using All Data
    Given I make a request with "<Id>", "<Name>", "<DateOfBirth>" and "<Address>" query parameters
    When I get response with status code 200
    Then I should get only one patient matching "<Id>", "<Name>", "<DateOfBirth>" and "<Address>"
    Examples:
      | Id    | Name               | DateOfBirth | Address                   |
      | 111   | Jenn D                 | 1934-06-01  | CA                   |
      | 222   | Jack        | 1956-05-01  | MD |
      | 333   | Bernard       | 1966-04-01  | CA State |
      | 444   | Ross C.      | 2000-03-01  | Valley State |


    Scenario: Validate Endpoint Does Not Accepts POST Method
      Given I make a POST request
      Then I get response with status code 404 and message "Resource not found"

  Scenario: Validate Endpoint Does Not Accepts PUT Method
    Given I make a PUT request
    Then I get response with status code 404 and message "Resource not found"

  Scenario: Validate Endpoint Does Not Accepts PATCH Method
    Given I make a PATCH request
    Then I get response with status code 404 and message "Resource not found"