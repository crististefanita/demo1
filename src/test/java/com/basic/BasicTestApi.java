package com.basic;

import com.api.context.TestContext;
import io.restassured.response.Response;

public class BasicTestApi {
    protected static TestContext context;

    protected static api.methods.AssertTest assertTest;

    public BasicTestApi() {
        context = new TestContext();
    }

    protected static Response response;

}
