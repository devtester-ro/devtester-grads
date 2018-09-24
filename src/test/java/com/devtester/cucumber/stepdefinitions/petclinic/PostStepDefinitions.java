package com.devtester.cucumber.stepdefinitions.petclinic;

import com.devtester.cucumber.api.ReqRespMediator;
import com.devtester.cucumber.api.RequestHandler;
import com.devtester.cucumber.stepdefinitions.utils.ExceptionHandler;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentSkipListMap;

import static io.restassured.http.ContentType.JSON;

public class PostStepDefinitions extends ReqRespMediator {

    private static final Logger logger
            = LoggerFactory.getLogger(PostStepDefinitions.class);

    @Given("^making a POST request for (.*) to (.*)$")
    public void aUserRequestsAllVets(String method, String type, String endpoint) {

        ConcurrentSkipListMap<String, String> pathParam = new ConcurrentSkipListMap<>();
        pathParam.put("type", type);

        Object body = new Object(); //TODO - add actual objects for request

        RequestHandler.Builder requestApi = new RequestHandler.Builder()
                .initRequest()
                .setContentType(JSON)
                .setPathParams(pathParam)
                .setBody(body)
                .addContentType()
                .addPathParamsForApiSpecification()
                .bodyApiSpecification()
                .setEndpoint(endpoint);

        logger.info("Request POST - build successfully");

        try {
            validatableResponse = requestApi.whenPostRequestResponse();
        } catch (Exception e){
            throw new ExceptionHandler("Request POST - did not go as expected: " + e);
        }

    }
}
