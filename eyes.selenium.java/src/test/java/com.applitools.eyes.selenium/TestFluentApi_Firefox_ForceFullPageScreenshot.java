package com.applitools.eyes.selenium;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.model.Statement;
import org.openqa.selenium.firefox.FirefoxOptions;

@RunWith(JUnit4.class)
public class TestFluentApi_Firefox_ForceFullPageScreenshot extends TestFluentApi {

    @ClassRule
    public static final TestRule setTestSuitName = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            testSuitName = "Eyes Selenium SDK - Fluent API - ForceFPS";
            testedPageUrl = "http://applitools.github.io/demo/TestPages/FramesTestPage/";
            forceFullPageScreenshot = true;
        }
    };

    @Rule
    public final TestRule beforeTest = new TestWatcher() {
        @Override
        public Statement apply(Statement statement, Description description) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            caps = options;
            return statement;
        }
    };
}
