package com.api.helper.cucumber;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Log4j
public class MyTestListener implements ConcurrentEventListener {
    private static final Logger LOG = LogManager.getLogger(MyTestListener.class);

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        Throwable error = result.getError();
        String scenarioName = testCase.getName();
        if (error != null) {
            log.info(error);
        }
        log.info("*****************************************************************************************");
        log.info("	Scenario: " + scenarioName + " --> " + status.name());
        log.info("*****************************************************************************************");
    }
}