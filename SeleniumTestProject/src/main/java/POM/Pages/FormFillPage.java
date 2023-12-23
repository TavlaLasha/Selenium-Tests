package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormFillPage {
    private final WebDriverWait wait;

    public FormFillPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getFirstName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
    }

    public WebElement getLastName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
    }

    public WebElement getGender() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Male')]")));
    }

    public WebElement getPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNumber")));
    }

    public WebElement getSubmitButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
    }
}
