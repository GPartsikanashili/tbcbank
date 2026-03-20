package tbcbank.steps;

import com.microsoft.playwright.Page;
import tbcbank.pages.MobilePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MobileSteps {
    private final Page page;
    private final MobilePage mobilePage;

    public MobileSteps(Page page) {
        this.page = page;
        this.mobilePage = new MobilePage(page);
    }
    public MobileSteps clickBurgermenu(){
        mobilePage.burgerMenu.click();
        return this;
    }

    public MobileSteps goToLocations() {
        mobilePage.locationsIcon.click();
        return this;
    }

    public MobileSteps verifyLocationsPage() {
        assertThat(page).hasURL(java.util.regex.Pattern.compile(".*branches.*"));
        return this;
    }
    public MobileSteps selectAtmsTab() {
        mobilePage.atmsTab.click();
        return this;
    }
public MobileSteps CheckAddressAtm(){
        mobilePage.checkAtmAddress.isVisible();
        return this;
}
    public MobileSteps selectBranchesTab() {
        mobilePage.branchesTab.click();
        return this;
    }

    public MobileSteps verifyFirstBranchDetails() {
        assertThat(mobilePage.cardAddress).isVisible();
        assertThat(mobilePage.cardSchedule).isVisible();
        return this;
    }
}