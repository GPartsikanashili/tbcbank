package tbcbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MoneyTransferPage {
    public final Locator remittanceFeeBtn;
    public final Locator transferAmountInput;
    public final Locator currencySelector;
    public final Locator eurOption;
    public final Locator countrySelector;
    public final Locator greeceOption;
    public final Locator commissionCards;

    public MoneyTransferPage(Page page) {
        this.remittanceFeeBtn = page.locator("button:has-text('Remittance Fee Calculation')");
        this.transferAmountInput = page.locator("//input[contains(@id,'tbcx-text-input')]");
        this.currencySelector = page.locator("//div[contains(text(), 'GEL')]");
        this.eurOption = page.locator("//div[contains(text(), 'EUR')]");
        this.countrySelector = page.locator("//div[contains(text(), 'Choose a country')]");
        this.greeceOption = page.locator("//div[contains(text(), 'Greece')]");
        this.commissionCards = page.locator("//span[contains(text(), 'Commission ')]");
    }
}