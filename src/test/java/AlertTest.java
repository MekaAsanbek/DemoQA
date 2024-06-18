

import org.testng.annotations.Test;

public class AlertTest extends BaseTest{


    // можно дополнять всякими такими аннотациями тестовые методы, чтобы группировать их по каким то общим признакам и запускать вместе их
    @Test(groups = {"Smoke", "UI", "1011"}, description = "Alert test")
//    @Description("Verify that alert is present")
//    @Owner("Meerim")
//    @Tag("Smoke")
//    @Severity(SeverityLevel.CRITICAL)
//    @Story("GCPINT-8877")
//    @Epic("Registration")
//    @Link("www.google.com")
    void alertTest() throws InterruptedException {
        // Открываем веб-страницу
//        browserHelper.open(ConfigReader.getValue("baseDevURL") + Endpoints.ALERT.getEndpoint()); // это основная точка входа на сайт,
//        и если вдруг нам придется менять среду тестирования и у нас есть 10 тысяч тесткейсов, нам не придется переписывать юрл в каждом из них,
//        а просто в app.properties указывать dev или qa или stage
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000); // так писать плохая практика
        alertHelper.acceptAlert();
       webElementActions.pause(5000); // нужно писать вот так, то есть у нас есть общий метод в хелперах и его используем.
    }


    @Test(groups = {"Regression", "API", "1012"}, dependsOnMethods = "alertTest")
    void alertTest1() throws InterruptedException {
        // Представим что это уже другой тест
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000); // так писать плохая практика
        alertHelper.acceptAlert();
        webElementActions.pause(5000); // нужно писать вот так, то есть у нас есть общий метод в хелперах и его используем.
    }

    @Test(groups = {"E2E", "SQL", "1013"})
    void alertTest2() throws InterruptedException {
        // Представим что это уже другой тест
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000); // так писать плохая практика
        alertHelper.acceptAlert();
        webElementActions.pause(5000); // нужно писать вот так, то есть у нас есть общий метод в хелперах и его используем.
    }




}
