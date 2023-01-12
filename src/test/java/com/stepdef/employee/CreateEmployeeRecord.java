package com.stepdef.employee;

import com.api.action.AddEmployee;
import com.api.helper.json.JsonUtil;
import com.api.model.Employee;
import com.basic.BasicTestApi;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import static com.api.helper.json.JsonUtil.parseJson;

public class CreateEmployeeRecord extends BasicTestApi {

    @Before
    public void setUp(Scenario scenario) {
        context.scenario = scenario;
        assertTest = new api.methods.AssertTest(scenario);
    }

    @Given("an employee record is added")
    public void insertEmployee() {
        JSONObject employeeJson = parseJson("./src/test/resources/payload/employee.json");
        response = AddEmployee.addEmployee(context, employeeJson.toString());
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(200));
    }

    @Then("a random employee is added and status code {int} is returned")
    public void responseVerify(int code) {
        response = AddEmployee.addEmployee(context, JsonUtil.toStringJson(Employee.randomBuilder()));
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
    }

}

