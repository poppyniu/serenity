package pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Poppy_Zhang on 2017/7/10.
 */
public class DashboardPage extends PageObject {
    CommonPage commonPage;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/thead/tr/th[6]")
    WebElement hkldAmount;
    @FindBy(xpath = ".//*[@id='create_tender']")
    WebElement createTenderBtn;
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

    /*
        If get to the dashboard twice in the same scenario, webElements from the pop out of create tender would not be unique.
        So selectCreateTenderDropdown() is updated to find the pop out first.
     */
    public void selectCreateTenderDropdown(String item) throws Exception {
        commonPage.wait(getDriver(),2);
        createTenderBtn.click();
        commonPage.wait(getDriver(),2);
        WebElement element = getDriver().findElements(By.cssSelector("div[style^='display: block;']")).get(1);
        WebElement inputField = element.findElement(By.xpath(".//*[@id='confirm-create-container']/div/div[2]/input"));
        WebElement selectTypeDropdownItem= element.findElement(By.xpath(".//*[@id='confirm-create-container']/div/ul/li[1]/span"));
        WebElement selectTypeEnterBtn1 = element.findElement(By.xpath( ".//*[@id='modal-dialog']/div[2]/button[2]"));

        if(item.contains("tender")) {
            commonPage.sendKeysOnElement(inputField, "Tender");
            selectTypeDropdownItem.click();
        }
        if(item.contains("itq")) {
            commonPage.sendKeysOnElement(inputField, "ITQ");
            selectTypeDropdownItem.click();
        }
        commonPage.wait(getDriver(),2);
        selectTypeEnterBtn1.click();
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
        commonPage.wait(getDriver(),2);
    }
}
