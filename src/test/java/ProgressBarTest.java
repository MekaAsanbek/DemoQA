import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest{

    @Test(description = "")
    public void progressBarTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/progress-bar");
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);

//        Thread.sleep(2000);
//        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);
//        Thread.sleep(6000);
//
//        System.out.println(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
//        Assert.assertEquals(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"), "52");

        String valueNow; // Создаем переменную для хранения текущего значения aria-valuenow
        while (true) { // Начало бесконечного цикла, пока не прервется с помощью break
            valueNow = demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"); // Извлечение текущего значения aria-valuenow
            if (valueNow.equals("52")) { // Проверка
              demoQAPages.getProgressBarPage().startStopButton.click(); // Остановка процесса в связи с выполнением условия выше
                break;
            }
        }

        Assert.assertEquals(valueNow, "52"); // Сравнение полученного значения с ожидаемым

    }


}
