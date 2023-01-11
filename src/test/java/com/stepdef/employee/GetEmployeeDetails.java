package com.stepdef.employee;

import com.basic.BasicTestApi;
import com.api.action.GetEmployee;
import com.api.helper.file.PropertiesFile;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.hamcrest.Matchers;

import static api.methods.AssertTest.assertHard;


@Log4j
public class GetEmployeeDetails extends BasicTestApi {
    @Then("details of employees with status code {int} is received")
    public void fetchDetails(int code) {
        response = GetEmployee.callGetAllEmployees(context);
        assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
    }

    @Then("details of employee with id {string} and status code {int} is received")
    public void singleEmployee(String id, int code) {
        log.info("[test] singleEmployee ");
        response = GetEmployee.callGetAnEmployee(context, id);
        assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
        assertHard("Check content type", response.getContentType(), Matchers.is(PropertiesFile.getProperty("content.type")));
    }

    @Then("status code {int} is received")
    public void noRecord(int code) {
        response = GetEmployee.callGetAnEmployee(context, "");

        assertHard("Check status code", response.getStatusCode(), Matchers.is(code));
        assertHard("Check content type", response.getContentType(), Matchers.is(PropertiesFile.getProperty("content.type")));
    }

}

