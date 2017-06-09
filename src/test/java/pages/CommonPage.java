package pages;

import constants.CommonException;
import constants.URLConstants;
import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Poppy_Zhang on 2017/6/8.
 */
public class CommonPage extends PageObject{
    public static long longWait;
    private static final long defaultTimeout = longWait;

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

    public static void elementExist(WebElement element)
            throws Exception{
        boolean elementExist= element.isDisplayed();
        if(elementExist==true)
        {
            Assert.assertTrue(true);
        }
    }


    public void navigatePage(String url)
            throws Exception{
        getDriver().navigate().to(url);
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
     * @param driver
     * @param by
     * @param timeout
     * @return
     */
    private static WebElement WaitElementToBeLocated(WebDriver driver, By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
}
