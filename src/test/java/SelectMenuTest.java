
import com.demoqa.helper.DropdownHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuTest extends  BaseTest{

        @Test
        public void testGetAllSelectOptions() {
            driver.get("https://demoqa.com/select-menu");
            List<String> options = demoQAPages.getSelectMenuPage().getSelectOptions();
            for (String option : options) {
                System.out.println(option);
            }
        }

        @Test
        public void testGetAllDivSelectOptions() {
            driver.get("https://demoqa.com/select-menu");
            List<String> multiSelectDropDownOptions = demoQAPages.getSelectMenuPage().getMultiSelectDropDownOptions();
            List<String> selectOneOptions = demoQAPages.getSelectMenuPage().getSelectOneOptions();
            List<String> selectValueOptions = demoQAPages.getSelectMenuPage().getSelectValueOptions();
            List<String> standardMultiSelect = demoQAPages.getSelectMenuPage().getStandardMultiSelectDropDownOptions();


            System.out.println("Select One Options: " + selectOneOptions);
            System.out.println("Select Value Options: " + selectValueOptions);
            System.out.println("MultiSelect Drop Down Options: " + multiSelectDropDownOptions);
            System.out.println("Standard MultiSelect Drop Down Options: " + standardMultiSelect);
        }

    @Test
    void oldSelectMenuTest() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu  = driver.findElement(By.id("oldSelectMenu"));
        dropdownHelper.selectByVisibleText(selectMenu, "Green");
        Thread.sleep(5000);
    }

}
