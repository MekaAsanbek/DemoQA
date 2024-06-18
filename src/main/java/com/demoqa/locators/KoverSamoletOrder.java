package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KoverSamoletOrder {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }


    @Test(dataProvider = "testDatas")
    void testKoverSamolet(String name, String address, String phone, String changes, String notes) {

        WebElement category = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[2]/div[1]/a/img"));
        category.click();

        WebElement cuisine = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[2]/div/p[4]/a/img"));
        cuisine.click();

        WebElement cafe = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[2]/div[1]/div/div[2]/div[2]/a"));
        cafe.click();

        WebElement portions = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[1]/div[3]/div/div[2]/form/span[2]/input[1]"));
        portions.click();

        WebElement upButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[1]/div[3]/div/div[2]/form/button"));
        upButton.click();

        WebElement cart = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/div/div/div[2]"));
        cart.click();

        WebElement makeOrderButton = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/div/div/div[3]/p/a"));
        makeOrderButton.click();


        WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[1]/input"));
        userName.sendKeys(name);

        WebElement userAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[2]/input"));

        userAddress.sendKeys(address);

        WebElement userPhone = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[3]/input"));
        userPhone.sendKeys(phone);

        WebElement userMoney = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[4]/input"));
        userMoney.sendKeys(changes);

        WebElement userNotes = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[5]/textarea"));
        userNotes.sendKeys(notes);

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/button[1]"));
        submitButton.click();

        // Пример утверждения для проверки успешной отправки заказа
        WebElement successMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h2"));
        Assert.assertTrue(successMessage.isDisplayed(), "Благодарим Вас за заказ! Для подтверждения заказа в течение 5 минут с Вами свяжется оператор.");

    }

    @DataProvider(name = "testDatas")
    public Object[][] dostavkaDataProvider() {

        return new Object[][]{
//                {"Jama", "Chui 215", "0708123654", "2000", "Как можно скорее"},
                {"Altynai", "Jibek-Jolu 570", "0777369872", "5000", "Жду доставку в течение часа"}
        };
    }


    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


//
//    WebDriver driver;
//
//    // Этот метод инициализирует WebDriver и открывает нужный URL перед всеми тестами.
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//        driver.get("https://dostavka312.kg/");
//    }
//    // Этот метод закрывает и завершает работу WebDriver после всех тестов.
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.close();
//            driver.quit();
//        }
//    }
//
//
//    @Test(priority = 1)
//    public void testChooseCategoryFood() {
//        WebElement category = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[2]/div[1]/a/img"));
//        category.click();
//    }
//
//    @Test(priority = 2)
//    public void testChooseCuisine() {
//        WebElement category = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[2]/div/p[4]/a/img"));
//        category.click();
//    }
//
//    @Test(priority = 3)
//    public void testChooseCafe() {
//        WebElement category = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[2]/div[1]/div/div[2]/div[2]/a"));
//        category.click();
//    }
//
//    @Test(priority = 4)
//    public void testChoosePortion() {
//        WebElement category = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[1]/div[3]/div/div[2]/form/span[2]/input[1]"));
//        category.click();
//    }

//    @Test(priority = 5)
//    public void testChooseDish() {
//        WebElement upButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[1]/div[3]/div/div[2]/form/button"));
//        upButton.click();
//    }
//
//
//    @Test(priority = 6)
//    public void testClickCart() {
//        WebElement cart = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/div/div/div[2]"));
//        cart.click();
//    }
//
//    @Test(priority = 7)
//    public void testMakeOrder() {
//        WebElement makeOrderButton = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/div/div/div[3]/p/a"));
//        makeOrderButton.click();
//    }
//
//    @Test(priority = 8)
//    public void testName() {
//        WebElement name = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[1]/input"));
//        name.sendKeys("Meka");
//    }
//
//    @Test(priority = 9)
//    public void testAddress() {
//        WebElement address = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[2]/input"));
//        address.sendKeys("Frunze 312, kv 20");
//    }
//
//    @Test(priority = 10)
//    public void testPhone() {
//        WebElement phone = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[3]/input"));
//        phone.sendKeys("0550002999");
//    }
//
//    @Test(priority = 11)
//    public void testСhangeovers() { //сдача со скольки...
//        WebElement changes = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[4]/input"));
//        changes.sendKeys("1000");
//    }
//
//    @Test(priority = 12)
//    public void testAnyNotes() {
//        WebElement notes = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div[1]/div[1]/div[5]/textarea"));
//        notes.sendKeys("As soon as possible");
//    }
//
//
//    @Test(priority = 13)
//    public void testSubmitButton() {
//        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/button[1]"));
//        submitButton.click();
//    }

}
