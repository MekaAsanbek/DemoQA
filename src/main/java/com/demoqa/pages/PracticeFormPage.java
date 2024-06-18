package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.PracticeFormEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PracticeFormPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//label[text()='Male']")
    public WebElement genderMaleBtn;

    @FindBy(xpath = "//label[normalize-space(text())='Female']")
    public WebElement genderFemaleBtn;

    @FindBy(xpath = "//label[text()='Other']")
    public WebElement genderOtherBtn;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberInput;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(id = "hobbies-checkbox-1")
    public WebElement hobbiesSportsBtn;

    @FindBy(id = "hobbies-checkbox-2")
    public WebElement hobbiesReadingBtn;

    @FindBy(xpath = "//label[text()='Music']")
    public WebElement hobbiesMusicBtn;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureBtn;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement selectStateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement selectCityInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity) {

        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .click(genderFemaleBtn)
                .sendKeys(mobileNumberInput, practiceFormEntity.getMobileNumber())
                .sendKeysWithEnter(dateOfBirthInput, practiceFormEntity.getDateOfBirth())
                .sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjects())
                .scrollToElement(hobbiesMusicBtn)
                .click(hobbiesMusicBtn)
                .sendKeys(uploadPictureBtn, practiceFormEntity.getUpLoadPicture())
                .sendKeysWithEnter(currentAddressInput, practiceFormEntity.getCurrentAddress())
                .sendKeysWithEnter(selectStateInput, practiceFormEntity.getState())
                .sendKeysWithEnter(selectCityInput, practiceFormEntity.getCity())
                .click(submitBtn);
        return this;

    }

    public PracticeFormPage selectDateMonthYear(String dateMonthYear){ // 04 Jun 2024

        String [] dateMonthYearParts = dateMonthYear.split(" ");
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementActions.click(datePickerBtn);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropdownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);
       //  //div[contains(@class, 'react-datepicker__day') and not (contains(@class, 'react-datepicker__day--outside-month')) and text()='4']
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'react-datepicker__day') and not (contains(@class, 'react-datepicker__day--outside-month')) and text()='" + date
                        + "']")));
        webElementActions.click(day);

        return this;
    }



}
