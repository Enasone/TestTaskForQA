package io.cucumber.weatherstack;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static weatherstack.apis.Endpoints.WeatherStack.CURRENT_WEATHER;

public class CurrentWeatherSteps extends RunnerTest {

    private ValidatableResponse response;
    private String accessToken;

    @Given("Authorized user with access key {string}")
    public void authorizedUserWithAccessKey(String token) {
        this.accessToken = token;
    }

    @When("A request is called to get the current weather for the city of {string}")
    public void aRequestIsCalledToGetTheCurrentWeatherForTheCityOfCity(String queryValue) {
        response =
                given()
                        .queryParam("query", queryValue)
                        .queryParam("access_key", accessToken)
                        .when()
                        .contentType(ContentType.JSON)
                        .get(CURRENT_WEATHER)
                        .then();
    }


    @Then("In response we receive current weather data in the city: {string}, {string}, {string}")
    public void inResponseWeReceiveCurrentWeatherDataInTheCity(String queryValue, String languageValue, String country) {

        response.assertThat()
                .statusCode(200)
                .body("request.type", equalTo("City"))
                .body("request.query", equalTo(queryValue))
                .body("request.language", equalTo(languageValue))
                .body("location.country", equalTo(country))
                .log();
    }

    @When("A request is called to get the current weather for the city of without access key in query-param")
    public void aRequestIsCalledToGetTheCurrentWeatherForTheCityOfWithoutAccessKeyInQueryParam() {
        response =
                given()
                        .queryParam("query", "New York")
                        .when()
                        .contentType(ContentType.JSON)
                        .get(CURRENT_WEATHER)
                        .then();
    }

    @Given("Existing invalid access key {string}")
    public void existingInvalidAccessKey(String tokenValue) {
        this.accessToken = tokenValue;
    }

    @When("A request is called to get the current weather for the city with invalid access key in query-param")
    public void aRequestIsCalledToGetTheCurrentWeatherForTheCityWithInvalidAccessKeyInQueryParam() {
        response =
                given()
                        .queryParam("query", "New York")
                        .queryParam("access_key", accessToken)
                        .when()
                        .contentType(ContentType.JSON)
                        .get(CURRENT_WEATHER)
                        .then();
    }

    @When("A request is called to get the current weather for the city without required query-param: query")
    public void aRequestIsCalledToGetTheCurrentWeatherForTheCityWithoutRequiredQueryParamQuery() {
        response =
                given()
                        .queryParam("access_key", accessToken)
                        .when()
                        .contentType(ContentType.JSON)
                        .get(CURRENT_WEATHER)
                        .then();
    }

    @When("A request is called to get the current weather for the city with mistake in endpoint curent")
    public void aRequestIsCalledToGetTheCurrentWeatherForTheCityWithMistakeInEndpointCurent() {
        response =
                given()
                        .queryParam("query", "New York")
                        .queryParam("access_key", accessToken)
                        .when()
                        .contentType(ContentType.JSON)
                        .get("http://api.weatherstack.com/curent")
                        .then();
    }

    @Then("In response we receive error with code : {int}, message: {string} and info: {string}")
    public void inResponseWeReceiveErrorWithCodeMessageAndInfo(int codeValue, String typeValue, String infoValue) {
        response.assertThat()
                .body("success", equalTo(false))
                .body("error.code", equalTo(codeValue))
                .body("error.type", equalTo(typeValue))
                .body("error.info", equalTo(infoValue));
    }
}
