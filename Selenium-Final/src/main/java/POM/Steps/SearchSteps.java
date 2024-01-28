package POM.Steps;

import POM.Pages.SearchPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSteps {

    private WebDriver driver;
    private SearchPage searchPage;

    public SearchSteps(WebDriver driver) {
        this.driver = driver;
        this.searchPage = new SearchPage(driver);
    }

    @Step("Step: Click batteries amperage filter checkbox with value of {0} amps")
    public SearchSteps clickBatteriesAmperageFilterCheckbox(String amperage) {
        WebElement BatteriesAmperageFilterCheckbox = searchPage.getBatteriesAmperageFilterCheckbox(amperage);
        scrollToElement(BatteriesAmperageFilterCheckbox);
        BatteriesAmperageFilterCheckbox.click();
        return this;
    }

    @Step("Step: Click first found product")
    public SearchSteps clickFirstProduct() {
        WebElement FirstProduct = searchPage.getFirstProductClickableElement();
        scrollToElement(FirstProduct);
        FirstProduct.click();
        return this;
    }

    @Step("Step: Click increase product basket quantity button")
    public SearchSteps clickIncreaseQuantityButton() {
        WebElement PlusButton = searchPage.getProductBasketQuantityPlusButton();
        scrollToElement(PlusButton);
        PlusButton.click();
        return this;
    }

    @Step("Step: Click add to basket button")
    public SearchSteps clickAddToBasketButton() {
        WebElement AddToBasketButton = searchPage.getAddToBasketButton();
        scrollToElement(AddToBasketButton);
        AddToBasketButton.click();
        return this;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
