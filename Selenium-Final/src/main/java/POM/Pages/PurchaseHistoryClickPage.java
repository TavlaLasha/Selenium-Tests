package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseHistoryClickPage {
    private WebDriverWait wait;

    public PurchaseHistoryClickPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getUserActionsWrapButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'js-app-header-user-wrap')]//button")));
    }

    public WebElement getUserPurchaseHistoryButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'js-app-user-nav')]//a[@href=\"https://sandbox.amboli.ge/account/orders/\"]")));
    }
}
