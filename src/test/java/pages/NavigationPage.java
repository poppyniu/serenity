package pages;

import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/14.
 */
@DefaultUrl("http://hkld-qa.princeton.epam.com/#/login")
public class NavigationPage extends PageObject {
    String currentUrl;
    CommonPage commonPage;
    @FindBy(xpath = ".//*[@id='hamburger']")
    WebElement hamburgerBtn;
    @FindBy(xpath = ".//*[@id='hamburger0']")
    WebElement itqTenders;
    @FindBy(xpath = "html/body/div[1]/div[2]/h5")
    WebElement itqTenderPageContent;

    public void clickHamburger() throws Exception {
        Thread.sleep(3000);
        hamburgerBtn.click();
        Thread.sleep(3000);
        itqTenders.click();
        Thread.sleep(3000);
    }

    public void navigateITQTenders()throws Exception {
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        Thread.sleep(3000);
        commonPage.elementExist(itqTenderPageContent);
        boolean textExist=itqTenderPageContent.getText().contains("ITQ / Tender List Page");
        if(textExist==true){
            System.out.println("Navigate to ITQ/Tender list page succeed, test pass!");
        }
        else
            System.out.println("Navigate to ITQ/Tender list page get error, test fail!");
    }
}
