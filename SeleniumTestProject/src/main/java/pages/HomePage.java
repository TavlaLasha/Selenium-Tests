package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static WebElement element = null;

    public static WebElement FormsButton(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]"));
        return element;
    }
}
