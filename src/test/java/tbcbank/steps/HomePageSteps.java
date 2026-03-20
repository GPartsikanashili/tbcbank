package tbcbank.steps;

import com.microsoft.playwright.Page;
import tbcbank.pages.HomePage;

public class HomePageSteps {
    private final HomePage homePage;

    public HomePageSteps(Page page) {
        this.homePage = new HomePage(page);

    }
    public HomePageSteps hoverchemtvis() {
        homePage.chemtvisTab.first().hover();
        return this;
    }
    public HomePageSteps clicksamomkhmareblo() {
        homePage.samomkhmarebloBtn.click();
        return this;
    }
    public HomePageSteps clicklangswitch() {
        homePage.languageSwitcherBtn.first().click();
        return this;
    }
    public HomePageSteps hoverpersonal() {
        homePage.personalTab.first().hover();
        return this;
    }
    public HomePageSteps clickmoneytransfer() {
        homePage.moneyTransferBtn.click();
        return this;
    }
    public HomePageSteps clickFooterLoans(){
        homePage.footerLoans.click();
        return this;

    }

}