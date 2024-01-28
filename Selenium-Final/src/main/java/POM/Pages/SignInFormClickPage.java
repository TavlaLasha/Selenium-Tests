package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInFormClickPage {
    private WebDriverWait wait;

    public SignInFormClickPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getAuthButton() {
        WebElement userWrap = wait.until(ExpectedConditions.elementToBeClickable(By.className("js-app-header-user-wrap")));
        return userWrap.findElement(By.className("js-signin-modal-show-btn"));
    }
}