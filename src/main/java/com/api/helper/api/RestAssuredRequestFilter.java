package com.api.helper.api;

import io.cucumber.java.Scenario;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.log4j.Log4j;

@Log4j
public class RestAssuredRequestFilter implements Filter {

    private Scenario scenario;

    public RestAssuredRequestFilter(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        scenario.log("\n");
        scenario.log("Execute request: " + requestSpec.getMethod());
        scenario.log("URI: " + requestSpec.getURI());

        //scenario.log("Request Header: \n" + requestSpec.getHeaders());

        scenario.log("Body: " + requestSpec.getBody());
        scenario.log("Status: " + response.getStatusLine());

        //scenario.log("Response Header: \n"+ response.getHeaders());

        scenario.log("Response Body => " + response.getBody().asString());

        return response;
    }
}