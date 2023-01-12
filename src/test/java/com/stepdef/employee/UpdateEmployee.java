package com.stepdef.employee;

import com.api.action.AddEmployee;
import com.api.action.PutEmployee;
import com.api.model.Employee;
import com.basic.BasicTestApi;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

public class UpdateEmployee extends BasicTestApi {

    @Before
    public void setUp(Scenario scenario) {
        context.scenario = scenario;
        assertTest = new api.methods.AssertTest(scenario);
    }

    @Given("an employee record is already added")
    public void createRecord() {
        response = AddEmployee.addEmployee(context, Employee.randomBuilder().toString());
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(200));
    }

    @Then("an employee with id {string} is updated and response status code {int} is returned")
    public void verifyUpdate(String id, int code) {
        response = PutEmployee.putCallMethod(context, id, Employee.randomBuilder().toString());
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
    }
}
