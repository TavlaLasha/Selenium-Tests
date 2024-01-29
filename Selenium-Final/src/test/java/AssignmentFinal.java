import POM.Steps.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    private PurchaseHistoryPageClickSteps purchaseHistoryPageClickSteps;
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
        purchaseHistoryPageClickSteps = new PurchaseHistoryPageClickSteps(driver);
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
    @Story("Going to batteries search page and selecting amperage filter of 60 amps. Then adding first found product to basket")
    private void SearchAndAddProductToBasket() {
        searchPageClickSteps.clickBatteriesButton().clickBatteriesSearchButton();
        searchSteps.clickBatteriesAmperageFilterCheckbox("60")
                .clickFirstProduct()
                .clickIncreaseQuantityButton()
                .clickAddToBasketButton();
    }

    @Test(priority = 2, description = "Buying basket products")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Buying products added to basket earlier")
    @Story("Buying products added to basket earlier by going to basket page, then checkout")
    private void BuyBasketItems() {
        buyBasketItemsClickSteps.clickBasketButton().clickGoToCheckoutButton();
        buyBasketItemsSteps.clickTBCCardPaymentMethodRadio()
                        .clickSelfPickupDeliveryMethodButton()
                        .clickSelfPickupBranchButton("სანაპიროს ფილიალი")
                        .clickCheckoutButton()
                        .waitForTBCCardSubmitButton();
    }

    @AfterTest
    public void finalSteps(){
        /*Go back to main page and then to order details page*/
        driver.get("https://sandbox.amboli.ge/");

        purchaseHistoryPageClickSteps.clickUserActionsWrapButton().clickUserPurchaseHistoryButton();

        ((JavascriptExecutor) driver).executeScript("alert('Good Bye!')");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();
    }
}