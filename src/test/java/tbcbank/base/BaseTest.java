package tbcbank.base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected Properties properties;
    protected BrowserContext context;

    @BeforeMethod
    public void setup() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        properties.load(fis);

        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(java.util.List.of("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));

        page = context.newPage();



        try {
            page.navigate(properties.getProperty("url"), new Page.NavigateOptions()
                    .setWaitUntil(WaitUntilState.COMMIT)
                    .setTimeout(0));
        } catch (Exception e) {
        }
    }

}