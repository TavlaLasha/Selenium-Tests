package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchClickPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchClickPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getBatteriesButton() {
        WebElement userWrap = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='advanced-search-wrap']")));
        return userWrap.findElement(By.xpath("//button[text()='აკუმულატორი']"));
    }

    public WebElement getBatteriesSearchButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-batteries-search-btn")));
    }
}
