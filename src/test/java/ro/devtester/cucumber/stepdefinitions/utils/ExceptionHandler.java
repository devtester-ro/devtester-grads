package ro.devtester.cucumber.stepdefinitions.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ExceptionHandler extends RuntimeException {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
        logger.error(message + "Caused by: " + Arrays.toString(cause.getStackTrace()));
    }

    public ExceptionHandler(String message) {
        super(message);
        logger.error("=======================================");
        logger.error("Following error has occurred: " + message);
    }
}