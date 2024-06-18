package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElementActions {
    // вспомогательный класс, где будем хранить все что связано с вебэлементами(взаимодействия: кликать, найти, записать и тд)

    public Actions actions = new Actions(DriverManager.getDriver());

    @BeforeClass(alwaysRun = true)
    public void init(){
        actions = new Actions(DriverManager.getDriver());
    }




    public WebElementActions click(WebElement element){
        waitElementToBeClickAble(element);
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions clickAfterFiveSeconds(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
        return this;
    }

    public WebElementActions clickColorChange(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBe(By.id("colorChange"), "class", "mt-4 text-danger btn btn-primary"));
        return this;
    }

    public WebElementActions visibleAfterFiveSeconds(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        return this;
    }


    public WebElementActions sendKeys(WebElement element, String txt){
        waitElementToBeVisible(element);
        scrollToElement(element);
        highlightElement(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions sendKeysWithEnter(WebElement element, String txt){
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }


    public WebElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;

        //  JavascriptExecutor работает только с html кодом, ему без разницы что там на самой странице(есть кнопка или нет, или может неактивна),
        //  поэтому его надо использовать в исключительных ситуациях. А обычно надо использовать обычный клик вебдрайвера.
    }

    public WebElementActions jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red';", element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value=arguments[1];", element, txt);
        return this;
    }

    public WebElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element){
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        return this;
    }

    public void pause(Integer milliseconds){
        try{
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public WebElementActions clearAndSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        return this;
    }

//    public void pause1(Integer seconds){
//        try{
//            TimeUnit.SECONDS.sleep(seconds);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    } либо просто в секундах указываем а не в миллисекундах (миллисекунды это - 5000, а секунды это просто - 5)



}
