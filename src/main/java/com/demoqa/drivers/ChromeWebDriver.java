package com.demoqa.drivers; // Это специальный package только для драйверов

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static com.demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {   // Это специальный класс Хромдрайвера.

    public static WebDriver loadChromeDriver(){ // статичный метод, который возвращает тип данных Вебдрайвер и который запускает и открывает браузер Хром, будет вызываться по названию класса.
        // Указываем путь к драйверу браузера Chrome
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //WebDriverManager.chromedriver().setup() или WebDriverManager.firefoxdriver.setup() и тд
        WebDriver driver = new ChromeDriver();
        // Инициализируем экземпляр веб-драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-Origins=*");//передаем какие то настройки когда будем запускать через удаленный сервер ->
        options.addArguments("--disable-extensions");// -> и даем разрешения
        options.addArguments("--window-size-1920,1080");
        options.addArguments("--no-sandbox"); //относится ci/cd
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        
        if (Boolean.parseBoolean(getValue("headless"))){ // обычный стринг запарсили в буллиан если TRUE (add.properties указываем) а если укажем в if(headless) браузер не будет открываться но тест начинает бегать
            options.addArguments("--headless"); // идея headless заключается в том что тесты будут запускаться без физического открытия браузера на нашем компе, и по времени будет намного быстрее
        }
       


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    // Мы один раз создали этот метод и теперь можем использовать его везде где это нам нужно

    // в будущем мы не будем использовать этот метод где нужно указывать весь путь: System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    // то есть установка драйверов с интернета для каждого браузера а потом инициализация System.setProperty, вместо этого мы будем
    // использовать WebDriverManager.chromedriver().setup() от (io.github.bonigarcia.wdm), он под капотом автоматически стянет себе нужные драйвера и будет запускать,
//автоматически будет подстраиваться под версию браузеров. Поэтому можно удалить папку drivers в папке resources и все драйвера которые находятся внутри.
}
