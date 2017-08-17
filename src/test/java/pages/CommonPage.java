package pages;

import constants.CommonException;
import constants.URLConstants;
import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public boolean elementExist(WebElement element)
            throws Exception{
        boolean elementExist= element.isDisplayed();
        if(elementExist==true)
        {
            Assert.assertTrue(true);
            return elementExist;
        }
        return elementExist;
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

    public void selectWorkingHoursDrodownByItemAndNumber(Integer Number,String item)
            throws Exception {
        getDriver().findElement(By.xpath(".//*[@id='tender.general.workingHours']/div[@class='working-hours']/div[2]/div["+Number+"]/ul/li/span/span[contains(text(),'"+item+"')]")).click();
    }

    public void selectWorkingHoursDrodownByItem(String item)
            throws Exception {
        getDriver().findElement(By.xpath("//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[1]/ul/li/span/span[contains(text(),'"+item+"')]")).click();
    }

    public void selectWorkingHoursDrodown2ByItem(String item)
            throws Exception {
        getDriver().findElement(By.xpath("//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[2]/ul/li/span/span[contains(text(),'"+item+"')]")).click();
    }

    public  void sendKeysOnElement(WebElement element, String sendValue) {
        element.click();
        String insertedValue = element.getAttribute("value");
        while ( !insertedValue.equals(sendValue) ) {
            element.click();
            element.clear();
            for(int i=0; i<sendValue.length(); i++){
                element.sendKeys(sendValue.substring(i,i+1));
            }
            insertedValue = element.getAttribute("value");
        }
    }

    public void scrollToElement(final WebElement element) {
        final int yCoordinate = element.getLocation().getY();
        final String script = String.format("window.scrollTo(0,%s);", yCoordinate - 350);
        getJavascriptExecutorFacade().executeScript(script, element);
    }

    public static String getSpecifiedDayBefore(String specifiedDay){
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);

        String dayBefore=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
        return dayBefore;
    }

    public static boolean isContentAppeared(WebDriver driver, String content) {
        boolean status = false;
        try {
            driver.findElement(By.xpath("//*[contains(a,'" + content + "')]"));
            System.out.println(content + " is appeard!");
            status = true;
        } catch (NoSuchElementException e) {
            System.out.println("'" + content + "' doesn't exist!");
        }
        return status;
    }

}
