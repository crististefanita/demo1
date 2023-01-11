package com.stepdef.employee;

import com.api.action.AddEmployee;
import com.api.action.PutEmployee;
import com.api.model.Employee;
import com.basic.BasicTestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import static api.methods.AssertTest.assertHard;

public class UpdateEmployee extends BasicTestApi {
    @Given("a employee record is already added")
    public void createRecord() {
        response = AddEmployee.addEmployee(context, Employee.randomBuilder().toString());
        assertHard("Check status code", response.getStatusCode(), Matchers.is(200));
    }

    @Then("the employee with id {string} is updated and response status code {int} is returned")
    public void verifyUpdate(String id, int code) {
        response = PutEmployee.putCallMethod(context, id, Employee.randomBuilder().toString());
        assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
    }
}
