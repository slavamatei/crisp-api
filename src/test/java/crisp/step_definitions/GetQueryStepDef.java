package crisp.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;

public class GetQueryStepDef {

    Response response;
    String uri = "https://apimgmt-dev-crisp.azure-api.net/patients/query/";

    @Given("I make a GET request to query endpoint")
    public void iMakeAGETRequestToQueryEndpoint() {
        response = given()
                .get();
    }

    @When("I get response with status code {int}")
    public void iGetResponseWithStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("I should see a list of patients")
    public void i_should_see_a_list_of_patients() {
        response
                .then()
                .body("Id", Matchers.hasSize(4));
    }

    @Given("I make a GET request with {string} query parameter")
    public void iMakeAGETRequestWithQueryParameter(String id) {
        response = given()
                .queryParam("Id", id)
                .get();
    }

    @Then("I should get only one patient in response body matching given {string}")
    public void iShouldGetOnlyOnePatientInResponseBodyMatchingGiven(String id) {
        response.then()
                .body("[0].Id", Matchers.is(id),
                        "Id", Matchers.hasSize(1));
    }


    @Given("I make a GET request with {string} query param")
    public void iMakeAGETRequestWithQueryParam(String dateOfBirth) {
        response = given()
                .queryParam("DateOfBirth", dateOfBirth)
                .get();

    }

    @Then("I should get only patients matching {string}")
    public void iShouldGetOnlyPatientsMatching(String dateOfBirth) {
        response.then()
                .body("[0].DateOfBirth", Matchers.is(dateOfBirth));
    }

    @Given("I make a GET request with {string} query params")
    public void iMakeAGETRequestWithQueryParams(String address) {
        response = given()
                .queryParam("Address", address)
                .get();
    }

    @Then("I should get only patients matching given {string}")
    public void iShouldGetOnlyPatientsMatchingGiven(String address) {
        response.then()
                .body("[0].Address", Matchers.is(address));
    }

    @Given("I make a GET request with name query param {string}")
    public void iMakeAGETRequestWithNameQueryParam(String name) {
        response = given()
                .queryParam("Name", name)
                .get();
    }


    @Then("I should get only patients matching provided {string}")
    public void iShouldGetOnlyPatientsMatchingProvided(String name) {
        response.then()
                .body("[0].Name", Matchers.is(name));
    }


    @Given("I make a request with {string}, {string}, {string} and {string} query parameters")
    public void iMakeARequestWithAndQueryParameters(String id, String name, String dob, String address) {
        response = given()
                .queryParams("Id", id, "Name", name, "DateOfBirth", dob, "Address", address)
                .get();
    }


    @Then("I should get only one patient matching {string}, {string}, {string} and {string}")
    public void iShouldGetOnlyOnePatientMatchingAnd(String id, String name, String dob, String address) {
        response.then()
                .body("[0].Id", Matchers.is(id),
                        "[0].Name", Matchers.is(name),
                        "[0].DateOfBirth", Matchers.is(dob),
                        "[0].Address", Matchers.is(address));
    }

    @Given("I make a POST request")
    public void iMakeAPOSTRequest() {
        response = given()
                .post();
    }

    @Then("I get response with status code {int} and message {string}")
    public void iGetResponseWithStatusCodeAndMessage(int statusCode, String message) {
        response.then()
                .assertThat()
                .statusCode(404)
                .and()
                .body("message", Matchers.is(message));
    }

    @Given("I make a PUT request")
    public void iMakeAPUTRequest() {
        response = given()
                .put();
    }

    @Given("I make a PATCH request")
    public void iMakeAPATCHRequest() {
        response = given()
                .patch();
    }
}
