package com.devtester.cucumber.stepdefinitions.utils;

import org.apache.commons.exec.environment.EnvironmentUtils;

import java.util.Properties;

class PropertiesUtil {

    private static Properties props;

    static {
        try {
            String filePath = "properties/qa-local.properties";
            props = new Properties();
            props.load(EnvironmentUtils.class.getClassLoader().getResourceAsStream(filePath));
        } catch (Exception e) {
            throw new ExceptionHandler("Could not read property init file", e);
        }
    }

    static int getAppPort() {
        return Integer.parseInt(props.getProperty("appPort"));
    }

    static String getAppBaseUri() {
        return props.getProperty("appBaseURI");
    }

    static String getAppBasePath() {
        return props.getProperty("appBasePath");
    }

}
