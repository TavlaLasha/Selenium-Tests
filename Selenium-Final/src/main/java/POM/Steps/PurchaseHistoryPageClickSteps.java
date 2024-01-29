package POM.Steps;

import POM.Pages.PurchaseHistoryClickPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PurchaseHistoryPageClickSteps {
    private PurchaseHistoryClickPage purchaseHistoryClickPage;

    public PurchaseHistoryPageClickSteps(WebDriver driver) {
        this.purchaseHistoryClickPage = new PurchaseHistoryClickPage(driver);
    }

    @Step("Step: Click user actions dropdown button in header")
    public PurchaseHistoryPageClickSteps clickUserActionsWrapButton() {
        purchaseHistoryClickPage.getUserActionsWrapButton().click();
        return this;
    }

    @Step("Step: Click purchase history button in user actions dropdown")
    public PurchaseHistoryPageClickSteps clickUserPurchaseHistoryButton() {
        purchaseHistoryClickPage.getUserPurchaseHistoryButton().click();
        return this;
    }
}
