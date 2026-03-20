package tbcbank.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;
import tbcbank.steps.HomePageSteps;
import tbcbank.steps.LoanPageSteps;
import java.util.regex.Pattern;
import com.microsoft.playwright.Page;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static tbcbank.data.Url.tbcBankUrl;

public class Scenario5 extends BaseTest {
    HomePageSteps homeSteps;
    LoanPageSteps loanSteps;

    @BeforeMethod
    public void BeforeMethod() {
        homeSteps = new HomePageSteps(page);
        loanSteps = new LoanPageSteps(page);
    }

    @Test
    public void LoanVerify() {
        page.navigate(tbcBankUrl);
        homeSteps.clicklangswitch()
                .clickFooterLoans();
        Page newTab = loanSteps.applyLoansClick();
        assertThat(newTab).hasURL(Pattern.compile(".*tbccredit\\.ge.*"));


    }
}