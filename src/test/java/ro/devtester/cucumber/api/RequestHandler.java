package ro.devtester.cucumber.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.concurrent.ConcurrentSkipListMap;

public class RequestHandler extends ReqRespMediator {

    public static final class Builder {

        static ContentType type;
        static Object body;

        static String endpoint;

        static ConcurrentSkipListMap<String, String> pathParams = new ConcurrentSkipListMap<>();
        static ConcurrentSkipListMap<String, String> queryParams = new ConcurrentSkipListMap<>();

        public ValidatableResponse validatableResponse;

        public Builder setContentType(ContentType type) {
            Builder.type = type;
            return this;
        }

        public Builder setPathParams(ConcurrentSkipListMap<String, String> pathParams) {
            Builder.pathParams = pathParams;
            return this;
        }

        public Builder setQueryParams(ConcurrentSkipListMap<String, String> queryParams) {
            Builder.queryParams = queryParams;
            return this;
        }

        public Builder setBody(Object body) {
            Builder.body = body;
            return this;
        }

        public Builder setEndpoint(String endpoint) {
            Builder.endpoint = endpoint;
            return this;
        }

        public Builder initRequest() {
            requestSpecification = RestAssured.given();
            return this;
        }

        public Builder addContentType() {
            requestSpecification
                    .accept(type)
                    .contentType(type);
            return this;
        }

        /**
         * Adding Path and Query Params for endpoint call
         * Updates the requestSpecification
         */
        public Builder addPathParamsForApiSpecification() {
            requestSpecification.pathParams(pathParams);
            return this;
        }

        public Builder addQueryParamsForApiSpecification(ConcurrentSkipListMap<String, String> queryParams) {
            requestSpecification.queryParams(queryParams);
            return this;
        }

        /**
         * If body is needed than we update the requestSpecification
         */
        public Builder bodyApiSpecification() {
            requestSpecification.body(body);
            return this;
        }

        /**
         * Actual Call for Method e.g. GET POST
         * Return the object that will be validated
         */
        public ValidatableResponse whenGetRequestResponse() {

            return requestSpecification
                    .when().get(endpoint)
                    .then().log().all();
        }

        public ValidatableResponse whenPostRequestResponse() {

            return requestSpecification
                    .when().post(endpoint)
                    .then().log().all();
        }

    }

}