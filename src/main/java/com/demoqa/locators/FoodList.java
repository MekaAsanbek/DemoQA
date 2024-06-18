package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FoodList {

    WebDriver driver;

    @Test
    void findByIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();

        driver.get("https://dostavka312.kg/category/11");
        List<WebElement> kafeList = driver.findElements(By.xpath("//div[@class='panel-heading']"));

        kafeList.forEach(kafe -> System.out.println(kafe.getText() + "\n======================================================"));

        kafeList.stream()
                .filter(kafe -> kafe.getText().equals("Ресторан Пишпек\nТоголока Молдо, 17/1а"))
                .findFirst()
                .ifPresent(kafe -> {
                    WebElement menu = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek']"));
                    menu.click();

                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[1]", "ЗАВТРАКИ");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[2]", "ХОЛОДНЫЕ ЗАКАЗЫ");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[3]", "САЛАТЫ");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[4]", "СУП");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[5]", "ВОСТОЧНАЯ КУХНЯ");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[6]", "КРЕМ СУП");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[7]", "ВОСТОЧНЫЙ СУП");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[8]", "ГОРЯЧИЕ ЗАКУСКИ");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[9]", "ВЫПЕЧКА");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[10]", "ПАСТА");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[11]", "СТЕЙК");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[12]", "ГОРЯЧИЕ БЛЮДА ЕВРОПЕЙСКОЙ КУХНИ");
                    printSection(driver, "//*[@id=\"WWMainPage\"]/div[13]", "БЛЮДА ИЗ РЫБЫ");
                });

        driver.quit();
    }

    private void printSection(WebDriver driver, String xpath, String sectionName) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        elements.forEach(element -> System.out.println(sectionName + "\n" + element.getText() + "\n---------------------------------------"));
    }
//    @Test
//    void findFoodList(){
//     System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//
//    WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//
//        driver.get("https://nambafood.kg/kukhnya-na-rayone?language=en");
//
//    List<WebElement> foodList = driver.findElements(By.xpath("//div[@class='card--item-info']/div[2]"));
//
//        for (WebElement food:foodList){
//        System.out.println(food.getText());
//    }
//        System.out.println(foodList.size());
//
//
//    List<WebElement> muesliAndFruitsList = driver.findElements(By.xpath(""));
//    List<WebElement> croissants = driver.findElements(By.xpath(""));
//}

    }
