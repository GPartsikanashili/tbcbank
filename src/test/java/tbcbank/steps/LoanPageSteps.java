package tbcbank.steps;

import com.microsoft.playwright.Page;
import tbcbank.pages.LoanPage;

public class LoanPageSteps {
    private final LoanPage loanPage;

    public LoanPageSteps(Page page) {
        this.loanPage = new LoanPage(page);
    }
    public LoanPageSteps clickpirobebi() {
        loanPage.pirobebiBtn.first().click();
        return this;
    }
    public LoanPageSteps setLoanAmount(String amount) {
        loanPage.amountInput.clear();
        loanPage.amountInput.fill(amount);
        return this;
    }
    public LoanPageSteps setLoanDuration(String duration) {
        loanPage.durationInput.clear();
        loanPage.durationInput.fill(duration);
        return this;
    }
    public com.microsoft.playwright.Locator getResults() {
        return loanPage.resultsContainer;
    }
}