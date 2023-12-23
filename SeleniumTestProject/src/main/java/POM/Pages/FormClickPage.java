package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormClickPage {
    private WebDriverWait wait;

    public FormClickPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getFormButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Forms']")));
    }

    public WebElement getPracticeFormButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@id='item-0'])[2]")));
    }
}