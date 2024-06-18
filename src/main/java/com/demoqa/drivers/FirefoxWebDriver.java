package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxWebDriver {

    public static WebDriver loadFirefoxDriver(){ // статичный метод, который возвращает тип данных Вебдрайвер и который запускает и открывает браузер Эдж, будет вызываться по названию класса.
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    // Мы один раз создали этот метод и теперь можем использовать его везде где это нам нужно
}
