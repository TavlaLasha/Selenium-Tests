import POM.Steps.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssignmentFinal {
    private SignInFormClickSteps signInFormClickSteps;
    private SignInFormFillSteps signInFormFillSteps;
    private SearchPageClickSteps searchPageClickSteps;
    private SearchSteps searchSteps;
    private BuyBasketItemsClickSteps buyBasketItemsClickSteps;
    private BuyBasketItemsSteps buyBasketItemsSteps;
    WebDriver driver;

    @BeforeTest
    public void start() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sandbox.amboli.ge/");
        driver.manage().window().maximize();
        this.driver = driver;

        signInFormClickSteps = new SignInFormClickSteps(driver);
        signInFormFillSteps = new SignInFormFillSteps(driver);
        searchPageClickSteps = new SearchPageClickSteps(driver);
        searchSteps = new SearchSteps(driver);
        buyBasketItemsClickSteps = new BuyBasketItemsClickSteps(driver);
        buyBasketItemsSteps = new BuyBasketItemsSteps(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
    }

    @Test(priority = 0, description = "Signing in")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Signing in to an Amboli account")
    @Story("Opening auth form, filling phone and password fields and submitting")
    private void SignIn() {
        signInFormClickSteps.clickAuthButton();
        signInFormFillSteps.setPhoneNumber().setPasswordValue().submitForm();
    }

    @Test(priority = 1, description = "Searching a product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Searching a product and adding it into a basket")
    @Story("")
    private void SearchAndAddProductToBasket() {
        searchPageClickSteps.clickBatteriesButton().clickBatteriesSearchButton();
        searchSteps.clickBatteriesAmperageFilterCheckbox("60").clickFirstProduct().clickIncreaseQuantityButton().clickAddToBasketButton();
    }

    @Test(priority = 2, description = "Buying basket products")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Buying products added to basket earlier")
    @Story("")
    private void BuyBasketItems() {
        buyBasketItemsClickSteps.clickBasketButton().clickGoToCheckoutButton();
        buyBasketItemsSteps.clickTBCCardPaymentMethodRadio()
                        .clickSelfPickupDeliveryMethodButton()
                        .clickIncreaseQuantityButton("სანაპიროს ფილიალი")
                        .clickCheckoutButton()
                        .waitForTBCCardSubmitButton();
    }

    @AfterTest
    public void finalSteps(){
        /*Go back to main page and then to order details page*/
        driver.get("https://sandbox.amboli.ge/");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.className("js-app-header-user-wrap")));
        driver.findElement(By.className("js-app-header-user-wrap")).findElement(By.tagName("button")).click();
        driver.findElement(By.className("js-app-user-nav")).findElement(By.xpath("//a[@href=\"https://sandbox.amboli.ge/account/orders/\"]")).click();

        ((JavascriptExecutor) driver).executeScript("alert('Good Bye!')");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }
}