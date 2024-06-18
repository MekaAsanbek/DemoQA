import com.demoqa.pages.BasePage;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(description = "verify move to element methods is working")
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
        Thread.sleep(5000);

    }
}
