
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest{

@Test(description = "verify double click button is working properly")
    public void doubleClickTest(){
    browserHelper.open("https://demoqa.com/buttons");
    webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");

}

@Test(description = "verify right click button is working properly")
    public void rightClickTest(){
    browserHelper.open("https://demoqa.com/buttons");
    webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(), "You have done a right click");
}



}
