package POM.Steps;

import POM.Data.FormData;
import POM.Pages.FormFillPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class FormFillSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private FormData formData;
    private FormFillPage formFillPage;

    public FormFillSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.formData = new FormData();
        this.formFillPage = new FormFillPage(driver);
    }

    @Step("Step: Fill first name field with pre-defined data")
    public FormFillSteps setNameValue() {
        WebElement FirstName = formFillPage.getFirstName();
        scrollToElement(FirstName);
        FirstName.sendKeys(formData.FirstName);
        return this;
    }

    @Step("Step: Fill last name field with pre-defined data")
    public FormFillSteps setLastNameValue() {
        WebElement LastName = formFillPage.getLastName();
        scrollToElement(LastName);
        LastName.sendKeys(formData.LastName);
        return this;
    }

    @Step("Step: Select gender field with pre-defined data")
    public FormFillSteps clickGender() {
        formFillPage.getGender().click();
        return this;
    }

    @Step("Step: Fill phone number field with pre-defined data")
    public FormFillSteps setPhoneNumber() {
        WebElement PhoneNumber = formFillPage.getPhoneNumber();
        scrollToElement(PhoneNumber);
        PhoneNumber.sendKeys(formData.PhoneNumber);
        return this;
    }

    @Step("Step: Submit form")
    public FormFillSteps submitForm() {
        WebElement SubmitBtn = formFillPage.getSubmitButton();
        scrollToElement(SubmitBtn);
        SubmitBtn.click();
        return this;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
