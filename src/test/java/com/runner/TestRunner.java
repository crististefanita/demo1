package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                , "com.api.helper.cucumber.MyTestListener"
        }
        , features = {"src/test/resources/features"}
        , glue = {"com.stepdef.employee"}
        // , dryRun = false
        , monochrome = true
        , snippets = SnippetType.CAMELCASE
        //, tags = "@Sanity"
        , tags = "@Regression"
        //  , publish = true
)
public class TestRunner {

}