package ro.devtester.cucumber.stepdefinitions.superheroes;

import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.devtester.cucumber.api.ReqRespMediator;
import ro.devtester.cucumber.api.RequestHandler;
import ro.devtester.cucumber.stepdefinitions.utils.ExceptionHandler;
import ro.devtester.model.NewSuperhero;

import static io.restassured.http.ContentType.JSON;

public class PostStepDefinitions extends ReqRespMediator {

    private static final Logger logger
            = LoggerFactory.getLogger(PostStepDefinitions.class);

    @Given("^making a POST request")
    public void aUserMakesPostRequest() {

        //Create a default superhero
        NewSuperhero testSuperhero = new NewSuperhero();
        testSuperhero.setId(132L);
        testSuperhero.setName("CaptainMarvel");
        testSuperhero.setTag("TimeTravel");

        //Build request
        RequestHandler.Builder requestApi = new RequestHandler.Builder()
                .initRequest()
                .setContentType(JSON)
                .setBody(testSuperhero)
                .addContentType()
                .bodyApiSpecification()
                .setEndpoint("/superheroes");

        logger.info("Request POST - build successfully");

        try {
            validatableResponse = requestApi.whenPostRequestResponse();
        } catch (Exception e) {
            throw new ExceptionHandler("Request POST - did not go as expected: " + e);
        }
    }
}
