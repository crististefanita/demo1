package com.stepdef.employee;

import com.basic.BasicTestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import static api.methods.AssertTest.assertHard;

public class DeleteEmployee extends BasicTestApi {

    @Then("the employee id {string} is deleted and response status code {int} is returned")
    public void verifyStatus(String id, int statusCode) {
        response = com.api.action.DeleteEmployee.deleteEmployee(context, id);
        assertHard("Check status code", response.getStatusCode(), Matchers.is(statusCode));
    }

    @Given("a employee record is not added")
    public void noUserAdded() {
    }

}
