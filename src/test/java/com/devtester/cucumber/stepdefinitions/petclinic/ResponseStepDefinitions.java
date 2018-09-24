package com.devtester.cucumber.stepdefinitions.petclinic;

import com.devtester.cucumber.api.ReqRespMediator;
import cucumber.api.java.en.When;

public class ResponseStepDefinitions extends ReqRespMediator {

    @When("^receiving the (.*) code$")
    public void receivingTheStatusCode(int status) {
        validatableResponse.statusCode(status);
    }

}
