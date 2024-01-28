package POM.Steps;

import POM.Data.SignInFormData;
import POM.Pages.SignInForm;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInFormFillSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private SignInFormData formData;
    private SignInForm signInForm;

    public SignInFormFillSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.formData = new SignInFormData();
        this.signInForm = new SignInForm(driver);
    }

    @Step("Step: Fill sign in phone number field with pre-defined data")
    public SignInFormFillSteps setPhoneNumber() {
        WebElement PhoneNumber = signInForm.getPhoneNumber();
        scrollToElement(PhoneNumber);
        PhoneNumber.click();
        PhoneNumber.sendKeys(formData.PhoneNumber);
        return this;
    }

    @Step("Step: Fill sign in password field with pre-defined data")
    public SignInFormFillSteps setPasswordValue() {
        WebElement Password = signInForm.getPassword();
        scrollToElement(Password);
        Password.sendKeys(formData.Password);
        return this;
    }

    @Step("Step: Submit sign in form")
    public SignInFormFillSteps submitForm() {
        WebElement SubmitBtn = signInForm.getSubmitButton();
        scrollToElement(SubmitBtn);
        SubmitBtn.click();
        return this;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
