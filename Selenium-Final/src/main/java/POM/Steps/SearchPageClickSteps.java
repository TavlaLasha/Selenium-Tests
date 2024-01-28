package POM.Steps;

import POM.Pages.SearchClickPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SearchPageClickSteps {
    private SearchClickPage searchClickPage;

    public SearchPageClickSteps(WebDriver driver) {
        this.searchClickPage = new SearchClickPage(driver);
    }

    @Step("Step: Click batteries filter button")
    public SearchPageClickSteps clickBatteriesButton() {
        searchClickPage.getBatteriesButton().click();
        return this;
    }

    @Step("Step: Click batteries search button")
    public SearchPageClickSteps clickBatteriesSearchButton() {
        searchClickPage.getBatteriesSearchButton().click();
        return this;
    }
}
