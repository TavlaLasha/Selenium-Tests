package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private final WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getAmperageFilterParent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-modal-filters-section='battery-amperage']")));
    }
    public WebElement getBatteriesAmperageFilterCheckbox(String amperage) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-filter-value='"+amperage+"']")));
    }
    public WebElement getSubmitButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-auth-signin-btn")));
    }
}
