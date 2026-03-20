package tbcbank.tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;
import tbcbank.pages.MoneyTransferPage;
import tbcbank.steps.HomePageSteps;
import tbcbank.steps.MoneyTransferPageSteps;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.assertions.LocatorAssertions;


import static tbcbank.data.Url.tbcBankUrl;


public class Scenario2 extends BaseTest {
    HomePageSteps homeSteps;
    MoneyTransferPageSteps transferSteps;
    MoneyTransferPage transferPage;

    @BeforeMethod
    public void BeforeMethod() {
        homeSteps = new HomePageSteps(page);
        transferSteps = new MoneyTransferPageSteps(page);
        transferPage = new MoneyTransferPage(page);
    }

    @Test
    public void CurryExchange() {
        page.navigate(tbcBankUrl);
        homeSteps.clicklangswitch()
                .hoverpersonal()
                .clickmoneytransfer();
        assertThat(page).hasURL("https://tbcbank.ge/en/other-products/money-transfers");
        transferSteps.TrasferFeeCalculator()
                .Filltransferamount("1000")
                .Selectcurr()
                .Selecteur()
                .Selectcountry()
                .SelectGreece();
        page.waitForTimeout(5000);
        assertThat(transferPage.commissionCards.first())
                .isVisible();

    }
}
