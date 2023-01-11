package com.api.helper.api;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.log4j.Log4j;

@Log4j
public class RestAssuredRequestFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);

        log.info("-----------------------------------------------------------------------------------------");
        log.info(" Request Method => " + requestSpec.getMethod() +
                "\n Request URI => " + requestSpec.getURI() +
                //"\n Request Header =>\n" + requestSpec.getHeaders() +
                "\n Request Body => " + requestSpec.getBody() +
                "\n\n Response Status => " + response.getStatusLine() +
                //"\n Response Header =>\n"+ response.getHeaders() +
                "\n Response Body => " + response.getBody().asString());
        log.info("-----------------------------------------------------------------------------------------");
        return response;
    }
}