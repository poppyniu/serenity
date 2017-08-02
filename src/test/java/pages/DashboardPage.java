package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/7/10.
 */
public class DashboardPage extends PageObject {
    CommonPage commonPage;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/thead/tr/th[6]")
    WebElement hkldAmount;
    @FindBy(xpath = ".//*[@id='create_tender']")
    WebElement createTenderBtn;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/div/div[1]")
    WebElement selectTypeDropdown;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/div/ul/li[1]/span")
    WebElement selectTypeDropdownItemITQ;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/div/ul/li[2]/span")
    WebElement selectTypeDropdownItemTender;
    @FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/button[1]")
    WebElement selectTypeCancelBtn;
    @FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/button[2]")
    WebElement selectTypeEnterBtn;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[1]/span[2]")
    WebElement userName;
    @FindBy(xpath = ".//*[@id='logo']/img")
    WebElement hkldLogo;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")
    WebElement itqTenderItemOne;
    @FindBy(id = "hamburger")
    WebElement hamburgerIcon;
    @FindBy(id = "hamburger3")
    WebElementFacade settingLink;

    public void selectCreateTenderDropdown(String item) throws Exception {
        commonPage.wait(getDriver(),2);
        createTenderBtn.click();
        commonPage.wait(getDriver(),2);
        selectTypeDropdown.click();
        commonPage.wait(getDriver(),1);
        selectTypeDropdown.click();
        commonPage.wait(getDriver(),2);
        if(item.contains("tender")) {
            selectTypeDropdownItemTender.click();
        }
        if(item.contains("itq")) {
            selectTypeDropdownItemITQ.click();
        }
        commonPage.wait(getDriver(),2);
        selectTypeEnterBtn.click();
        commonPage.wait(getDriver(),3);
        String currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3);
    }

    public void clickHamburgerIcon(){
        hamburgerIcon.click();
    }

    public void clickSettingLink(){
        settingLink.click();
    }

    public boolean settingLinkVisible(){
        return settingLink.isVisible();
    }

    public void clickHKLDLogo(){
        hkldLogo.click();
    }

}
