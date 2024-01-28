package POM.Steps;

import POM.Pages.SignInForm;
import POM.Pages.SearchClickPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPageClickSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private SignInForm signInForm;
    private SearchClickPage searchClickPage;

    public SearchPageClickSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.signInForm = new SignInForm(driver);
        this.searchClickPage = new SearchClickPage(driver);
    }

    @Step("Step: Wait for success message")
    public SearchPageClickSteps textValidation() {
        searchClickPage.getSuccessMessage();
        return this;
    }

    @Step("Step: Check if success table contains: {0} in any of the <td>-s")
    public boolean checkIfTableElementByTextExists(String text) {
        return searchClickPage.checkIfTableElementByTextExists(text);
    }
}
