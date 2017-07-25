package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/7/10.
 */
public class dashboardPage extends PageObject {
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/thead/tr/th[6]")
    WebElement HKLDAmount;
    @FindBy(xpath = ".//*[@id='create_tender']")
    WebElement CreateTenderBtn;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/div/div[1]")
    WebElement SelectTypeDropdown;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/div/ul/li[1]/span")
    WebElement SelectTypeDropdownItemITQ;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/div/ul/li[2]/span")
    WebElement SelectTypeDropdownItemTender;
    @FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/button[1]")
    WebElement SelectTypeCancelBtn;
    @FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/button[2]")
    WebElement SelectTypeEnterBtn;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[1]/span[2]")
    WebElement UserName;
    @FindBy(xpath = ".//*[@id='logo']/img")
    WebElement HKLDLogo;

    @FindBy(id = "hamburger")
    WebElement hamburgerIcon;
    @FindBy(id = "hamburger3")
    WebElement settingLink;

    public void clickSettingLink(){
        hamburgerIcon.click();
        settingLink.click();
    }
}
