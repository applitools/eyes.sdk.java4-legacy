package com.applitools.eyes.selenium;

import com.applitools.eyes.RectangleSize;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.model.Statement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(JUnit4.class)
public class TestSpecialCases_Chrome extends TestSpecialCases {
    @ClassRule
    public static final TestRule setTestSuitName = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            testSuitName = "Eyes Selenium SDK - Special Cases";
            testedPageUrl = "file:///C:/Users/USER/devel/demo_pages/TestPages/WixLikeTestPage/index.html";
            testedPageSize = new RectangleSize(1024,600);
            hideScrollbars = true;
            forceFullPageScreenshot = false;
        }
    };

    @Rule
    public final TestRule beforeTest = new TestWatcher() {
        @Override
        public Statement apply(Statement statement, Description description) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.setHeadless(true);
            caps = options;
            return statement;
        }
    };
}
