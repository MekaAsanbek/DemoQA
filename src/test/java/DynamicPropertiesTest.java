import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest{

    @Test(description = "proverka klika enabeAfter5Seconds")
    public void checkEnableAfterClickTest(){
        driver.get("https://demoqa.com/dynamic-properties");
        webElementActions.clickAfterFiveSeconds(demoQAPages.getDynamicPropertiesPage().enableAfterBtn);
    }

    @Test(description = "proverka klika colorChange")
    public void colorChangeClickTest(){
        driver.get("https://demoqa.com/dynamic-properties");
        webElementActions.clickColorChange(demoQAPages.getDynamicPropertiesPage().colorChangeBtn);
        String classValue = driver.findElement(By.id("colorChange")).getAttribute("class");
        Assert.assertEquals(classValue, "mt-4 text-danger btn btn-primary");
    }

    @Test(description = "proverka klika visibleAfter5Second")
    public void visibleAfterClickTest(){
        driver.get("https://demoqa.com/dynamic-properties");
        webElementActions.visibleAfterFiveSeconds(demoQAPages.getDynamicPropertiesPage().visibleAfterBtn);
    }


}
