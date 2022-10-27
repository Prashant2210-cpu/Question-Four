Feature: Execute API calls having two query parameters

  Scenario Outline:
    Given API with base URL and resource and have two or three query parameters
    When GET API method is used to get API response having two query parameter <firstQueryKey>, <firstQueryValue>, <secondQueryKey>, <secondQueryValue>
    Then Validate response code for feature one
    And Get attributes from response body - latitude, longitude, description, pressure, country, name for feature one
    Examples:
      | firstQueryKey | firstQueryValue | secondQueryKey | secondQueryValue                  |
      | q             | London          | appid          | b1b15e88fa797225412429c1c50c122a1 |
      | q             | London,uk       | appid          | b1b15e88fa797225412429c1c50c122a1 |
      | id            | 2172797         | appid          | b1b15e88fa797225412429c1c50c122a1 |
      | zip           | 94040,us        | appid          | b1b15e88fa797225412429c1c50c122a1 |
