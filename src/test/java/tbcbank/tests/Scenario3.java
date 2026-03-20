
package tbcbank.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;
import tbcbank.steps.HomePageSteps;
import tbcbank.steps.OfferPageSteps;

import static tbcbank.data.ExtraUrl.extraOfferUrl;

public class Scenario3 extends BaseTest {
    HomePageSteps homeSteps;
    OfferPageSteps OfferSteps;

    @BeforeMethod
    public void BeforeMethod() {
        homeSteps = new HomePageSteps(page);
        OfferSteps = new OfferPageSteps(page);
    }

    @Test
    public void OfferCheck() {
        page.navigate(extraOfferUrl);
        OfferSteps
                .verifyOfferTitle()
                .verifyOfferBanner()
                .verifyOfferDiscount()
                .verifyOfferDescription();
    }
}