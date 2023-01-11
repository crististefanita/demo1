package com.stepdef.employee;

import com.api.action.AddEmployee;
import com.api.helper.json.JsonUtil;
import com.api.model.Employee;
import com.basic.BasicTestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import static api.methods.AssertTest.assertHard;
import static com.api.helper.json.JsonUtil.parseJson;

public class CreateEmployeeRecord extends BasicTestApi {

    @Given("a employee record is added")
    public void insertEmployee() {
        JSONObject employeeJson = parseJson("./src/test/resources/payload/employee.json");
        response = AddEmployee.addEmployee(context, employeeJson.toString());
        assertHard("Check status code", response.getStatusCode(), Matchers.is(200));
    }

    @Then("a random employee is added and status code {int} is returned")
    public void responseVerify(int code) {
        response = AddEmployee.addEmployee(context, JsonUtil.toStringJson(Employee.randomBuilder()));
        assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
    }
}

