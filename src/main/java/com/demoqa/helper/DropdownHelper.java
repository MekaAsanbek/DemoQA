package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownHelper {
    public  WebDriver driver;

    public DropdownHelper(WebDriver driver){
        this.driver = driver;
    }

    public DropdownHelper selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        return  this;
    }

    public DropdownHelper selectByVisibleText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }

    // Метод для получения всех опций из <select> элемента в список
    public List<String> getAllSelectOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : options) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }


    // метод, который кликает на поля select и собирает варианты(3 поля options) и потом конвертирует в Лист Стринговый
    public List<String> getAllDivOptions(WebElement element, String xpath){
        WebElementActions webElementActions = new WebElementActions();
        webElementActions.click(element);
        List<WebElement> options = DriverManager.getDriver().findElements(By.xpath(xpath));
        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }


    // String element = driver.findElement(By.xpath(xpath)).getText();
    // sout(element);
    // на консоли: Green например (String)


}
