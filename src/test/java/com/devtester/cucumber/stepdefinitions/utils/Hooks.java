package com.devtester.cucumber.stepdefinitions.utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger logger
            = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario() {

        logger.info("RestAssured - Start - Setup Base Request");

        RestAssured.baseURI = PropertiesUtil.getAppBaseUri();
        RestAssured.port = PropertiesUtil.getAppPort();
        RestAssured.basePath = PropertiesUtil.getAppBasePath();
        RestAssured.useRelaxedHTTPSValidation("TLSv1.2");

        logger.info("RestAssured - Finish - Setup Base Request");

    }

    @After
    public void afterScenario() {
        logger.info("This will be executed after!");
    }
}
