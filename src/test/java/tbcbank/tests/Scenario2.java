package tbcbank.tests;

import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;
import tbcbank.steps.HomePageSteps;
import tbcbank.steps.MoneyTransferPageSteps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static tbcbank.data.Url.tbcBankUrl;


public class Scenario2 extends BaseTest {
    HomePageSteps homeSteps;
    MoneyTransferPageSteps transferSteps;

    @BeforeMethod
    public void BeforeMethod() {
        homeSteps = new HomePageSteps(page);
        transferSteps = new MoneyTransferPageSteps(page);
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
        page.waitForSelector("//span[contains(text(), 'Commission ')]",
                new Page.WaitForSelectorOptions().setTimeout(6000));
        assertThat(page.locator("//span[contains(text(), 'Commission ')]").first()).isVisible();

    }
}
