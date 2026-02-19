package tbcbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OfferPage {
    public  final Locator extraOfferTitle;
    public  final Locator offerDiscount;
    public  final Locator offerBanner;
    public  final Locator offerDescritpion;

    public OfferPage(Page page) {
        this.extraOfferTitle = page.locator("h2.app-textpage-header__title");
        this.offerDiscount = page.locator(".tbcx-pw-text-badge");
        this.offerBanner = page.locator("picture img").nth(2);
        this.offerDescritpion =page.locator("//ng-component[@class='ng-star-inserted']/ngx-contentful-rich-text");

    }
}