package tbcbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MobilePage {
    public final Locator burgerMenu;
    public final Locator locationsIcon;
    public final Locator atmsTab;
    public final Locator checkAtmAddress;
    public final Locator branchesTab;
    public final Locator firstLocationCard;
    public final Locator cardAddress;
    public final Locator cardSchedule;

    public MobilePage(Page page) {
        this.burgerMenu = page.locator("tbcx-pw-hamburger-menu button");
        this.locationsIcon = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Locations")).first();
        this.atmsTab = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ATMs"));
        this.checkAtmAddress = page.locator("app-atm-branches-section-list-item")
                .filter(new Locator.FilterOptions().setHasText("atm-outlined #1 P. Saakadze"))
                .locator("tbcx-icon");
        this.branchesTab = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Branches"));
        this.firstLocationCard = page.locator(".locations-list-item, .branch-card").first();
        this.cardAddress = page.locator("app-atm-branches-section-list-item")
                .filter(new Locator.FilterOptions().setHasText("Chitaia str. #31"))
                .locator("tbcx-icon");
        this.cardSchedule = page.locator("app-atm-branches-section-list-item")
                .filter(new Locator.FilterOptions().setHasText("Chitaia str. #31"))
                .locator(".tbcx-pw-atm-branches-section__list-item-description");
    }
}
