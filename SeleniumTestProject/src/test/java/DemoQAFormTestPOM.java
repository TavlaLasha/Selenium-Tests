import POM.Data.FormData;
import POM.Steps.FormClickSteps;
import POM.Steps.FormFillSteps;
import POM.Steps.FormModelValidationSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
@Epic("EPIC: Form")
@Feature("Feature: Fill & Validate Form")
public class DemoQAFormTestPOM {
    private FormClickSteps formClickSteps;
    private FormFillSteps formFillSteps;
    private FormModelValidationSteps formModelValidationSteps;
    private FormData formData;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        formClickSteps = new FormClickSteps(driver);
        formFillSteps = new FormFillSteps(driver);
        formModelValidationSteps = new FormModelValidationSteps(driver);
        formData = new FormData();
    }

    @AfterMethod
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }

    @Test(description = "Filling a demoqa form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Filling a demoqa form")
    @Story("Filling a form and then confirming if filled values are correct after submit")
    public void formTestTest() {
        formClickSteps.clickFormButton().clickPracticeFormButton();
        formFillSteps.setNameValue().setLastNameValue().clickGender().setPhoneNumber().submitForm();
        formModelValidationSteps.textValidation();

        Assert.assertEquals(formModelValidationSteps.checkIfTableElementByTextExists(formData.FirstName + ' ' + formData.LastName), true);
        Assert.assertEquals(formModelValidationSteps.checkIfTableElementByTextExists(formData.Gender), true);
        Assert.assertEquals(formModelValidationSteps.checkIfTableElementByTextExists(formData.PhoneNumber), true);
    }
}
