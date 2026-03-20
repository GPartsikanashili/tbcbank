package tbcbank.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tbcbank.base.BaseTest;
import tbcbank.steps.HomePageSteps;
import tbcbank.steps.OfferPageSteps;

import static tbcbank.data.ExtraUrl.extraOfferUrl;
import static tbcbank.data.BlankOfferUrl.blankOfferUrl;

public class Scenario4 extends BaseTest {
    HomePageSteps homeSteps;
    OfferPageSteps OfferSteps;

    @BeforeMethod
    public void BeforeMethod() {
        homeSteps = new HomePageSteps(page);
        OfferSteps = new OfferPageSteps(page);
    }

    @Test
    public void BlankOfferCheck() {
        page.navigate(blankOfferUrl);
        OfferSteps
                .markGanatsileba()
                .markMasterCard();
        page.waitForTimeout(3000);
                OfferSteps.verifyNoOffersIsVisible()
                .clearCardFilter();
        page.waitForTimeout(3000);
              OfferSteps.verifyOfferList();
        page.waitForTimeout(2000);
          }
}

