package pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class SettingsPage extends PageObject {
    CommonPage commonPage;

    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/div[1]")
    WebElement settingsDropDown;

    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/ul/li[1]/span")
    WebElement userOption;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/ul/li[2]/span/span")
    WebElement locationOPtion;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/ul/li[3]/span")
    WebElement securityGroupOption;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/ul/li[4]/span")
    WebElement thresholdOption;

    @FindBy(id = "add_location_a")
    WebElement locationAddBtn;
    @FindBy(id = "add-location-code")
    WebElement locationShortFormField;
    @FindBy(id = "add-location-desc")
    WebElement locationDecriptionField;
    @FindBy(id = "add-location-company")
    WebElement locationCompanyField;
    @FindBy(xpath = ".//*[@id='addLocationModal']/div[2]/button[2]")
    WebElement addLocationYesBtn;

    @FindBy(id = "settings-engineers-add-group")
    WebElement securityGroupAddBtn;
    @FindBy(id = "settings-engineers-add-group-name-value")
    WebElement groupNameField;
    @FindBy(id = "settings-engineers-add-group-description-value")
    WebElement groupDescriptionField;
    @FindBy(xpath = ".//*[@id='groupSettingAddModal']/div[2]/button[2]")
    WebElement addGroupYesBtn;

    @FindBy(id = "settings-engineers-hkl-user-detail-btn-edit")
    WebElement userDetailsEditBtn;
    @FindBy(id = "settings-engineers-hkl-user-detail-btn-save")
    WebElement userDetailsSaveBtn;

    public void clickSettingDropDown(){
        settingsDropDown.click();
    }

    public void selectUserOption(){
        userOption.click();
    }

    public void selectLocationOption(){
        locationOPtion.click();
    }

    public void selectSecurityGroupOption(){
        securityGroupOption.click();
    }

    public void selectThresholdOption(){
        thresholdOption.click();
    }

    public void clickLocationAddBtn(){
        locationAddBtn.click();
    }

    public void clickSecurityGroupAddBtn() {securityGroupAddBtn.click();}

    public void clickUserDetailsEditBtn(){userDetailsEditBtn.click();}

    public void clickUserDetailsSaveBtn(){userDetailsSaveBtn.click();}

    public void inputNewLocationInfo(String locationCode, String description, String company){
        commonPage.sendKeysOnElement(locationShortFormField, locationCode);
        commonPage.sendKeysOnElement(locationDecriptionField, description);
        commonPage.sendKeysOnElement(locationCompanyField, company);
        addLocationYesBtn.click();
    }

    public void inputNewSecurityGroupInfo(String groupName, String groupDescription){
        commonPage.sendKeysOnElement(groupNameField, groupName);
        commonPage.sendKeysOnElement(groupDescriptionField, groupDescription);
        addGroupYesBtn.click();
    }

    public void clickUserName(String userName){
        List<WebElement> elements = getDriver().findElements(By.cssSelector("[id^=settings-engineers-users-hkland-user]"));
        for(WebElement element : elements){
            if(element.getText().equals(userName)){
                element.click();
                break;
            }
        }
    }

    public void clickAttributeCheckbox(String attribute){
        List<WebElement> checkboxes = getDriver().findElements(By.cssSelector("label[for^=modules-settings-engineers-hkl-user-checkbox]"));
        List<String> textList = checkboxes.stream().map(element -> {return element.getText();}).collect(Collectors.toList());
        if(!textList.contains(attribute)){
            System.out.println(attribute + " option can't be found in user details");
        }else{
            for(WebElement checkbox : checkboxes){
                if (checkbox.getText().equals(attribute)){
                    checkbox.click();
                    break;
                }
            }
        }
    }

    public void addAttribute(String attribute) {
        List<WebElement> emphasisElements = getDriver().findElements(By.xpath(".//span[@class='emphasis']"));
        List<String> textList = emphasisElements.stream().map(element -> {
            return element.getText().replace(",","");
        }).collect(Collectors.toList());
        if (!textList.contains(attribute)) {
            clickAttributeCheckbox(attribute);
        }
    }

    public void removeAttribute(String attribute) {
        List<WebElement> emphasisElements = getDriver().findElements(By.xpath(".//span[@class='emphasis']"));
        List<String> textList = emphasisElements.stream().map(element -> {
            return element.getText().replace(",","");
        }).collect(Collectors.toList());
        if (textList.contains(attribute)) {
            clickAttributeCheckbox(attribute);
        }
    }
}
