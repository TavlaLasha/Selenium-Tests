package POM.Steps;

import POM.Pages.FormClickPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class FormClickSteps {
    private FormClickPage formClickPage;

    public FormClickSteps(WebDriver driver) {
        this.formClickPage = new FormClickPage(driver);
    }

    @Step("Step: Click form button on homepage")
    public FormClickSteps clickFormButton() {
        formClickPage.getFormButton().click();
        return this;
    }

    @Step("Step: Click practice form in nav")
    public FormClickSteps clickPracticeFormButton() {
        formClickPage.getPracticeFormButton().click();
        return this;
    }
}
