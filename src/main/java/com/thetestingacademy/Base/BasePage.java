package com.thetestingacademy.Base;

import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected BasePage(){

    }

    protected void implicitwait(){
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    protected void enterInput(By by,String key) {DriverManagerTL.getDriver().findElement(by).sendKeys();}
    // Poly - Overload
    protected void enterInput(WebElement e,String keys) {e.sendKeys();}
    protected void clickElement(By by){DriverManagerTL.getDriver().findElement(by).click();}
    protected WebElement getElement(By key) {return DriverManagerTL.getDriver().findElement(key);}
    protected WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    protected WebElement visibilityOfElementLocated(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected WebElement elementToBeClickable(final By elementIdentier) {
        WebElement element = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementIdentier));
        return element;
    }

}
