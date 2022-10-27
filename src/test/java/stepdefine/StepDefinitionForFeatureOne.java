package stepdefine;


import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class StepDefinitionForFeatureOne extends BaseClass {
     public String url;
     public String APIResource;

    public JsonPath jsonPath;
    public String response;




    @Given("^API with base URL and resource and have two or three query parameters$")
    public void API_with_base_URL_and_resource_and_have_two_or_three_query_parameters()
    {
        url = baseURL;
        APIResource = resource;

    }

        @When("^GET API method is used to get API response having two query parameter (.+), (.+), (.+),(.+)$")
        public void GET_API_method_is_used_to_get_API_response_having_two_query_parameter_(String firstKey, String firstValue, String secondKey, String secondValue)
        {
            RestAssured.baseURI = url;


             response = given().log().all().queryParam(firstKey,firstValue).queryParam(secondKey,secondValue)
                    .when().log().all().get(APIResource)
                    .then().log().all().extract().response().asString();
        }

    @Then("Validate response code for feature one")
    public void validate_response_code_for_feature_one()
    {
        jsonPath = new JsonPath(response);

        String responseCode = jsonPath.getString("cod");
        System.out.println("Response code is " + responseCode);

        if (responseCode.equals("200")) {
            Assert.assertTrue(true);
        } else
            Assert.fail();

    }
    @And("Get attributes from response body - latitude, longitude, description, pressure, country, name for feature one")
    public void get_attributes_from_response_body_latitude_longitude_description_pressure_country_name_for_feature_one()
    {

        System.out.println("Longitude : " +jsonPath.getString("coord.lon"));
        System.out.println("Latitude : " +jsonPath.getString("coord.lat"));
        System.out.println("Description : " +jsonPath.getString("weather.description"));
        System.out.println("Pressure : " +jsonPath.getString("main.pressure"));
        System.out.println("Country : " +jsonPath.getString("sys.country"));
        System.out.println("Name : " +jsonPath.getString("name"));

    }

}
