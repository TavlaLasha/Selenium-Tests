package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage {
    private static WebElement element = null;

    public static WebElement TextBox_FirstName(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        return element;
    }

    public static WebElement TextBox_LastName(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        return element;
    }

    public static WebElement radio_gender(WebDriver driver){
        element = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        return element;
    }

    public static WebElement TextBox_Mobile(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id=\"userNumber\"]"));
        return element;
    }

    public static WebElement Button_Submit(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
        return element;
    }

    public static By Dialog_Success_Text_Locator(){
        return By.xpath("//div[(@id=\"example-modal-sizes-title-lg\") and (text()=\"Thanks for submitting the form\")]");
    }
}
