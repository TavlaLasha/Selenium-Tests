package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyBasketItemsClickPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BuyBasketItemsClickPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getBasketButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.className("basket-btn")));
    }

    public WebElement getGoToCheckoutButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout-submit-btn")));
    }
}
