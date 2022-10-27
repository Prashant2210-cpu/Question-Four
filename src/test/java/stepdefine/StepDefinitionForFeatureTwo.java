package stepdefine;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class StepDefinitionForFeatureTwo extends BaseClass {

    public String response;
    JsonPath jsonPath;

    @When("^GET API method is used to get API response having three query parameter (.+), (.+), (.+), (.+),(.+),(.+)$")
    public void get_api_method_is_used_to_get_api_response_having_three_query_parameter_(String firstKey, String firstValue, String secondKey, String secondValue, String thirdKey, String thirdValue) throws FileNotFoundException {
        RestAssured.baseURI = baseURL;


        response = given().log().all().queryParam(firstKey,firstValue).queryParam(secondKey,secondValue).queryParam(thirdKey,thirdValue)
                .when().log().all().get(resource)
                .then().log().all().extract().response().asString();
    }

    @Then("^Validate response code for feature two$")
    public void Validate_response_code_for_feature_two() {
        jsonPath = new JsonPath(response);

        String responseCode = jsonPath.getString("cod");
        System.out.println("Response code is " + responseCode);

        if (responseCode.equals("200")) {
            Assert.assertTrue(true);
        } else
            Assert.fail();
    }

    @And("Get attributes from response body - latitude, longitude, description, pressure, country, name for feature two")
    public void get_attributes_from_response_body_latitude_longitude_description_pressure_country_name_for_feature_two()  {
        System.out.println("Longitude : " +jsonPath.getString("coord.lon"));
        System.out.println("Latitude : " +jsonPath.getString("coord.lat"));
        System.out.println("Description : " +jsonPath.getString("weather.description"));
        System.out.println("Pressure : " +jsonPath.getString("main.pressure"));
        System.out.println("Country : " +jsonPath.getString("sys.country"));
        System.out.println("Name : " +jsonPath.getString("name"));
    }


}
