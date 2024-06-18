package com.demoqa.drivers;

import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

// Этот класс будет управлять WebDriverами, какой класс будет работать какой не будет.
/*
Этот класс называется DriverManager, и он управляет объектом WebDriver, который используется для взаимодействия
 с браузером в тестах с Selenium. Класс использует паттерн Singleton для того, чтобы гарантировать, что существует
  только один экземпляр WebDriver в любое время.
 */
public class DriverManager {

    private static WebDriver driver; // инстанс drivera (непроинициализированный, то есть еще пока нет значения), мы должны
    // проинициализировать его исходя из значения в файле app.properties
    //Переменная static означает, что это поле будет общим для всех экземпляров класса DriverManager.


    // создаем специальный метод(получи какой то драйвер), возвращает тип данных WebDriver(интерфейс)
    public static WebDriver getDriver(){
        if (driver==null){ //Мы проверяем, был ли уже создан экземпляр driver. Если нет, мы создадим его.
            switch (ConfigReader.getValue("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }
        return driver;
    }


    //Этот метод закрывает браузер и освобождает ресурсы.
    public static void closeDriver(){
        try{
            if(driver != null){
                driver.close();
                driver.quit(); //Этот метод закрывает все окна браузера и завершает сессию WebDriver.
                driver=null; //Устанавливаем driver в null, чтобы в следующий раз, когда getDriver() будет вызван, он создал новый экземпляр.
            }
        }catch (Exception e){
            System.err.println("Error while closing driver");
            //e.printStackTrace();
        }
    }


}
