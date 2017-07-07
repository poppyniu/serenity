package pages;

import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
//@DefaultUrl("http://10.22.17.96/")
public class itqPage extends PageObject {
    CommonPage commonPage;
    @FindBy(xpath = ".//*[@id='create_tender']")
    WebElement CreateITQTenderBtn;
    @FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/button[2]")
    WebElement CreateITQTenderEnterBtn;
    @FindBy(xpath = ".//*[@id='tender-general-workingDays-add']/div[1]/div[1]")
    WebElement dropDownOne;
    @FindBy(xpath = ".//*[@id='tender-general-workingDays-add']/div[1]/ul/li[4]/span/span")
    WebElement dropDownOneItem;
    @FindBy(xpath = ".//*[@id='tender-general-workingDays-add']/div[2]/div[1]")
    WebElement dropDownTwo;
    @FindBy(xpath = ".//*[@id='tender-general-workingDays-add']/div[2]/ul/li[6]/span")
    WebElement dropDownTwoItem;


    public void createITQ() throws Exception {
        Thread.sleep(3000);
        CreateITQTenderBtn.click();
        Thread.sleep(3000);
        CreateITQTenderEnterBtn.click();
        Thread.sleep(3000);
    }

    public void navigateCreateITQ()throws Exception {
        String currentUrl=getDriver().getCurrentUrl();
        Thread.sleep(2000);
        commonPage.navigatePage(currentUrl);
        Thread.sleep(3000);
    }

    public void selectDropdown()throws Exception {
        dropDownOne.click();
        Thread.sleep(1000);
        dropDownOneItem.click();
        Thread.sleep(1000);
        dropDownTwo.click();
        Thread.sleep(1000);
        dropDownTwoItem.click();
    }
}
