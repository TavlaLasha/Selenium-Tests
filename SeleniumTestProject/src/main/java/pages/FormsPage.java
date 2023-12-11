package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {
    private static WebElement element = null;

    public static WebElement PracticeFormOptionBtn(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li"));
        return element;
    }
}
