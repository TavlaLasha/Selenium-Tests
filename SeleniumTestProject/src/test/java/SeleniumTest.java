import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amboli.ge/");
        driver.manage().window().maximize();

        SignIn(driver);
        sleep(1000);
        SearchAndAddProductToBasket(driver);
        sleep(2000);
        BuyBasketItems(driver);

        driver.navigate().back();
        driver.findElement(By.className("js-app-header-user-wrap")).findElement(By.tagName("button")).click();
        driver.findElement(By.className("js-app-user-nav")).findElement(By.xpath("//a[@href=\"https://amboli.ge/account/orders/\"]")).click();

        ((JavascriptExecutor) driver).executeScript("alert('Good Bye!')");
        sleep(2000);
        driver.quit();
    }

    private static void SignIn(WebDriver driver) throws InterruptedException {
        WebElement signInButton = driver.findElement(By.className("js-app-header-user-wrap")).findElement(By.className("js-signin-modal-show-btn"));
        signInButton.click();

        WebElement PhoneInput = driver.findElement(By.className("js-signin-user-phone"));
        WebElement PasswordInput = driver.findElement(By.className("js-signin-user-password"));
        PhoneInput.click();
        sleep(100);
        PhoneInput.sendKeys("122353677");
        PasswordInput.sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button")).click();
    }

    private static void SearchAndAddProductToBasket(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div/div[2]/button")).click();

        WebElement SearchBoxParent =  driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div/div[2]/div"));

        WebElement VirtualSelect = SearchBoxParent.findElement(By.className("js-batteries-filter"));
        VirtualSelect.click();
//        sleep(500);
//        WebElement parent_div = driver.findElement(By.xpath("//div[@class='vscomp-options-container']"));
//        WebElement child_div = parent_div.findElement(By.xpath(".//div[contains(@data-value, '100')]"));
//        child_div.click();

        SearchBoxParent.findElement(By.className("js-batteries-search-btn")).click();
        WebElement AmperageFilterParent =  driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div/div[1]/div/div[2]/div[4]"));
        AmperageFilterParent.findElement(By.xpath("//input[@data-filter-value=\"60\"]")).click();
        driver.findElement(By.className("products-grid")).findElement(By.tagName("a")).findElement(By.tagName("img")).click();

        driver.findElement(By.className("js-product-counter-plus-btn")).click();
        driver.findElement(By.className("js-product-add-to-basket-button")).click();
    }

    private static void BuyBasketItems(WebDriver driver) throws InterruptedException {
        driver.findElement(By.className("basket-btn")).click();
        driver.findElement(By.className("checkout-submit-btn")).click();
        driver.findElement(By.xpath("//input[(@class=\"js-payment-method-radio\") and (@value=\"Card\")]")).click();

        new Actions(driver).scrollToElement(driver.findElement(By.className("js-basket-item"))).perform();
        driver.findElement(By.xpath("//input[(@class=\"js-delivery-method-radio\") and (@value=\"Branch\")]")).click();
        sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div")).click();

        new Actions(driver).scrollToElement(driver.findElement(By.className("js-basket-item"))).perform();

        driver.findElement(By.className("js-checkout-btn")).click();
    }
}