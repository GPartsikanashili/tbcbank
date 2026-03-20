package tbcbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class OfferPage {
    public  final Locator extraOfferTitle;
    public  final Locator offerDiscount;
    public  final Locator offerBanner;
    public  final Locator offerDescritpion;
    public final Locator ganatsilebaCheckBox;
    public final Locator mastercardPayCheckBox;
    public final Locator noOffersFound;
    public final Locator clearCardFilterButton;
    public final Locator offerList;

    public OfferPage(Page page) {
        this.extraOfferTitle = page.locator("h2.app-textpage-header__title");
        this.offerDiscount = page.locator(".tbcx-pw-text-badge");
        this.offerBanner = page.locator("picture img").nth(2);
        this.offerDescritpion =page.locator("//ng-component[@class='ng-star-inserted']/ngx-contentful-rich-text");
        this.ganatsilebaCheckBox = page.locator("app-marketing-filter-item")
                .filter(new Locator.FilterOptions().setHasText("განაწილება"))
                .getByRole(AriaRole.CHECKBOX);
        this.mastercardPayCheckBox= page.locator("app-marketing-filter-item").filter(new Locator.FilterOptions().setHasText("მასტერქარდი")).getByRole(AriaRole.CHECKBOX);
        this.noOffersFound = page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("შეთავაზებები არ მოიძებნა"));
        this.clearCardFilterButton = page.locator("app-marketing-filter-group")
                .filter(new Locator.FilterOptions().setHasText("ბარათის ტიპი გასუფთავება ვიზა მასტერქარდი"))
                .getByRole(AriaRole.BUTTON);
        this.offerList = page.locator("app-marketing-list div").first();

    }
}