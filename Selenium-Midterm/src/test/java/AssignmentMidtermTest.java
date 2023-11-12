import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssignmentMidtermTest {
    WebDriver driver;

    @BeforeTest
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amboli.ge/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
    }

    @Test(priority = 0)
    private void SignIn() {
        WebElement signInButton = driver.findElement(By.className("js-app-header-user-wrap")).findElement(By.className("js-signin-modal-show-btn"));
        signInButton.click();

        WebElement PhoneInput = driver.findElement(By.className("js-signin-user-phone"));
        WebElement PasswordInput = driver.findElement(By.className("js-signin-user-password"));
        PhoneInput.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        PhoneInput.sendKeys("122353677");
        PasswordInput.sendKeys("1234");
        driver.findElement(By.className("js-auth-signin-btn")).click();
    }

    @Test(priority = 1)
    private void SearchAndAddProductToBasket() {
        WebElement ParentElement = driver.findElement(By.xpath("//div[@class='advanced-search-wrap']"));
        ParentElement.findElement(By.xpath("//button[text()='აკუმულატორი']")).click();

        WebElement VirtualSelect = driver.findElement(By.className("js-batteries-filter"));
        VirtualSelect.click();
//        WebElement parent_div = VirtualSelect.findElement(By.xpath("//*[contains(@class, 'js-batteries-filter')]/div/div[2]/div/div[2]/div[2]/div/div[@data-value='60']"));
//        parent_div.click();

        driver.findElement(By.className("js-batteries-search-btn")).click();
        /*Select Battery search filter*/
        WebElement AmperageFilterParent =  driver.findElement(By.xpath("//div[@data-modal-filters-section='battery-amperage']"));
        AmperageFilterParent.findElement(By.xpath("//input[@data-filter-value='60']")).click();

        /*Go To Product page*/
        driver.findElement(By.className("products-grid")).findElement(By.tagName("a")).findElement(By.tagName("img")).click();

        /*Add Product to basket*/
        driver.findElement(By.className("js-product-counter-plus-btn")).click();
        driver.findElement(By.className("js-product-add-to-basket-button")).click();
    }

    @Test(priority = 2)
    private void BuyBasketItems() {
        /*Go To Basket page and click checkout*/
        driver.findElement(By.className("basket-btn")).click();
        driver.findElement(By.className("checkout-submit-btn")).click();
        /*Choose payment method*/
        driver.findElement(By.xpath("//input[(@class=\"js-payment-method-radio\") and (@value=\"Card\")]")).click();

        Actions ElementToScrollTo = new Actions(driver).scrollToElement(driver.findElement(By.className("js-basket-item")));
        ElementToScrollTo.perform();
        /*Choose delivery method*/
        driver.findElement(By.xpath("//input[(@class=\"js-delivery-method-radio\") and (@value=\"Branch\")]")).click();

        /*Choose self pick up branch*/
        driver.findElement(By.xpath("//b[text() = 'სანაპიროს ფილიალი']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
        ElementToScrollTo.perform();
        /*Click checkout button*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("js-checkout-btn")));
        driver.findElement(By.className("js-checkout-btn")).click();
        WebDriverWait TBCwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TBCwait.until(ExpectedConditions.elementToBeClickable(By.id("payment-submit")));
    }

    @AfterTest
    public void finalSteps(){
        /*Go back to main page and then to order details page*/
        driver.get("https://amboli.ge/");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.className("js-app-header-user-wrap")));
        driver.findElement(By.className("js-app-header-user-wrap")).findElement(By.tagName("button")).click();
        driver.findElement(By.className("js-app-user-nav")).findElement(By.xpath("//a[@href=\"https://amboli.ge/account/orders/\"]")).click();

        ((JavascriptExecutor) driver).executeScript("alert('Good Bye!')");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }
}