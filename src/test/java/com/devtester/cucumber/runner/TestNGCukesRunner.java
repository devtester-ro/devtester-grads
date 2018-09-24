package com.devtester.cucumber.runner;

import com.devtester.cucumber.listener.ExtentProperties;
import com.devtester.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

@CucumberOptions(
        features = {"src/test/resources/features/petclinic/GetPetclinic.feature"},
        glue = {"com.devtester.cucumber.stepdefinitions"},
        plugin = {"com.devtester.cucumber.listener.ExtentCucumberFormatter:"}
)

public class TestNGCukesRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public  static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/DevTester-grads.html");
    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows 10");
        Reporter.setTestRunnerOutput("DevTester Runner Online");
    }
}