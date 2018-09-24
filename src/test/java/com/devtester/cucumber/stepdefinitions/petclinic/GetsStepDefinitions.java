package com.devtester.cucumber.stepdefinitions.petclinic;

import com.devtester.cucumber.api.ReqRespMediator;
import com.devtester.cucumber.api.RequestHandler;
import com.devtester.cucumber.stepdefinitions.utils.ExceptionHandler;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentSkipListMap;

import static io.restassured.http.ContentType.JSON;

public class GetsStepDefinitions extends ReqRespMediator {

    private static final Logger logger
            = LoggerFactory.getLogger(GetsStepDefinitions.class);

    @Given("^making a GET request for (.*) to (.*)$")
    public void aUserRequestsAllVets(String type, String endpoint) {

        ConcurrentSkipListMap<String, String> pathParam = new ConcurrentSkipListMap<>();
        pathParam.put("type", type);

        RequestHandler.Builder requestApi = new RequestHandler.Builder()
                .initRequest()
                .setContentType(JSON)
                .setPathParams(pathParam)
                .addContentType()
                .addPathParamsForApiSpecification()
                .setEndpoint(endpoint);

        logger.info("Request GET - build successfully");

        try {
            validatableResponse = requestApi.whenGetRequestResponse();
        } catch (Exception e){
            throw new ExceptionHandler("Request GET - did not go as expected: " + e);
        }

    }

}