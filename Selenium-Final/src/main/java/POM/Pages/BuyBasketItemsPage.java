package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyBasketItemsPage {
    private final WebDriverWait wait;

    public BuyBasketItemsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement getCardPaymentMethodButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(@class, 'js-payment-method-label') and (@data-provider=\"TBC\")]//input[(@class=\"js-payment-method-radio\") and (@value=\"Card\")]")));
    }

    public WebElement getSelfPickupDeliveryMethodButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[(@class=\"js-delivery-method-radio\") and (@value=\"Branch\")]")));
    }

    public WebElement getSelfPickupBranchButton(String branchName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text() = '"+branchName+"']")));
    }

    public WebElement getCheckoutButton() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'js-checkout-btn')]")));
        }
        catch (StaleElementReferenceException e){
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'js-checkout-btn')]")));
        }
    }

    public WebElement getTBCSubmitButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-submit")));
    }
}
