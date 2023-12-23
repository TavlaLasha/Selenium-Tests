package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormModelPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FormModelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Thanks for submitting the form']")));
    }

    public boolean checkIfTableElementByTextExists(String text) {
        return !driver.findElements(By.xpath("//td[text()='"+text+"']")).isEmpty();
    }
}
