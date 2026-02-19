package tbcbank.steps;

import com.microsoft.playwright.Page;
import tbcbank.pages.MoneyTransferPage;

public class MoneyTransferPageSteps {
    private final MoneyTransferPage transferPage;
    Page page;
    public MoneyTransferPageSteps(Page page) {
        this.transferPage = new MoneyTransferPage(page);
        this.page = page;
    }
    public MoneyTransferPageSteps TrasferFeeCalculator() {
        transferPage.remittanceFeeBtn.click();
        return this;
    }
    public MoneyTransferPageSteps Filltransferamount(String amount) {
        transferPage.transferAmountInput.fill(amount);
        return this;
    }
    public MoneyTransferPageSteps Selectcountry() {
        transferPage.countrySelector.click();
        return this;
    }
    public MoneyTransferPageSteps SelectGreece() {
            transferPage.greeceOption.scrollIntoViewIfNeeded();
        transferPage.greeceOption.click();
        return this;
    }
    public MoneyTransferPageSteps Selectcurr() {
        transferPage.currencySelector.click();
        return this;
    }
    public MoneyTransferPageSteps Selecteur() {
        page.evaluate("window.scrollBy(0, 200)");
        transferPage.eurOption.click();
        return this;
    }
    }
