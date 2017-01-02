package feature.controller;


import com.jayway.restassured.RestAssured;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClusterRestControllerSteps {

    String test;

    @Given("index jsp page with latam background and show a link for click")
    public void indexPage() throws Exception{
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/clustering";
        test = "a";
        String path = "/matriz/";
        expect().statusCode(200).when().post(path);

    }

    @When("click in link")
    public void clickLink(){
        assertThat("a", equalTo("a"));
        test = "b";
    }

    @Then("show other jsp page with same background")
    public void showOtherPage(){
        assertThat("b", equalTo("b"));
    }

}
