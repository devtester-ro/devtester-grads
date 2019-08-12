package ro.devtester.cucumber.stepdefinitions.petclinic;

import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.devtester.cucumber.api.ReqRespMediator;
import ro.devtester.cucumber.api.RequestHandler;
import ro.devtester.cucumber.stepdefinitions.utils.ExceptionHandler;

import java.util.concurrent.ConcurrentSkipListMap;

import static io.restassured.http.ContentType.JSON;

public class GetsStepDefinitions extends ReqRespMediator {

    private static final Logger logger
            = LoggerFactory.getLogger(GetsStepDefinitions.class);

    @Given("^making a GET request for (.*) to (.*)$")
    public void aUserRequestsAllVets(String id, String endpoint) {

        ConcurrentSkipListMap<String, String> pathParam = new ConcurrentSkipListMap<>();
        pathParam.put("id", id);

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