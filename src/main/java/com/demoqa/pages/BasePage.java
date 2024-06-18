package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.*;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        // проинициализируй элемент в текущий класс (this в каждом классе наследнике будет меняться на названиекласса.class)
    }

    public WebElementActions webElementActions = new WebElementActions();
    public AlertHelper alertHelper = new AlertHelper(DriverManager.getDriver());
    public BrowserHelper browserHelper = new BrowserHelper(DriverManager.getDriver());

    public DropdownHelper dropdownHelper = new DropdownHelper(DriverManager.getDriver());

    public IframeHelper iframeHelper = new IframeHelper(DriverManager.getDriver());


}
