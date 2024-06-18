package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeWebDriver {

    public static WebDriver loadEdgeDriver(){ // статичный метод, который возвращает тип данных Вебдрайвер и который запускает и открывает браузер Эдж, будет вызываться по названию класса.
        System.setProperty("webdriver.msedge.driver", "src/main/resources/drivers/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    // Мы один раз создали этот метод и теперь можем использовать его везде где это нам нужно
}
