package POM.Steps;

import POM.Pages.BuyBasketItemsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BuyBasketItemsSteps {

    private WebDriver driver;
    private BuyBasketItemsPage buyBasketItemsPage;

    public BuyBasketItemsSteps(WebDriver driver) {
        this.driver = driver;
        this.buyBasketItemsPage = new BuyBasketItemsPage(driver);
    }

    @Step("Step: Click TBC card payment method")
    public BuyBasketItemsSteps clickTBCCardPaymentMethodRadio() {
        WebElement TBCCardPaymentMethodRadio = buyBasketItemsPage.getCardPaymentMethodButton();
        scrollToElement(TBCCardPaymentMethodRadio);
        TBCCardPaymentMethodRadio.click();
        return this;
    }

    @Step("Step: Click self pickup delivery method button")
    public BuyBasketItemsSteps clickSelfPickupDeliveryMethodButton() {
        WebElement SelfPickupDeliveryMethodButton = buyBasketItemsPage.getSelfPickupDeliveryMethodButton();
        scrollToElement(SelfPickupDeliveryMethodButton);
        SelfPickupDeliveryMethodButton.click();
        return this;
    }

    @Step("Step: Click self pickup delivery {0} branch button with")
    public BuyBasketItemsSteps clickSelfPickupBranchButton(String branchName) {
        WebElement SelfPickupBranchButton = buyBasketItemsPage.getSelfPickupBranchButton(branchName);
        scrollToElement(SelfPickupBranchButton);
        SelfPickupBranchButton.click();
        return this;
    }

    @Step("Step: Click checkout button")
    public BuyBasketItemsSteps clickCheckoutButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        try {
            WebElement CheckoutButton = buyBasketItemsPage.getCheckoutButton();
            scrollToElement(CheckoutButton);
            CheckoutButton.click();
        }
        catch (StaleElementReferenceException e){
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
            WebElement CheckoutButton = buyBasketItemsPage.getCheckoutButton();
            scrollToElement(CheckoutButton);
            CheckoutButton.click();
        }
        return this;
    }

    @Step("Step: Click checkout button")
    public BuyBasketItemsSteps waitForTBCCardSubmitButton() {
        WebElement CheckoutButton = buyBasketItemsPage.getTBCSubmitButton();
        return this;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
