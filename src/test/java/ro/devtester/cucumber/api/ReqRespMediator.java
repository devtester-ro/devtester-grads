package ro.devtester.cucumber.api;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public abstract class ReqRespMediator {

    public static ValidatableResponse validatableResponse;
    public static RequestSpecification requestSpecification;

}
