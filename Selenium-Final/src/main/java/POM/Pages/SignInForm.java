package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInForm {
    private final WebDriverWait wait;

    public SignInForm(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-signin-user-phone")));
    }
    public WebElement getPassword() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-signin-user-password")));
    }
    public WebElement getSubmitButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-auth-signin-btn")));
    }
}
