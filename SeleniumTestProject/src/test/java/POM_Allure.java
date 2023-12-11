import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import pages.*;

public class POM_Allure {
    WebDriver driver;

    @BeforeTest
    @Severity(SeverityLevel.CRITICAL)
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    @Severity(SeverityLevel.BLOCKER)
    private void GoToForm(){
        HomePage.FormsButton(driver).click();
        FormsPage.PracticeFormOptionBtn(driver).click();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Fill practice form")
    private void FillForm(){
        PracticeFormPage.TextBox_FirstName(driver).sendKeys("Lasha");
        PracticeFormPage.TextBox_LastName(driver).sendKeys("Tavlalashvili");
        PracticeFormPage.radio_gender(driver).click();
        PracticeFormPage.TextBox_Mobile(driver).sendKeys("1234567890");
        PracticeFormPage.Button_Submit(driver).click();
    }
}
