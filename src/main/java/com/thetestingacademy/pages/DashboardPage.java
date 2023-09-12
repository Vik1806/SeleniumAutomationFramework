package com.thetestingacademy.pages;

import com.thetestingacademy.Base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    DashboardPage(){

    }
    By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    public String loggedInUserName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}






