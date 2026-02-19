package tbcbank.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;

import tbcbank.steps.HomePageSteps;
import tbcbank.steps.LoanPageSteps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static tbcbank.data.Url.tbcBankUrl;

public class Scenario1 extends BaseTest {
    HomePageSteps homeSteps;
    LoanPageSteps loanSteps;

    @BeforeMethod
    public void BeforeMethod() {
        homeSteps = new HomePageSteps(page);
        loanSteps = new LoanPageSteps(page);
    }

    @Test
    public void LoanCalculator() {

        page.navigate(tbcBankUrl);
        homeSteps
                .hoverchemtvis()
                .clicksamomkhmareblo();
        loanSteps.clickpirobebi()
                .setLoanAmount("3000")
                .setLoanDuration("48");
        assertThat(loanSteps.getResults()).containsText("3,000");
        assertThat(loanSteps.getResults()).containsText("48 თვე");
    }
}