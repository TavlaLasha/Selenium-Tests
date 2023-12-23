package POM.Steps;

import POM.Pages.FormFillPage;
import POM.Pages.FormModelPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormModelValidationSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private FormFillPage formFillPage;
    private FormModelPage formModelPage;

    public FormModelValidationSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.formFillPage = new FormFillPage(driver);
        this.formModelPage = new FormModelPage(driver);
    }

    @Step("Step: Wait for success message")
    public FormModelValidationSteps textValidation() {
        formModelPage.getSuccessMessage();
        return this;
    }

    @Step("Step: Check if success table contains: {0} in any of the <td>-s")
    public boolean checkIfTableElementByTextExists(String text) {
        return formModelPage.checkIfTableElementByTextExists(text);
    }
}
