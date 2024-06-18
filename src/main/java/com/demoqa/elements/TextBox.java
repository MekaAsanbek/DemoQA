package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TextBox {

//@Test
//    void textBoxTest(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//
//    WebDriver driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    driver.manage().window().maximize();
//    driver.get("https://demoqa.com/text-box");
//
//    WebElement fullName = driver.findElement(By.id("userName"));
//    fullName.sendKeys("Meerim Asanbekova");
//
//    WebElement email = driver.findElement(By.id("userEmail"));
//    email.sendKeys("meerim@example.com");
//
//    WebElement currentAddress = driver.findElement(By.id("currentAddress"));
//    currentAddress.sendKeys("123 Chui St, Bishkek, KG");
//
//    WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
//    permanentAddress.sendKeys("456 Main St, New-York, USA");
//
//    WebElement submitButton = driver.findElement(By.id("submit"));
//    submitButton.click();
//
//
//    driver.close();
//    driver.quit();
//}



        WebDriver driver;

// Этот метод инициализирует WebDriver и открывает нужный URL перед всеми тестами.
        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/text-box");
        }
    // Этот метод закрывает и завершает работу WebDriver после всех тестов.
        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }

    // Этот тест заполняет поле name
        @Test(priority = 1)
        public void testFullName() {
            String userName = "Meerim";
            WebElement fullName = driver.findElement(By.id("userName"));
            fullName.sendKeys(userName);
            Assert.assertEquals(userName, "Meerim");
        }

    // Этот тест заполняет поле email
        @Test(priority = 2)
        public void testEmail() {
            String userEmail = "meerim@example.com";
            WebElement email = driver.findElement(By.id("userEmail"));
            email.sendKeys(userEmail);
            Assert.assertEquals(userEmail, "meerim@example.com");
        }

    // Этот тест заполняет поле currentAddress
        @Test(priority = 3)
        public void testCurrentAddress() {
            String userCurAdd = "123 Chui St, Bishkek, KG";
            WebElement currentAddress = driver.findElement(By.id("currentAddress"));
            currentAddress.sendKeys(userCurAdd);
            Assert.assertEquals(userCurAdd, "123 Chui St, Bishkek, KG");
        }

    // Этот тест заполняет поле permanentAddress
        @Test(priority = 4)
        public void testPermanentAddress() {
            String userPermAdd = "456 Main St, New-York, USA";
            WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
            permanentAddress.sendKeys(userPermAdd);
            Assert.assertEquals(userPermAdd, "456 Main St, New-York, USA");
        }

    // Этот тест скролит и нажимает кнопку submit
        @Test(priority = 5)
        public void testSubmitButton() {
            WebElement submitButton = driver.findElement(By.id("submit"));
            // Скроллим страницу до кнопки submit. Используется JavascriptExecutor для выполнения JavaScript кода, который прокручивает страницу до элемента submitButton.
            //Метод executeScript с аргументом "arguments[0].scrollIntoView(true);" прокручивает страницу так, чтобы элемент submitButton стал видимым.
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            submitButton.click();

//            // либо используем Actions для прокрутки до элемента submitButton вместо джаваскрипта
//            Actions actions = new Actions(driver);
//            actions.moveToElement(submitButton);
//            // Выполняем действие
//            actions.perform();

        }






}


