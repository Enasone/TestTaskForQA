#language: en
Feature: Getting the current weather for the city

  @Success
  Scenario Outline: Request to get the current weather for the city
    Given Authorized user with access key "475d94a8b051de3fdfcfdbdbe28ac66d"
    When A request is called to get the current weather for the city of "<city>"
    Then In response we receive current weather data in the city: "<query>", "<language>", "<country>"

    Examples:
      | city     | query                              | language | country                  |
      | New York | New York, United States of America | en       | United States of America |
      | London   | London, United Kingdom             | en       | United Kingdom           |
      | Singapur | Singapur, Mexico                   | en       | Mexico                   |
      | Shanghai | Shanghai, China                    | en       | China                    |

  @Failure
  Scenario: Request to get the current weather for the city without access key
    When A request is called to get the current weather for the city of without access key in query-param
    Then In response we receive error with code : 101, message: "missing_access_key" and info: "You have not supplied an API Access Key. [Required format: access_key=YOUR_ACCESS_KEY]"

  @Failure
  Scenario: Request to get the current weather for the city with invalid access key
    Given Existing invalid access key "475d94a8b051de3fdfcfdbdbe28ac66ddds"
    When A request is called to get the current weather for the city with invalid access key in query-param
    Then In response we receive error with code : 101, message: "invalid_access_key" and info: "You have not supplied a valid API Access Key. [Technical Support: support@apilayer.com]"

  @Failure
  Scenario: Request to get the current weather for the city without required query-param
    Given Authorized user with access key "475d94a8b051de3fdfcfdbdbe28ac66d"
    When A request is called to get the current weather for the city without required query-param: query
    Then In response we receive error with code : 601, message: "missing_query" and info: "Please specify a valid location identifier using the query parameter."

  @Failure
  Scenario: Request to get the current weather for the city with api invalid function
    Given Authorized user with access key "475d94a8b051de3fdfcfdbdbe28ac66d"
    When A request is called to get the current weather for the city with mistake in endpoint curent
    Then In response we receive error with code : 103, message: "invalid_api_function" and info: "This API Function does not exist."

