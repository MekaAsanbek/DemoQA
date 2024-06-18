package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends  BasePage{

    @FindBy(id = "enableAfter")
    public WebElement enableAfterBtn;

    @FindBy(id = "colorChange")
    public WebElement colorChangeBtn;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfterBtn;
}
