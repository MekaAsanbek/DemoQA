

public class FluentWaitDemo {

//    FluentWait в Selenium используется для реализации ожидания с настраиваемыми временными интервалами, условиями и обработкой исключений. Он позволяет более гибко ждать выполнения условий по сравнению с традиционными ожиданиями (WebDriverWait), особенно полезен при работе с динамическими элементами на веб-странице.
//
//    Основные характеристики FluentWait:
//    Частота опроса (Polling Interval): Временной интервал, с которым FluentWait проверяет условие.
//    Таймаут (Timeout): Общее время ожидания.
//            Обработка исключений (Exception Handling): Исключения, которые могут быть проигнорированы при ожидании условия.
//    Пример использования FluentWait на Java
//    В этом примере мы ждем, пока элемент станет видимым, и обрабатываем исключение, если элемент не найден сразу:
//
//    Шаги:
//    Настраиваем FluentWait с максимальным таймаутом, интервалом опроса и типами исключений для игнорирования.
//    Используем wait.until() для ожидания условия.
    public static void main(String[] args) {
//        // Настройка пути к драйверу (ChromeDriver в данном случае)
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//
//        // Инициализация WebDriver
//        WebDriver driver = new ChromeDriver();
//
//        // Переход на целевую страницу
//        driver.get("http://example.com");
//
//        // Настройка FluentWait
//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))       // Общее время ожидания
//                .pollingEvery(Duration.ofSeconds(5))        // Интервал опроса
//                .ignoring(NoSuchElementException.class);    // Игнорирование исключений
//
//        // Ожидание видимости элемента
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                WebElement element = driver.findElement(By.id("dynamic-element-id"));
//                if (element.isDisplayed()) {
//                    return element;
//                } else {
//                    return null;
//                }
//            }
//        });
//
//        // Выполнение действия с найденным элементом
//        if (element != null) {
//            element.click();
//            System.out.println("Element clicked!");
//        } else {
//            System.out.println("Element not found within timeout period.");
//        }
//
//        // Закрытие браузера
//        driver.quit();
    }

}
