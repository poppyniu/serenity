package pages.steps;

import common.steps.CommonWebDriver;
import constants.NodeIPConstants;
import constants.URLConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Poppy_Zhang on 2017/4/27.
 */
public class CommonStep {
    public WebDriver driver;

    public static DesiredCapabilities getBrowser(String browser) throws Throwable {
        DesiredCapabilities desiredCapabilities = null;
        if (browser.equals("firefox")) {
            desiredCapabilities = DesiredCapabilities.firefox();
        } else if (browser.equals("chrome")) {
            desiredCapabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
        else if (browser.equals("ie")) {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
            desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                    true);
        }
        return desiredCapabilities;
    }

}
