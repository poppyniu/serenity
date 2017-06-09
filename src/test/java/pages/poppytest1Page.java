package pages;

import constants.URLConstants;
import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/2.
 */
//@DefaultUrl("http://54.223.96.144:9001/#/")
@DefaultUrl("https://www.baidu.com/")
public class poppytest1Page extends PageObject {
    CommonPage commonPage;
    @FindBy(xpath = ".//*[@id='lg']/img")
    WebElement baiduLogo;
    @FindBy(xpath = ".//*[@id='u1']/a[1]")
    WebElement newsLink;
    @FindBy(xpath = ".//*[@id='header']/form/table/tbody/tr/td[1]/div[1]/a/img")
    WebElement newsLogo;

    public void elementExist() {
        boolean logoExist = baiduLogo.isDisplayed();
        if (logoExist == true) {
            Assert.assertTrue(true);
        }
    }

    public void clickElement() {
        newsLink.click();
    }

    public void navigatePage()
            throws Exception {
        {
            commonPage.navigatePage(URLConstants.newsPage);
            CommonPage.elementExist(newsLogo);
        }

    }
}
