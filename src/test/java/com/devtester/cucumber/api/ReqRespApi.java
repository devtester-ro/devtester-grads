package com.devtester.cucumber.api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

public abstract class ReqRespApi {

    public static ValidatableResponse validatableResponse;
    public static RequestSpecification requestSpecification = RestAssured.given();



}
