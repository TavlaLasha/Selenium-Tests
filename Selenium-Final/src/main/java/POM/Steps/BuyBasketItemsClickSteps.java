package POM.Steps;

import POM.Pages.BuyBasketItemsClickPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BuyBasketItemsClickSteps {
    private BuyBasketItemsClickPage buyBasketItemsClickPage;

    public BuyBasketItemsClickSteps(WebDriver driver) {
        this.buyBasketItemsClickPage = new BuyBasketItemsClickPage(driver);
    }

    @Step("Step: Click basket button")
    public BuyBasketItemsClickSteps clickBasketButton() {
        buyBasketItemsClickPage.getBasketButton().click();
        return this;
    }

    @Step("Step: Click go to checkout button")
    public BuyBasketItemsClickSteps clickGoToCheckoutButton() {
        buyBasketItemsClickPage.getGoToCheckoutButton().click();
        return this;
    }
}
