package com.devtester.cucumber.stepdefinitions.petclinic;

import com.devtester.cucumber.api.ReqRespApi;
import cucumber.api.java.en.When;

public class ResponseStepDefinitions extends ReqRespApi {

    @When("^receiving the (.*) code$")
    public void receivingTheStatusCode(int status) {
        validatableResponse.statusCode(status);
    }

}
