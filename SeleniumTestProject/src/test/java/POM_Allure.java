import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class POM_Allure {
    WebDriver driver;

    @BeforeTest
    @Severity(SeverityLevel.CRITICAL)
    public void BrowserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    @Severity(SeverityLevel.BLOCKER)
    @Step("Go to form page")
    @Description("Go to form page")
    private void GoToForm(){
        HomePage.FormsButton(driver).click();
        FormsPage.PracticeFormOptionBtn(driver).click();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Step("Fill practice form")
    @Description("Fill practice form")
    private void FillForm(){
        PracticeFormPage.TextBox_FirstName(driver).sendKeys("Lasha");
        PracticeFormPage.TextBox_LastName(driver).sendKeys("Tavlalashvili");
        PracticeFormPage.radio_gender(driver).click();
        PracticeFormPage.TextBox_Mobile(driver).sendKeys("1234567890");
        PracticeFormPage.Button_Submit(driver).click();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Step("Wait for success dialog and checks submitted data")
    @Description("Waits for success dialog and checks submitted data")
    private void CheckResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(PracticeFormPage.Dialog_Success_Text_Locator()));

    }
}
