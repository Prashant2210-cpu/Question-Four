Feature: Execute API calls having three query parameters

  Scenario Outline:
    Given API with base URL and resource and have two or three query parameters
    When GET API method is used to get API response having three query parameter <firstQueryKey>, <firstQueryValue>, <secondQueryKey>, <secondQueryValue>,<thirdQueryValue>,<thirdQueryKey>
    Then Validate response code for feature two
    And Get attributes from response body - latitude, longitude, description, pressure, country, name for feature two
    Examples:
      | firstQueryKey | firstQueryValue | secondQueryKey | secondQueryValue | thirdQueryValue | thirdQueryKey                     |
      | lat           | 35              | lon            | 139              | appid           | b1b15e88fa797225412429c1c50c122a1 |

