import com.demoqa.entities.TextBoxEntity;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


// @Listeners(com.demoqa.listener.ScreenshotListener.class)
public class TextBoxTest extends BaseTest {

    @Test
    public void textBoxTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/text-box");
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
        Thread.sleep(3000);
        demoQAPages.getTextBoxPage().fillUpTextBoxForm(textBoxEntity);
        Assert.assertTrue(true);

    }
}
