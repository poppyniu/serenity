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

    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/div[3]/ul/li[1]/span")
    WebElement userOption;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/div[3]/ul/li[2]/span")
    WebElement locationOPtion;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/div[3]/ul/li[3]/span")
    WebElement securityGroupOption;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/div[3]/ul/li[4]/span")
    WebElement thresholdOption;
    @FindBy(xpath = ".//*[@id='pages-settings-selector']/div/div[3]/ul/li[5]/span")
    WebElement generalDocuments;

    @FindBy(id = "add_location_a")
    WebElement locationAddBtn;
    @FindBy(xpath = ".//a[@class='nav-back']")
    WebElement locationDetailsBackLink;

    @FindBy(id = "settings-engineers-add-group")
    WebElement securityGroupAddBtn;
    @FindBy(id = "settings-engineers-security-group-detail-back")
    WebElement securityGroupDetailsBackLink;

    @FindBy(id = "settings-engineers-hkl-user-detail-btn-edit")
    WebElement userDetailsEditBtn;
    @FindBy(id = "settings-engineers-hkl-user-detail-btn-save")
    WebElement userDetailsSaveBtn;
    @FindBy(id = "settings-engineers-hkl-user-detail-back")
    WebElement userDetailsBackLink;

    @FindBy(xpath = ".//*[@id='settings-engineers-threshold-form']/div[1]/div[2]/button")
    WebElement thresholdEditBtn;
    @FindBy(id = "settings-engineers-threshold-input")
    WebElement thresholdInputField;
    @FindBy(xpath = ".//*[@id='settings-engineers-threshold-form']/div[1]/div[2]/button[2]")
    WebElement thresholdSaveBtn;

    @FindBy(id = "tab-contractor-label")
    WebElement contractorTab;
    @FindBy(xpath = ".//*[@id='tab-contractor']/div/div/div[1]/button[1]")
    WebElement contractorAddBtn;
    @FindBy(xpath = ".//*[@id='tab-contractor']/div/div/div[1]/button[2]")
    WebElement contractorEditBtn;
    @FindBy(id = "settings-vendors-add-number")
    WebElement vendorNumberInputField;
    @FindBy(id = "settings-vendors-add-fullname")
    WebElement vendorFullNameInputField;
    @FindBy(id = "settings-vendors-add-shortName")
    WebElement vendorShortNameInputField;
    @FindBy(id = "settings-vendors-add-addressLine1")
    WebElement vendorAddressLine1Field;
    @FindBy(id = "settings-vendors-add-addressLine2")
    WebElement vendorAddressLine2Field;
    @FindBy(id = "settings-vendors-add-addressLine3")
    WebElement vendorAddressLine3Field;
    @FindBy(id = "settings-vendors-add-phoneNumber")
    WebElement vendorCompanyPhoneNumberField;
    @FindBy(id = "settings-vendors-add-contactAdmin")
    WebElement vendorContactAdminField;
    @FindBy(id = "settings-vendors-add-contactPhone")
    WebElement vendorContactPhoneField;
    @FindBy(id = "settings-vendors-add-email")
    WebElement vendorEmailAddress;
    @FindBy(id = "tender-general-contractData-save")
    WebElement vendorNewAddBtn;


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

    public void clickSecurityGroupAddBtn() {
        securityGroupAddBtn.click();
    }

    public void clickUserDetailsEditBtn(){userDetailsEditBtn.click();}

    public void clickUserDetailsSaveBtn(){userDetailsSaveBtn.click();}

    public void inputNewLocationInfo(String locationCode, String description, String company){
        WebElement element = getDriver().findElements(By.cssSelector("div[style='display: block;']")).get(1);
        WebElement locationShortFormField = element.findElement(By.id("add-location-code"));
        WebElement locationDecriptionField = element.findElement(By.id("add-location-desc"));
        WebElement locationCompanyField = element.findElement(By.id("add-location-company"));
        WebElement addLocationYesBtn = element.findElement(By.xpath(".//*[@id='addLocationModal']/div[2]/button[2]"));
        commonPage.sendKeysOnElement(locationShortFormField, locationCode);
        commonPage.sendKeysOnElement(locationDecriptionField, description);
        commonPage.sendKeysOnElement(locationCompanyField, company);
        addLocationYesBtn.click();
        commonPage.wait(getDriver(),2);
        locationDetailsBackLink.click();
    }

    public void inputNewSecurityGroupInfo(String groupName, String groupDescription){
        WebElement element = getDriver().findElements(By.cssSelector("div[style='display: block;']")).get(1);
        WebElement groupNameField = element.findElement(By.id("settings-engineers-add-group-name-value"));
        WebElement groupDescriptionField = element.findElement(By.id("settings-engineers-add-group-description-value"));
        WebElement addGroupYesBtn = element.findElement(By.xpath(".//*[@id='groupSettingAddModal']/div[2]/button[2]"));
        commonPage.sendKeysOnElement(groupNameField, groupName);
        commonPage.sendKeysOnElement(groupDescriptionField, groupDescription);
        addGroupYesBtn.click();
        commonPage.wait(getDriver(),2);
        securityGroupDetailsBackLink.click();
    }

    public void clickUserName(String userName){
        List<WebElement> elements = getDriver().findElements(By.cssSelector("[id^=settings-engineers-users-hkland-user]"));
        for(WebElement element : elements){
            if(element.getText().equals(userName)){
                element.click();
                break;
            }
        }
        commonPage.wait(getDriver(),3);
    }

    private void clickAttributeCheckbox(String attribute){
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

    private List<String> getSelectedAttributeList(){
        List<WebElement> emphasisElements = getDriver().findElements(By.xpath(".//span[@class='emphasis']"));
        return emphasisElements.stream().map(element -> {
            return element.getText().replace(",","");
        }).collect(Collectors.toList());
    }

    public void addAttribute(String attribute) {
        List<String> preAttributes = getSelectedAttributeList();
        if (!preAttributes.contains(attribute)) {
            clickAttributeCheckbox(attribute);
        }
    }

    public void removeAttribute(String attribute){
        List<String> preAttributes = getSelectedAttributeList();
        if (preAttributes.contains(attribute)) {
            clickAttributeCheckbox(attribute);
        }
    }

    public void clickBackLinkOnUserDetails(){userDetailsBackLink.click();}

    public void inputThresholdValue(String value){
        thresholdEditBtn.click();
        commonPage.sendKeysOnElement(thresholdInputField,value);
        thresholdSaveBtn.click();
    }

    public void clickContractorTab(){contractorTab.click();}

    public void clickAddBtnUnderContractorTab(){contractorAddBtn.click();}

    public void inputNewVendorInfo(String vendorID, String fullName, String shortName, String addressLine1, String addressLine2, String addressLine3, String companyPhoneNumber,
                                   String contactAdmin, String contactPhoneNumber, String emailAddress){
        commonPage.sendKeysOnElement(vendorNumberInputField, vendorID);
        commonPage.sendKeysOnElement(vendorFullNameInputField, fullName);
        commonPage.sendKeysOnElement(vendorShortNameInputField, shortName);
        commonPage.sendKeysOnElement(vendorAddressLine1Field, addressLine1);
        commonPage.sendKeysOnElement(vendorAddressLine2Field, addressLine2);
        commonPage.sendKeysOnElement(vendorAddressLine3Field, addressLine3);
        commonPage.sendKeysOnElement(vendorCompanyPhoneNumberField, companyPhoneNumber);
        commonPage.sendKeysOnElement(vendorContactAdminField, contactAdmin);
        commonPage.sendKeysOnElement(vendorContactPhoneField, contactPhoneNumber);
        commonPage.sendKeysOnElement(vendorEmailAddress, emailAddress);
        vendorNewAddBtn.click();
    }
}
