package pages;

import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/14.
 */
@DefaultUrl("http://epcnszxw0187.princeton.epam.com/#/")
public class navigationPage extends PageObject {
    CommonPage commonPage;

    @FindBy(xpath = ".//*[@id='hamburger']")
    WebElement hamburgerBtn;
    @FindBy(xpath = ".//*[@id='hamburger0']")
    WebElement ITQTenders;
    @FindBy(xpath = "html/body/div[1]/div[2]/h5")
    WebElement ITQTenderPageContent;

    public void clickHamburger() throws Exception {
        Thread.sleep(3000);
        hamburgerBtn.click();
        Thread.sleep(3000);
        ITQTenders.click();
        Thread.sleep(3000);
    }

    public void navigateITQTenders()throws Exception {
        commonPage.navigatePage(URLConstants.ITQTenderPage);
        Thread.sleep(3000);
        CommonPage.elementExist(ITQTenderPageContent);
        boolean textExist=ITQTenderPageContent.getText().contains("ITQ / Tender List Page");
        if(textExist==true){
            System.out.println("Navigate to ITQ/Tender list page succeed, test pass!");
        }
        else
            System.out.println("Navigate to ITQ/Tender list page get error, test fail!");
    }
}
