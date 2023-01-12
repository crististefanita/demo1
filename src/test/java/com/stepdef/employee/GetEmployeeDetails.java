package com.stepdef.employee;

import api.methods.AssertTest;
import com.api.action.GetEmployee;
import com.api.helper.file.PropertiesFile;
import com.basic.BasicTestApi;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.hamcrest.Matchers;


@Log4j
public class GetEmployeeDetails extends BasicTestApi {

    @Before
    public void setUp(Scenario scenario) {
        context.scenario = scenario;
        assertTest = new AssertTest(scenario);
    }

    @Then("details of employees with status code {int} is received")
    public void fetchDetails(int code) {
        response = GetEmployee.callGetAllEmployees(context);
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
    }

    @Then("details of employee with id {string} and status code {int} is received")
    public void singleEmployee(String id, int code) {
        response = GetEmployee.callGetAnEmployee(context, id);
        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
        assertTest.assertHard("Check content type", response.getContentType(), Matchers.is(PropertiesFile.getProperty("content.type")));
    }

    @Then("status code {int} is received")
    public void noRecord(int code) {
        response = GetEmployee.callGetAnEmployee(context, "");

        assertTest.assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
        assertTest.assertHard("Check content type", response.getContentType(), Matchers.is(PropertiesFile.getProperty("content.type")));
    }
}

