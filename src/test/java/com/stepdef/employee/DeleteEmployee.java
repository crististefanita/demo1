package com.stepdef.employee;

import com.basic.BasicTestApi;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

public class DeleteEmployee extends BasicTestApi {

    @Before
    public void setUp(Scenario scenario) {
        context.scenario = scenario;
        assertTest = new api.methods.AssertTest(scenario);
    }

    @Then("an employee id {string} is deleted and response status code {int} is returned")
    public void verifyStatus(String id, int statusCode) {
        response = com.api.action.DeleteEmployee.deleteEmployee(context, id);
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(statusCode));
    }

    @Given("an employee record is not added")
    public void noUserAdded() {
    }

}
