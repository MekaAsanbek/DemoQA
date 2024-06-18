package com.demoqa.pages;


import com.demoqa.helper.IframeHelper;
import lombok.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DemoQAPages {

    protected TextBoxPage textBoxPage;

    protected AlertPage alertPage;

    protected PracticeFormPage practiceFormPage;

    protected ButtonsPage buttonsPage;

    protected MenuPage menuPage;

    protected ProgressBarPage progressBarPage;

    protected SelectMenuPage selectMenuPage;

    protected DynamicPropertiesPage dynamicPropertiesPage;

    protected WebTablePage webTablePage;

    protected FramePage framePage;



    @BeforeClass(alwaysRun = true)
    public void setUp(){
        textBoxPage = new TextBoxPage();
        alertPage = new AlertPage();
        practiceFormPage = new PracticeFormPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        selectMenuPage = new SelectMenuPage();
        webTablePage = new WebTablePage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
        framePage = new FramePage();
    }
}
