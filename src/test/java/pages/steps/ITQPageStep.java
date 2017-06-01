package pages.steps;
import common.steps.CommonWebDriver;
import constants.NodeIPConstants;
import constants.URLConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import xpath.ITQPageXpath;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Poppy_Zhang on 2017/5/27.
 */
public class ITQPageStep {
    public WebDriver driver;
    String testDataPath = System.getProperty("testdata");
    private DesiredCapabilities desiredCapabilities;

    @Given("^Open ETender system home page with ([^\"]*)$")
    public void open_ETender_system_home_page(String Browser) throws Throwable {
        desiredCapabilities=CommonStep.getBrowser(Browser);
        String url = NodeIPConstants.windows_local_ip + "/wd/hub";
        driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
        CommonWebDriver.get(driver, URLConstants.homePageUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        CommonWebDriver.wait(driver, 5);
    }

    @When("^Click create New ITQ button and input PR number with enter button$")
    public void click_create_New_ITQ_button() throws Throwable {
        CommonWebDriver.clickElementWhenPresent(driver, By.xpath(ITQPageXpath.create_ITQ_btn_xpath));
        CommonWebDriver.wait(driver, 2);
        CommonWebDriver.sendKeysWithEnterToElement(driver,By.xpath(ITQPageXpath.ITQ_number_lable_xpath),"poppytest1");
        CommonWebDriver.clickElementWhenPresent(driver, By.xpath(ITQPageXpath.PR_number_enter_btn_xpath));
        CommonWebDriver.wait(driver, 2);
    }

    @When("^Go to create ITQ page input general info and upload files and save$")
    public void gcreate_ITQ_and_save() throws Throwable {
        CommonWebDriver.navigateAndLoadPage(driver, URLConstants.createITQPage, 3);
        CommonWebDriver.wait(driver, 2);
        CommonWebDriver.sendKeysToElement(driver,By.xpath(ITQPageXpath.ITQ_description_xpath),"testdescription");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        CommonWebDriver.wait(driver, 2);
        action.sendKeys("testlocation");
        CommonWebDriver.wait(driver, 2);
        action.sendKeys(Keys.TAB).perform();
        CommonWebDriver.wait(driver, 2);
        action.sendKeys("testdate");
        CommonWebDriver.wait(driver, 2);
        action.sendKeys(Keys.TAB).perform();
        CommonWebDriver.wait(driver, 2);
        action.sendKeys("testDeadline");
        CommonWebDriver.wait(driver, 2);
        driver.findElement(org.openqa.selenium.By.xpath(ITQPageXpath.ITQ_upload_image_btn_xpath)).sendKeys(testDataPath);
        CommonWebDriver.wait(driver, 4);
        CommonWebDriver.clickElementWhenPresent(driver, By.xpath(ITQPageXpath.ITQ_save_btn_xpath));
    }

    @Then("^Check if create ITQ succeed$")
    public void check_if_create_ITQ_succeed() throws Throwable {

    }

    @Then("^Close browser$")
    public void close_browser() throws Throwable {
        driver.quit();
    }

    @When("^Open Biadu home page$")
    public void open_Biadu_home_page() throws Throwable {
//        String url = NodeIPConstants.windows_local_ip + "/wd/hub";
//        driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
//        CommonWebDriver.get(driver, URLConstants.homePageUrl);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1024,768));
    }
}
