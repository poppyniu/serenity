package common.steps;

import constants.AppConstants;
import constants.GetUrlThread;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonWebDriver {
    private static final long defaultTimeout = AppConstants.longWait;
    private static Logger logger = LoggerFactory.getLogger(CommonWebDriver.class);
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Rewrite default get method to get specified URL, it will retry maximum 2 times if the URL is loaded failure
     *
     * @param driver
     * @param URL
     * @throws Exception
     */
    public static void get(WebDriver driver, String URL) throws Exception {
        long longWaiting = 10;  //seconds
        int index = 0, actionCount = 4;

        boolean openFailed = true;
        while (openFailed && index < actionCount) {
            openFailed = navigateAndLoadPage(driver, URL, longWaiting);
            index++;
        }
        if (openFailed) {
            throw new CommonException("Fail to navigate to the URL '" + URL + "' within " + longWaiting * actionCount + " seconds after retry " + actionCount + " times!. Please check manually.");
        }
    }

    /**
     * Navigate to a URL and wait for the page loading, if page is loading timeout then return false, otherwise return true
     *
     * @param driver
     * @param URL     The page will be opened
     * @param timeout Maximum wait time(seconds)
     * @return
     * @throws InterruptedException
     */
    public static boolean navigateAndLoadPage(WebDriver driver, String URL, long timeout) throws InterruptedException {
        boolean openFailed = true;
        int smallWaiting = 3;
        int waitTime = 0;

        GetUrlThread getUrlThread = new GetUrlThread(driver, URL);
        getUrlThread.start();
        while (openFailed == true && waitTime < timeout) {
            Thread.sleep(smallWaiting * 1000);
            waitTime += smallWaiting;
            openFailed = getUrlThread.getOpenFailed();
        }
        getUrlThread.interrupt();
        getUrlThread = null;

        return openFailed;
    }

    /**
     * @param driver
     * @param by
     * @param timeout
     * @return
     */
    private static WebElement WaitElementToBeLocated(WebDriver driver, By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement WaitElementToBePresent(WebDriver driver, By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * @param driver
     * @param by
     * @param timeout
     * @return
     */
    private static List<WebElement> WaitElementsToBeLocated(WebDriver driver, By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    /**
     * Wait for checking that there is at least one element present on a web page
     *
     * @param driver
     * @param by
     * @param timeout
     * @return
     */
    private static List<WebElement> WaitElementsToBeLocatedAtLeastOnePresent(WebDriver driver, By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     * @return
     */
    private static WebElement WaitElementToBeClickable(WebDriver driver, By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Wait time
     *
     * @param driver
     */
    public static void wait(WebDriver driver, long timeOutInSeconds) {
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return false;
                }
            });
        } catch (Exception e) {
        }
    }

    /**
     * Will return particular element by the given locator condition.
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     * @return The particular element.
     */
    public static WebElement getElement(WebDriver driver, By by, long timeout) {
        WebElement element;
        try {
            element = WaitElementToBeLocated(driver, by, timeout);
        } catch (Exception ex) {
            element = null;
        }

        return element;
    }

    public static WebElement getElementOfPresence(WebDriver driver, By by, long timeout) {
        WebElement element;
        try {
            element = WaitElementToBePresent(driver, by, timeout);
        } catch (Exception ex) {
            element = null;
        }

        return element;
    }

    /**
     * Will return particular element by the given locator condition.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @return The particular element.
     */
    public static WebElement getElement(WebDriver driver, By by) {
        return getElement(driver, by, defaultTimeout);
    }

    /**
     * Will return particular element's value by the given locator condition.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @return The particular element's value.
     */
    public static String getElementInputValue(WebDriver driver, By by) {
        String value;
        WebElement element = getElement(driver, by);
        if (element != null) {
            CommonUtil.moveToElement(driver, element);
            value = element.getAttribute("value");
        } else {
            value = null;
        }
        return value;
    }

    /**
     * Will return particular element by the given locator condition.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @return The particular element.
     */
    public static List<WebElement> getElements(WebDriver driver, By by) {
        return getElements(driver, by, defaultTimeout);
    }


    public static List<WebElement> getElementsToBeLocatedAtLeastOnePresent(WebDriver driver, By by) {
        return getElementsToBeLocatedAtLeastOnePresent(driver, by, defaultTimeout);
    }

    public static List<WebElement> getElementsToBeLocatedAtLeastOnePresent(WebDriver driver, By by, long timeout) {
        List<WebElement> elements;
        try {
            elements = WaitElementsToBeLocatedAtLeastOnePresent(driver, by, timeout);
        } catch (ElementNotFoundException ex) {
            elements = new ArrayList<WebElement>();
        } catch (TimeoutException exTime) {
            elements = new ArrayList<WebElement>();
        }
        return elements;
    }

    /**
     * Will return particular element by the given locator condition.
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     * @return
     */
    public static List<WebElement> getElements(WebDriver driver, By by, long timeout) {
        List<WebElement> elements;
        try {
            elements = WaitElementsToBeLocated(driver, by, timeout);
        } catch (ElementNotFoundException ex) {
            elements = new ArrayList<WebElement>();
        } catch (TimeoutException exTime) {
            elements = new ArrayList<WebElement>();
        }
        return elements;
    }

    /**
     * Click the particular element by the given locator condition.
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     * @throws Exception
     */
    public static void clickElementWhenPresent(WebDriver driver, By by, long timeout) throws Exception {
        try {
            WebElement element = WaitElementToBeClickable(driver, by, timeout);
            element.click();
        } catch (Exception ex) {
            throw new CommonException(packErrMsg(by.toString()), ex);
        }
    }

    /**
     * Click the particular element by the given locator condition.
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     * @param desc    Description of the element
     * @throws Exception
     */
    public static void clickElementWhenPresent(WebDriver driver, By by, long timeout, String desc) throws Exception {
        try {
            WebElement element = WaitElementToBeClickable(driver, by, timeout);
            element.click();
        } catch (Exception ex) {
            throw new CommonException(packErrMsg(desc), ex);
        }
    }

    /**
     * Click the particular element by the given locator condition.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @throws Exception
     */
    public static void clickElementWhenPresent(WebDriver driver, By by) throws Exception {
        clickElementWhenPresent(driver, by, defaultTimeout);
    }

    /**
     * Click the particular element by the given locator condition.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @param desc   Element description
     * @throws Exception
     */
    public static void clickElementWhenPresent(WebDriver driver, By by, String desc) throws Exception {
        clickElementWhenPresent(driver, by, defaultTimeout, desc);
    }

    /**
     * Check if the element is displayed and enabled.
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     * @return Whether or not the element is displayed and enabled before the timeout is up.
     */
    public static boolean isElementDisplayedAndEnabled(WebDriver driver, By by, long timeout) {
        WebElement element;
        boolean elementStatus;
        try {
            element = WaitElementToBeLocated(driver, by, timeout);
            elementStatus = element.isDisplayed() && element.isEnabled();
        } catch (Exception ex) {
            elementStatus = false;
        }
        return elementStatus;
    }

    /**
     * Check if the element is displayed and enabled.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @return Whether or not the element is displayed and enabled before the default timeout is up.
     */
    public static boolean isElementDisplayedAndEnabled(WebDriver driver, By by) {
        return isElementDisplayedAndEnabled(driver, by, defaultTimeout);
    }

    /**
     * Wait for element to be displayed and enabled.
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param timeout The time to wait in seconds.
     */
    public static void waitElementDisplayedAndEnabled(WebDriver driver, By by, long timeout) {
        isElementDisplayedAndEnabled(driver, by, timeout);
    }

    /**
     * Will send keys to an element and click Enter
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param keys    The keys to send
     * @param timeout The time to wait in seconds.
     * @param desc    Element description
     * @throws Exception
     */
    public static void sendKeysWithEnterToElement(WebDriver driver, By by, CharSequence keys, long timeout, String desc)
            throws Exception {
        WebElement element;
        try {
            element = WaitElementToBeLocated(driver, by, timeout);
            element.sendKeys(keys);
            element.sendKeys(Keys.ENTER);
        } catch (Exception ex) {
            throw new CommonException(packErrMsg(desc), ex);
        }
    }

    /**
     * Will send keys to an element and click Enter
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param keys    The keys to send
     * @param timeout The time to wait in seconds.
     * @throws Exception
     */
    public static void sendKeysWithEnterToElement(WebDriver driver, By by, CharSequence keys, long timeout)
            throws Exception {
        WebElement element;
        try {
            element = WaitElementToBeLocated(driver, by, timeout);
            element.sendKeys(keys);
            element.sendKeys(Keys.ENTER);
        } catch (Exception ex) {
            throw new CommonException(packErrMsg(by.toString()), ex);
        }
    }

    /**
     * Will send keys to an element
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param keys    The keys to send
     * @param timeout The time to wait in seconds.
     * @throws Exception
     */
    public static void sendKeysToElement(WebDriver driver, By by, CharSequence keys, long timeout)
            throws Exception {
        WebElement element;
        try {
            element = WaitElementToBeLocated(driver, by, timeout);
            element.sendKeys(keys);
        } catch (Exception ex) {
            throw new CommonException(packErrMsg(by.toString()), ex);
        }
    }

    /**
     * Will send keys to an element
     *
     * @param driver  WebDriver on a page, or WebElement on a page.
     * @param by      How to find the element.
     * @param keys    The keys to send
     * @param timeout The time to wait in seconds.
     * @param desc    The element description
     * @throws Exception
     */
    public static void sendKeysToElement(WebDriver driver, By by, CharSequence keys, long timeout, String desc)
            throws Exception {
        WebElement element;
        try {
            element = WaitElementToBeLocated(driver, by, timeout);
            element.sendKeys(keys);
        } catch (Exception ex) {
            throw new CommonException(packErrMsg(desc), ex);
        }
    }

    /**
     * Will send keys to an element
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @param keys   The keys to send
     * @throws Exception
     */
    public static void sendKeysToElement(WebDriver driver, By by, CharSequence keys)
            throws Exception {
        sendKeysToElement(driver, by, keys, defaultTimeout);
    }

    /**
     * Will send keys to an element
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @param keys   The keys to send
     * @param desc   The element description
     * @throws Exception
     */
    public static void sendKeysToElement(WebDriver driver, By by, CharSequence keys, String desc)
            throws Exception {
        sendKeysToElement(driver, by, keys, defaultTimeout, desc);
    }

    /**
     * Will send keys to an element and click Enter
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @param keys   The keys to send
     * @throws Exception
     */
    public static void sendKeysWithEnterToElement(WebDriver driver, By by, CharSequence keys)
            throws Exception {
        sendKeysWithEnterToElement(driver, by, keys, defaultTimeout);
    }

    /**
     * Will send keys to an element and click Enter
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @param keys   The keys to send
     * @param desc   The element description
     * @throws Exception
     */
    public static void sendKeysWithEnterToElement(WebDriver driver, By by, CharSequence keys, String desc)
            throws Exception {
        sendKeysWithEnterToElement(driver, by, keys, defaultTimeout, desc);
    }

    /**
     * Click the particular element by the given locator condition using Actions.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @throws Exception
     */
    public static void clickElement(WebDriver driver, By by) throws Exception {
        Actions actions = new Actions(driver);
        WebElement element = CommonWebDriver.getElement(driver, by);
        if (null != element) {
            actions.click(CommonWebDriver.getElement(driver, by)).build().perform();
        } else {
            throw new CommonException(packErrMsg(by.toString()));
        }
    }

    /**
     * Click the particular element by the given locator condition using Actions.
     *
     * @param driver WebDriver on a page, or WebElement on a page.
     * @param by     How to find the element.
     * @param desc   The element description
     * @throws Exception
     */
    public static void clickElement(WebDriver driver, By by, String desc) throws Exception {
        Actions actions = new Actions(driver);
        WebElement element = CommonWebDriver.getElement(driver, by);
        if (null != element) {
            actions.click(CommonWebDriver.getElement(driver, by)).build().perform();
        } else {
            throw new CommonException(packErrMsg(desc));
        }
    }

    /**
     * Switch to frame
     *
     * @param driver
     * @param frameBy
     * @throws Exception
     */
    public static void switchToFrame(WebDriver driver, By frameBy) throws Exception {
        WebElement frame = CommonWebDriver.getElement(driver, frameBy);
        if (frame != null) {
            driver.switchTo().frame(frame);
        } else {
            throw new CommonException("No frame element found " + frameBy.toString());
        }
    }

    public static void switchToFrame(WebDriver driver, WebElement frameElement) throws Exception {
        if (frameElement != null) {
            driver.switchTo().frame(frameElement);
        }
    }

    /**
     * Wrap up message
     *
     * @param desc
     * @return message
     */
    private static String packErrMsg(String desc) {
        String message = "";
        if (desc != null && desc != "") {
            message = "Unable to locate the element: " + desc;
        } else {
            message = "Unable to locate element";
        }
        return message;
    }

    /**
     * clear text box if it's not empty
     * add by poppy
     *
     * @param driver
     * @return
     */
    public static void clearTextbox(WebDriver driver, By by)
            throws Exception {
        WebElement element = driver.findElement(by);
        if (element != null) {
            element.clear();
        }
    }

    /**
     * check if element exists
     * add by poppy
     *
     * @param driver
     * @return
     */
    public static boolean isElementDisplayed(WebDriver driver, By by) {
        WebElement element;
        boolean elementStatus;
        try {
            element = driver.findElement(by);
            elementStatus = element.isDisplayed();
        } catch (Exception ex) {
            elementStatus = false;
        }

        return elementStatus;

    }

    //add by poppy
    public static boolean isContentAppeared(WebDriver driver, String content) {
        boolean status = false;
        try {
            driver.findElement(By.xpath("//*[contains(@src,'" + content + "')]"));
            System.out.println(content + " is appeard!");
            status = true;
        } catch (NoSuchElementException e) {
            System.out.println("'" + content + "' doesn't exist!");
        }
        return status;
    }

    //add by poppy
    public static boolean isMemberManagementMenuExist(WebDriver driver, String menuIcon) {
        boolean status = false;
        try {
            driver.findElement(By.xpath(".//*[@class='" + menuIcon + "']"));
            System.out.println("WeChat Member Management" + " is appeard!");
            status = true;
        } catch (NoSuchElementException e) {
            System.out.println(" WeChat Member Management Menu doesn't exist!");
        }
        return status;
    }
    /**
     * @author Young
     */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String screenShotName = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(), screenShotName);
    }

    /**
     * @author Poppy
     * @param drivername
     * @param screenShotName
     */
    public void takeScreenShot(TakesScreenshot drivername, String screenShotName) {
        // this method will take screen shot ,require two parameters ,one is
        // driver name, another is file name
        String currentPath = System.getProperty("user.dir"); // get current work
        File screenShotDir = new File(currentPath);
        if (!screenShotDir.exists()) {
            screenShotDir.mkdirs();
        }
        logger.info(currentPath);
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy
        try {
            logger.info("save snapshot path is:" + currentPath + "\\"+ screenShotName);
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + screenShotName));
        } catch (Exception e) {
            logger.error("Can't save screenshot");
            e.printStackTrace();
        } finally {
            logger.info("screen shot finished");
        }
    }

}
