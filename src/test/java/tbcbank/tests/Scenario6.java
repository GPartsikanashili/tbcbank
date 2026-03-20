package tbcbank.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Geolocation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;
import tbcbank.steps.MobileSteps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Scenario6 extends BaseTest {
    MobileSteps mobileSteps;

    @BeforeMethod
    @Override
    public void setup() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        properties.load(fis);

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(390, 844)
                .setDeviceScaleFactor(3.0)
                .setHasTouch(true)
                .setIsMobile(true)
                .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Mobile/15E148 Safari/604.1")
                .setGeolocation(new Geolocation(41.715111, 44.827111))
                .setPermissions(List.of("geolocation")));

        page = context.newPage();
        mobileSteps = new MobileSteps(page);
    }

    @Test
    public void testMobileAtmAndBranches() {
        page.navigate("https://www.tbcbank.ge/en");
        page.waitForLoadState();

        mobileSteps
                .clickBurgermenu();

        page.waitForTimeout(1000);

        mobileSteps
                .goToLocations()
                .verifyLocationsPage()
                .selectAtmsTab()
                .CheckAddressAtm()
                .selectBranchesTab()
                .verifyFirstBranchDetails();

    }
}