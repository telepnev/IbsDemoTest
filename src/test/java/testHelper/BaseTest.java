package testHelper;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static testHelper.AttachmentHelper.*;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        if (System.getProperty("remote.browser.url") != null)
            Configuration.remote = "https://user1:1234@" + System.getProperty("remote.browser.url") + ":4444/wd/hub/";
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("remote.browser.url") != null)
            attachVideo();

        WebDriverRunner.closeWebDriver();
    }
}
