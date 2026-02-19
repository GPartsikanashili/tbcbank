package tbcbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoanPage {
    public final Locator amountInput;
    public final Locator durationInput;
    public final Locator pirobebiBtn;
    public final Locator resultsContainer;

    public LoanPage(Page page) {
        this.pirobebiBtn = page.locator(".primary.size-l:has-text('პირობები')");
        this.amountInput = page.locator("#tbcx-text-input-1");
        this.durationInput = page.locator("#tbcx-text-input-2");
        this.resultsContainer = page.locator(".tbcx-pw-calculated-info");
    }
}