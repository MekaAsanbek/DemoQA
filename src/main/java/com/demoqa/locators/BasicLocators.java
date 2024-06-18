package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {
    WebDriver driver;

    @Test(description = "Find by ID")
    void findByIdTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.className("mr-sm-2"));
        emailInput.sendKeys("doe@gmail.com");

        String textBoxText = driver.findElement(By.tagName("h1")).getText();
        System.out.println(textBoxText);


        driver.get("https://demoqa.com/links");


        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();

        WebElement badRequestLink = driver.findElement(By.partialLinkText("Bad"));
        badRequestLink.click();


        // Absolute xpath: /html/body/div[2]/div/div/div/div[2]/div[2]/form/div[2]/div[2]/input
        // такой подход нестабильный и ненадежный

        //Relative xpath: //textarea[@placeholder = 'Current Address'] либо (//textarea[@placeholder = 'Current Address'])[1]

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder = 'Current Address']"));
        currentAddress.sendKeys("Wall Street 123");

        WebElement permanentAddress = driver.findElement(By.xpath("//label[text() ='Permanent Address']"));
        permanentAddress.sendKeys("Chui Street 312");

         // @ - это атрибуты
        // * - это ищет во всех тегах

        // //div[normalize-space(text()) = 'How NambaFood works'] - normalize удаляет пробелы













    }
}
