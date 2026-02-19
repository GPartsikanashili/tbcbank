package tbcbank.steps;

import com.microsoft.playwright.Page;
import tbcbank.pages.OfferPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OfferPageSteps {
    Page page;
    OfferPage offerPage;
    public OfferPageSteps(Page page) {
        this.offerPage = new OfferPage(page);
        this.page = page;
    }
    public OfferPageSteps verifyOfferTitle() {
        assertThat(offerPage.extraOfferTitle).isVisible();
        return this;
    }
    public OfferPageSteps verifyOfferBanner() {
        assertThat(offerPage.offerBanner).isVisible();
        return this;
    }
    public OfferPageSteps verifyOfferDiscount(){
        assertThat(offerPage.offerDiscount).containsText("30%");
        return this;
    }
    public OfferPageSteps verifyOfferDescription(){
        assertThat(offerPage.offerDescritpion).isVisible();
        return this;
    }

    }




