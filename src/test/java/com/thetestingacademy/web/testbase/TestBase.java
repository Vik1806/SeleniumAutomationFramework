package com.thetestingacademy.web.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.thetestingacademy.driver.DriverManagerTL;

import java.lang.*;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBase {


    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/report.html");
    ExtentTest test;



    // Call to Driver, TakeScreenshot,
    @BeforeSuite
    protected void setUp() throws Exception {
        extent.attachReporter(spark);
        DriverManagerTL.init();
    }

    public ExtentTest createTest(String name) {
        return extent.createTest(name).assignCategory("Regression Test").assignDevice("MacOsx");
    }

    @BeforeTest
    public void setConfig() {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("VWO Testcases");
    }

    @AfterSuite
    protected void tearDown() {
        DriverManagerTL.down();
        extent.flush();
    }

    protected void takeScreenShot(String name, WebDriver driver) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination_filepath = new File(System.getProperty("user.dir") + "images/screenshot" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(srcfile, destination_filepath);
        return destination_filepath.toString();
    }

}
