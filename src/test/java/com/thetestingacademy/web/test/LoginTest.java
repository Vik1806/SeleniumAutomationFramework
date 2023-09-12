package com.thetestingacademy.web.test;

import com.aventstack.extentreports.ExtentTest;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.DashboardPage;
import com.thetestingacademy.pages.LoginPage;
import com.thetestingacademy.utils.ProperReader;
import com.thetestingacademy.web.testbase.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

import java.lang.reflect.Method;


public class LoginTest extends TestBase { // Inheritance
    ExtentTest test;
    private static final Logger logger = LogManager.getLogger(LoginTest.class);


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Valid Credentials are working file")
//    @Test(groups = {"P0", "negative", }, priority = 1)
    @Test(groups = {"QA"})
    public void invalid_loginVWO(Method method) throws Exception {
        // Navigate, Login to VWO and Assert
        // Abstraction
        test = createTest(method.getName());
        DriverManagerTL.getDriver().get(ProperReader.readKey("url"));
        String expectResult = new LoginPage().loginToVWO(false).error_message_text();
        logger.info("Failed");

        if (expectResult.equalsIgnoreCase(expectResult)) {
            logger.info("Failed");
            test.fail("Failed Testcases");
            test.addScreenCaptureFromBase64String(captureScreenshot(DriverManagerTL.getDriver()));
            takeScreenShot(method.getName(),DriverManagerTL.getDriver());
        }

        Assertions.assertThat(expectResult)
                .isNotBlank().isNotNull().contains(ProperReader.readKey("expected_error"));

    }




}
