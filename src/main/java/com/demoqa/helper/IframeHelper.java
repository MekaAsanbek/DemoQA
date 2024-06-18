package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeHelper {

    private WebDriver driver;

    public IframeHelper(WebDriver driver){

        this.driver = driver;
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame(); //самый главный фрейм(родительский фрейм)
    }

    public void switchToFrame(String nameOrID){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
    }



}
