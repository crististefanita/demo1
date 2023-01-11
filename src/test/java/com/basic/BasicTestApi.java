package com.basic;

import com.api.context.TestContext;
import io.restassured.response.Response;

public class BasicTestApi {
    protected static TestContext context;

    public BasicTestApi() {
        context = new TestContext();
    }

    public BasicTestApi(TestContext context) {
        this.context = context;
    }

    protected static Response response;

}
