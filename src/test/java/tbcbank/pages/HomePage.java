package tbcbank.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    public final Locator chemtvisTab;
    public final Locator samomkhmarebloBtn;
    public final Locator languageSwitcherBtn;
    public final Locator personalTab;
    public final Locator moneyTransferBtn;
    public final Locator footerLoans;

    public HomePage(Page page) {
        this.chemtvisTab = page.locator("a:has-text('ჩემთვის')");
        this.samomkhmarebloBtn = page.locator("button:has-text('სამომხმარებლო')");
        this.languageSwitcherBtn = page.locator("(//div[contains(text(),' ქარ ')])[1]");
        this.personalTab = page.locator("a:has-text('Personal')");
        this.moneyTransferBtn = page.locator("button:has-text('Money Transfers')");
        this.footerLoans = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Loans"));
    }
}