package POM.Steps;

import POM.Pages.SignInFormClickPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SignInFormClickSteps {
    private SignInFormClickPage formClickPage;

    public SignInFormClickSteps(WebDriver driver) {
        this.formClickPage = new SignInFormClickPage(driver);
    }

    @Step("Step: Click auth button in header")
    public SignInFormClickSteps clickAuthButton() {
        formClickPage.getAuthButton().click();
        return this;
    }
}
