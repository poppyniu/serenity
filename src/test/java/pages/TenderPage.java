package pages;

import constants.DBHelper;
import constants.TestAccountsConstants;
import constants.TestDataPathConstants;
import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Poppy_Zhang on 2017/7/19.
 */
public class TenderPage extends PageObject {
    String testDataPath = System.getProperty("testdata");
    String currentUrl;
    CommonPage commonPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar')]/a[2]")
    WebElement saveBtn;
    //General tab elements
    @FindBy(xpath = ".//*[@id='tender.general.workingHours']/div/div[2]/div[1]/div[1]")
    WebElement workingHoursDropdown1;
    @FindBy(xpath = ".//*[@id='tender.general.workingHours']/div/div[2]/div[2]/div[2]")
    WebElement workingHoursDropdown2;
    @FindBy(xpath = ".//*[@id='tender.general.workingHours']/div/div[2]/div[3]/div[1]")
    WebElement workingHoursDropdown3;
    @FindBy(xpath = ".//*[@id='tender.general.workingHours']/div/div[2]/div[4]/div[2]")
    WebElement workingHoursDropdown4;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[1]/ul/li/span/span[contains(text(),'Friday')]")
    WebElement workingHoursDropdown1Item1;
    @FindBy(xpath = ".//*[@id='modules-tenders-edit-general-projectDescription']/div/textarea")
    WebElement projectDescriptionTextbox;
    @FindBy(xpath = ".//*[@id='modules-tenders-edit-general-projectLocation']/div/textarea")
    WebElement projectLocationTextbox;
    @FindBy(xpath = ".//*[@id='modules-tenders-edit-general-projectStart']")
    WebElement tentativeProjectStartTextbox;
    @FindBy(xpath = ".//*[@id='modules-tenders-edit-general-estimatedProjectDuration']/div/textarea")
    WebElement projectDurationTextbox;
    @FindBy(xpath = ".//*[@id='modules-tenders-workingHours-add']")
    WebElement addWorkingHoursBtn;
    @FindBy(xpath = ".//*[@id='modules-tenders-edit-general-validityPeriod']")
    WebElement periodTextbox;
    @FindBy(xpath = ".//*[@id='tender.general.prNo']")
    WebElement prNumberTextbox;
    @FindBy(xpath = ".//*[@id='modules-tenders-edit-general-pr-add']")
    WebElement prNumberAddBtn;
    @FindBy(xpath = ".//*[@id='tender.general.contractData.save']")
    WebElement prNumberInfoSaveBtn;
    @FindBy(xpath = ".//span[@id='tender.general.budget'][@class='pr-data']")
    WebElement prAmount;
    //ScopeOfWork tab elements
    @FindBy(xpath = ".//*[@id='tab-scope-label']")
    WebElement scopeOfWorkTab;
    @FindBy(xpath = ".//*[@id='tinymce']")
    WebElement scopeOfWorkTextBox;
    @FindBy(xpath = ".//iframe[@id='generalDesc_ifr']")
    WebElement scopeOfWorkFreame1;
    @FindBy(xpath = ".//iframe[@id='generalSpec_ifr']")
    WebElement scopeOfWorkFreame2;
    @FindBy(xpath = ".//iframe[@id='particularDesc_ifr']")
    WebElement scopeOfWorkFreame3;
    //Items Services tab elements
    @FindBy(xpath = ".//*[@id='items-services-edit-form']/div")
    List<WebElement> sections;
    @FindBy(xpath = ".//*[@id='tab-services-label']")
    WebElement itemsServicesTab;
    @FindBy(xpath = ".//*[@id='tender.section.title_0']")
    WebElement addSectionTitleTextbox;
    @FindBy(xpath = ".//*[@id='line.desc_0_0']")
    WebElement addDescriptionTextbox;
    @FindBy(xpath = ".//*[@id='line.qty_0_0']")
    WebElement addQTYTextbox;
    @FindBy(xpath = ".//*[@id='line.unit_0_0']/div[1]/div[1]")
    WebElement unitDropdown;
    @FindBy(xpath = ".//*[@id='line.unit_0_0']/div[1]/div[3]/ul/li[3]/span")
    WebElement unitDropdownItem;
    //Attachments tab elements
    @FindBy(xpath = ".//*[@id='tab-attachment-label']")
    WebElement attachmentsTab;
    @FindBy(xpath = ".//*[@id='dropzone']/div/img")
    WebElement uploadAttachmentBtn;
    @FindBy(xpath = ".//input[@type='file']")
    WebElement uploadFileTextbox;
    @FindBy(xpath = ".//*[@id='attachment-desc-form']/textarea")
    WebElement attachmentDescription;
    @FindBy(xpath = ".//*[@id='fileupload']/table/tbody/tr/td[2]/a")
    WebElement uploadedFileName;
    @FindBy(xpath = ".//*[@id='mini-toastr']/div/div")
    WebElement saveSuccessInfo;
    @FindBy(xpath = ".//*[@class='clearfix']/div[2]/a[3]")
    WebElement previewSubmitBtn;
    @FindBy(xpath = ".//*[contains(@class, 'tender-view-button-bar')]/div/div/button")
    WebElement submitBtn;
    @FindBy(xpath = ".//*[@class='reveal-overlay']/div/div[1]/div[2]/div[1]")
    WebElement chooseApproveDropdown;
    @FindBy(xpath = ".//*[@class='reveal-overlay']/div/div[1]/div[2]/div[3]/ul/li[1]/span/span")
    WebElement approveDropdownItem;
    @FindBy(xpath = ".//*[@class='reveal-overlay']/div/div[2]/button[2]")
    WebElement chooseApproveEnterBtn;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div/div[1]/p")
    WebElement sendForApproveInfo;
    @FindBy(xpath = ".//*[@class='reveal-overlay']/div/div[2]/button[contains(text(),'Okay')]")
    WebElement sendForApproveEnterBtn;
    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar' )]/div/a")
    WebElement adminApproveBtn;
    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar' )]/div/div/a")
    WebElement adminRejectBtn;
    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar')]/div/a")
    WebElement engineerIssueBtn;
    @FindBy(xpath = ".//*[@id='edit-closing-date-picker']/div[1]/div[1]/span/i")
    WebElement closingDateDropdown1;
    @FindBy(xpath = ".//*[@id='edit-closing-date-picker']/div[1]/div[2]/div[1]/span[3]")
    WebElement closingDateDropdown1LeftBtn;
    @FindBy(xpath = ".//*[@id='edit-closing-date-picker']/div[1]/div[2]/div[2]/span[15]")
    WebElement closingDateNextPageItem1;
    @FindBy(xpath = ".//*[@id='edit-closing-date-picker']/div[2]/div[1]")
    WebElement closingDateDropdown2;
    @FindBy(xpath = " .//*[@id='edit-closing-date-picker']/div[2]/div[3]/ul/li[2]/span/span")
    WebElement closingDateDropdown2item;
    @FindBy(xpath = ".//div[@class='mini-toastr-notification__message']")
    WebElementFacade headerMessage;
    @FindBy(xpath = ".//*[@id='items-services-form']/div[1]/table/tbody/tr[1]/td[3]/input")
    WebElementFacade qtyTextbox;
    @FindBy(xpath = ".//*[@id='items-services-form']/div[1]/table/tbody/tr[1]/td[5]/input")
    WebElementFacade rateTextbox;
    @FindBy(xpath = ".//*[@id='bid-discount-panel']/tr/td[3]/div/div[1]")
    WebElementFacade discountDropdown;
    @FindBy(xpath = ".//*[@id='bid-discount-panel']/tr/td[3]/div/div[3]/ul/li[2]/span/span")
    WebElementFacade discountDropdownItem;
    @FindBy(xpath = ".//*[@id='tab-tnc-label']")
    WebElementFacade termsTab;
    @FindBy(xpath = ".//*[@id='tnc-agree']")
    WebElementFacade termsCheckbox1;
    @FindBy(xpath = ".//*[@id='tnc-agree-perform']")
    WebElementFacade termsCheckbox2;
    @FindBy(xpath = ".//*[@id='tnc-agree-name']")
    WebElementFacade termsNameTextbox;
    @FindBy(xpath = ".//*[@id='tnc-agree-position']")
    WebElementFacade termsPositionTextbox;
    @FindBy(xpath = ".//*[@id='alertSubmitModal']/div[1]/p")
    WebElementFacade contractorSubmitInfo;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/tbody/tr/td[3]")
    WebElementFacade statusColumn;
    @FindBy(xpath = ".//div[contains(@class, 'tender-status')]")
    WebElementFacade tenderStatus;
    @FindBy(xpath = ".//*[@class='vendor-status-list']/table/tbody/tr[3]/td[3]")
    WebElementFacade vendorSubmitStatus;
    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar')]/button")
    WebElement startAnalysisBtn;
    @FindBy(xpath = ".//*[@id='router-view-content']/div[1]/div[1]")
    WebElement tenderSummaryDropdown;
    @FindBy(xpath = ".//*[@id='router-view-content']/div[1]/div[3]/ul/li[2]/span")
    WebElement analysisFromSummaryDropdown;
    @FindBy(xpath = ".//*[@id='analysis-recos-content']/div[2]/div/div/a[2]")
    WebElement runAnalysisBtn;
    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar')]/div/a[1]")
    WebElement vendorSaveButton;
    @FindBy(xpath = ".//div[contains(@class, 'tender-view-button-bar')]/div/a[2]")
    WebElement vendorSubmitButton;
    @FindBy(xpath = ".//div[starts-with(@class, 'reveal-overlay')][@style='display: block;']/div/div[2]/button[2]")
    WebElement vendorConfirmSubmitBtn;
    @FindBy(xpath = ".//*[@id='tenders-comparison-data']/table")
    WebElementFacade comparisonTable;
    @FindBy(xpath = ".//td[contains(@class, 'lowestLine')]")
    List<WebElementFacade> lowestPricesInComparisonTable;
    @FindBy(xpath = ".//*[@id='search-panel']/th[1]/input")
    WebElement prNoInputBox;
    @FindBy(xpath = ".//*[@id='search-panel']/th[3]/div/div[1]")
    WebElement statusDropdown;
    @FindBy(xpath = ".//*[@id='view-all-component']/div[2]/div/div/div[1]/span")
    WebElement allTendersPageTitle;
    @FindBy(xpath = ".//*[@id='search-panel']/th[3]/div/div[3]/ul/li[2]/span/span")
    WebElement statusDropdownItem;
    @FindBy(xpath = ".//*[@id='query-btn']")
    WebElement searchBtn;
    @FindBy(xpath = ".//*[@id='view-all-component']/div[3]/table/tbody/tr[2]/td[1]/a")
    WebElement searchResult;
    @FindBy(xpath = ".//*[@id='page-header-options']/li/i")
    WebElement tenderOptionBtn;
    @FindBy(xpath = ".//*[@id='page-header-options']/li/ul/li[2]/div/button")
    WebElement tenderCancelBtn;
    @FindBy(xpath = ".//*[@id='page-header-cancel-dialog']/div[4]/div/button")
    WebElement continueCancelBtn;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]//textarea")
    WebElement rejectTenderTextbox;
    @FindBy(xpath = "//div[contains(@style,'display: block')]/div[2]/button[text()='Reject']")
    WebElement rejectWindowRejectBtn;
    @FindBy(xpath = ".//*[@id='page-header-options']/li/ul/li[2]/li/div/button")
    WebElement resetToDraftBtn;
    @FindBy(xpath = ".//*[@id='tender-reset-to-draft-dialog']/div[4]/div/button")
    WebElement resetToDraftContinueBtn;
    @FindBy(xpath = ".//*[@id='start-addendum']")
    WebElement startAddendumBtn;
    @FindBy(xpath = ".//*[@id='start-addendum-container']/following-sibling::*[1]/button[2]")
    WebElement addendumYesBtn;
    @FindBy(xpath = ".//*[@id='general-form']/div[1]/div[1]/div[5]/a")
    WebElement requestExtensionBtn;
    @FindBy(xpath = ".//*[@id='general-form']/div[1]/div[1]/div[5]/label")
    WebElement requestExtensionInfo;
    @FindBy(xpath = ".//*[@id='submit_tender_addendum']")
    WebElement submitAddendumBtn;
    @FindBy(xpath = ".//*[@id='summaryModal']/div[1]/div/div[1]/pre")
    WebElement extensionRequestLable;
    @FindBy(xpath = ".//*[@id='summaryModal']/div[1]/div/div[3]/pre")
    WebElement locationLable;
    @FindBy(xpath = ".//*[@id='summaryModal']/div[1]/div/div[5]/pre")
    WebElement fileLable;
    @FindBy(xpath = ".//*[@id='summaryModal']/div[2]/button[2]")
    WebElement addendumSubmitBtn;
    @FindBy(xpath = ".//*[@id='addendum-detail-content']/div/div/div[3]/div[2]/div[2]/a")
    WebElement addendumSaveBtn;




    public void clickCreateTender() throws Exception {
        dashboardPage.selectCreateTenderDropdown("tender");
    }

    public void inputGeneralTabInfo(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Exception {
        commonPage.sendKeysOnElement(projectDescriptionTextbox, Description);
        commonPage.wait(getDriver(), 1);
        commonPage.sendKeysOnElement(projectLocationTextbox, Location);
        commonPage.wait(getDriver(), 1);
        commonPage.sendKeysOnElement(tentativeProjectStartTextbox, ProjectStart);
        commonPage.wait(getDriver(), 1);
        commonPage.sendKeysOnElement(projectDurationTextbox, Duration);
        commonPage.wait(getDriver(), 1);
        //select working hours dropdown1
        workingHoursDropdown1.click();
        commonPage.wait(getDriver(), 2);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(1, WorkingHours1);
        //select working hours dropdown2
        workingHoursDropdown2.click();
        commonPage.wait(getDriver(), 2);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(2, WorkingHours2);
        commonPage.wait(getDriver(), 2);
        workingHoursDropdown3.click();
        commonPage.wait(getDriver(), 2);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(3, WorkingHours3);
        workingHoursDropdown4.click();
        commonPage.wait(getDriver(), 2);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(4, WorkingHours4);
        commonPage.wait(getDriver(), 3);
        addWorkingHoursBtn.click();
        commonPage.wait(getDriver(), 1);
        periodTextbox.clear();
        commonPage.sendKeysOnElement(periodTextbox, Period);
        commonPage.wait(getDriver(), 1);
        commonPage.scrollToElement(prNumberAddBtn);
        commonPage.sendKeysOnElement(prNumberTextbox, PRNumber);
        commonPage.wait(getDriver(), 2);
        prNumberAddBtn.click();
        commonPage.wait(getDriver(), 2);
        prNumberInfoSaveBtn.click();
        commonPage.wait(getDriver(), 2);
    }

    public void inputScopeOfWorkTabInfo(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Exception {
        scopeOfWorkTab.click();
        commonPage.wait(getDriver(), 2);
        getDriver().switchTo().frame(scopeOfWorkFreame1);
        commonPage.wait(getDriver(), 2);
        scopeOfWorkTextBox.click();
        scopeOfWorkTextBox.sendKeys(GeneralDescriptionofWork);
        getDriver().switchTo().defaultContent();
        commonPage.wait(getDriver(), 2);
        getDriver().switchTo().frame(scopeOfWorkFreame2);
        commonPage.wait(getDriver(), 2);
        scopeOfWorkTextBox.click();
        scopeOfWorkTextBox.sendKeys(GeneralSpecifications);
        getDriver().switchTo().defaultContent();
        commonPage.wait(getDriver(), 2);
        getDriver().switchTo().frame(scopeOfWorkFreame3);
        commonPage.wait(getDriver(), 2);
        scopeOfWorkTextBox.click();
        scopeOfWorkTextBox.sendKeys(ParticularSpecifications);
        commonPage.wait(getDriver(), 1);
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        commonPage.wait(getDriver(), 2);
        getDriver().switchTo().defaultContent();
        commonPage.wait(getDriver(), 3);
    }

    public void inputItemsServicesTabInfo(String SectionTitle1, String DescriptionofWork1, String QTY1, String UNIT1) throws Exception {
        commonPage.scrollToElement(itemsServicesTab);
        itemsServicesTab.click();
        commonPage.wait(getDriver(), 2);
        commonPage.sendKeysOnElement(addSectionTitleTextbox, SectionTitle1);
        commonPage.wait(getDriver(), 2);
        addDescriptionTextbox.clear();
        commonPage.sendKeysOnElement(addDescriptionTextbox, DescriptionofWork1);
        commonPage.wait(getDriver(), 2);
        addQTYTextbox.clear();
        commonPage.sendKeysOnElement(addQTYTextbox, QTY1);
        commonPage.wait(getDriver(), 1);
        unitDropdown.click();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(unitDropdownItem);
        unitDropdownItem.click();
    }

    public void uploadAttachments(String description) throws Exception {
        commonPage.scrollToElement(attachmentsTab);
        attachmentsTab.click();
        commonPage.wait(getDriver(), 2);
        commonPage.sendKeysOnElement(attachmentDescription, description);
        commonPage.wait(getDriver(), 1);
        //Upload file：
        WebElement uploadFileElement = getDriver().findElements(By.xpath("//input[@type='file']")).get(0);
        JavascriptExecutor removeAttribute = (JavascriptExecutor) getDriver();
        removeAttribute.executeScript("arguments[0].removeAttribute('style');", uploadFileElement);
        commonPage.wait(getDriver(), 2);
        if (testDataPath == null) {
            testDataPath = TestDataPathConstants.uploadFilePath;
        }
        uploadFileTextbox.sendKeys(testDataPath);
        commonPage.wait(getDriver(), 4);
        boolean uploadFileExist = commonPage.elementExist(uploadedFileName);
        if (uploadFileExist == true) {
            System.out.println("Upload file succeed,test pass!");
        } else
            Assert.fail("Upload file get error,test fail!");
    }

    public void inputAttachmentsTabInfo(String ProjectDescription) throws Exception {
        commonPage.scrollToElement(attachmentsTab);
        attachmentsTab.click();
        commonPage.wait(getDriver(), 2);
        commonPage.sendKeysOnElement(attachmentDescription, ProjectDescription);
        commonPage.wait(getDriver(), 1);
        //Upload file：
        WebElement uploadFileElement = getDriver().findElements(By.xpath("//input[@type='file']")).get(0);
        JavascriptExecutor removeAttribute = (JavascriptExecutor) getDriver();
        removeAttribute.executeScript("arguments[0].removeAttribute('style');", uploadFileElement);
        commonPage.wait(getDriver(), 2);
        if (testDataPath == null) {
            testDataPath = TestDataPathConstants.uploadFilePath;
        }
        uploadFileTextbox.sendKeys(testDataPath);
        commonPage.wait(getDriver(), 4);
        boolean uploadFileExist = commonPage.elementExist(uploadedFileName);
        if (uploadFileExist == true) {
            System.out.println("Upload file succeed,test pass!");
        } else
            Assert.fail("Upload file get error,test fail!");
        saveBtn.click();
        commonPage.wait(getDriver(), 1);
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Save succeed,test pass!");
        } else
            Assert.fail("Save get error,test fail!");
        commonPage.wait(getDriver(), 5);
    }

    public void previewAndSubmitTender(){
        previewSubmitBtn.click();
        commonPage.wait(getDriver(), 3);
        submitBtn.click();
        chooseApproveDropdown.click();
        approveDropdownItem.click();
        commonPage.wait(getDriver(), 1);
        chooseApproveEnterBtn.click();
        commonPage.wait(getDriver(), 2);
        if (sendForApproveInfo.getText().contains("Your tender has been sent for approval, Stay tuned")) {
            System.out.println("Send tender for approve succeed, test pass!");
            sendForApproveInfo.click();
            Actions action = new Actions(getDriver());
            action.sendKeys(Keys.TAB).perform();
            commonPage.wait(getDriver(), 1);
            action.sendKeys(Keys.ENTER).perform();
            commonPage.wait(getDriver(), 2);
        } else
            Assert.fail("Send tender for approve get error, test fail!");
    }

    public void submitTenderForApprove() throws Exception {
        dashboardPage.hkldLogo.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        previewSubmitBtn.click();
        commonPage.wait(getDriver(), 1);
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Preview and submit succeed,test pass!");
        } else
            Assert.fail("Preview and submit get error,test fail!");
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        submitBtn.click();
        commonPage.wait(getDriver(), 2);
        chooseApproveDropdown.click();
//        commonPage.wait(getDriver(),4);
//        chooseApproveDropdown.click();
        commonPage.wait(getDriver(), 2);
        approveDropdownItem.click();
        commonPage.wait(getDriver(), 1);
        chooseApproveEnterBtn.click();
        commonPage.wait(getDriver(), 2);
        if (sendForApproveInfo.getText().contains("Your tender has been sent for approval, Stay tuned")) {
            System.out.println("Send tender for approve succeed, test pass!");
            sendForApproveInfo.click();
            Actions action = new Actions(getDriver());
            action.sendKeys(Keys.TAB).perform();
            commonPage.wait(getDriver(), 1);
            action.sendKeys(Keys.ENTER).perform();
            commonPage.wait(getDriver(), 2);
        } else
            Assert.fail("Send tender for approve get error, test fail!");
    }

    public void changeTenderPersonInChargeInDB() throws Exception {
        DBHelper.changePersonInCharge();
    }

    public void approveTender(){
        adminApproveBtn.click();
        commonPage.wait(getDriver(), 2);
    }

    public void adminApprove() throws Exception {
        getDriver().get(URLConstants.hkldLoginPage);
        commonPage.wait(getDriver(), 2);
        loginPage.Login(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        adminApproveBtn.click();
        commonPage.wait(getDriver(), 2);
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Admin approve tender succeed,test pass!");
        } else
            Assert.fail("Admin approve tender get error,test fail!");
    }

    public void issueTender(){
        closingDateDropdown1.click();
        commonPage.wait(getDriver(), 1);
        closingDateDropdown1LeftBtn.click();
        commonPage.wait(getDriver(), 1);
        closingDateNextPageItem1.click();
        commonPage.wait(getDriver(), 1);
        closingDateDropdown2.click();
        commonPage.wait(getDriver(), 1);
        closingDateDropdown2item.click();
        commonPage.wait(getDriver(), 2);
        engineerIssueBtn.click();
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Engineer issue tender succeed,test pass!");
        } else
            Assert.fail("Engineer issue tender get error,test fail!");
        commonPage.wait(getDriver(), 5);
    }

    public void engineerIssueTender() throws Exception {
        commonPage.navigatePage(URLConstants.hkldLoginPage);
        loginPage.Login(TestAccountsConstants.hkldUserName, TestAccountsConstants.hkldUserPwd);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        closingDateDropdown1.click();
        commonPage.wait(getDriver(), 1);
        closingDateDropdown1LeftBtn.click();
        commonPage.wait(getDriver(), 1);
        closingDateNextPageItem1.click();
        commonPage.wait(getDriver(), 1);
        closingDateDropdown2.click();
        commonPage.wait(getDriver(), 1);
        closingDateDropdown2item.click();
        commonPage.wait(getDriver(), 2);
        engineerIssueBtn.click();
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Engineer issue tender succeed,test pass!");
        } else
            Assert.fail("Engineer issue tender get error,test fail!");
    }

    public void contractorSubmitTender(String tenderType) throws Exception {
        //contractor login
        getDriver().get(URLConstants.contractorLoginPage);
        commonPage.wait(getDriver(), 2);
        if (tenderType.contains("tender")) {
            loginPage.Login(TestAccountsConstants.contractorNameTender, TestAccountsConstants.contractorPwd);
        } else if (tenderType.contains("itq")) {
            loginPage.Login(TestAccountsConstants.contractorNameITQ, TestAccountsConstants.contractorPwd);
        }
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        //input info under items/service tab
        itemsServicesTab.click();
        commonPage.wait(getDriver(), 2);
        qtyTextbox.clear();
        commonPage.sendKeysOnElement(qtyTextbox, "10");
        commonPage.wait(getDriver(), 1);
        rateTextbox.clear();
        commonPage.sendKeysOnElement(rateTextbox, "10");
        commonPage.scrollToElement(discountDropdown);
        commonPage.wait(getDriver(), 1);
        discountDropdown.click();
        commonPage.wait(getDriver(), 1);
        discountDropdownItem.click();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(termsTab);
        commonPage.wait(getDriver(), 1);
        //input info under terms tab
        termsTab.click();
        commonPage.wait(getDriver(), 2);
        termsCheckbox1.click();
        commonPage.sendKeysOnElement(termsNameTextbox, TestDataPathConstants.testInfo);
        commonPage.wait(getDriver(), 1);
        commonPage.sendKeysOnElement(termsPositionTextbox, TestDataPathConstants.testInfo);
        commonPage.wait(getDriver(), 1);
        termsCheckbox2.click();
        commonPage.wait(getDriver(), 2);
        //contractor submit
        commonPage.scrollToElement(vendorSaveButton);
        vendorSaveButton.click();
        commonPage.wait(getDriver(), 2);
        vendorSubmitButton.click();
        contractorSubmitInfo.click();
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.TAB).perform();
        commonPage.wait(getDriver(), 2);
        actions.sendKeys(Keys.TAB).perform();
        commonPage.wait(getDriver(), 2);
        actions.sendKeys(Keys.TAB).perform();
        commonPage.wait(getDriver(), 2);
        actions.sendKeys(Keys.ENTER).perform();
        commonPage.wait(getDriver(), 2);
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Contractor issue tender succeed,test pass!");
        } else
            Assert.fail("Contractor issue tender get error,test fail!");
    }

    public void checkVendorSubmitStatus() throws Exception {
        commonPage.navigatePage(URLConstants.hkldLoginPage);
        loginPage.Login(TestAccountsConstants.hkldUserName, TestAccountsConstants.hkldUserPwd);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 4);
        if (tenderStatus.getText().contains("ISSUED") && vendorSubmitStatus.getText().contains("SUBMITTED")) {
            System.out.println("After contractor submit, the tender status and company submit status is correct,test pass!");
        } else
            Assert.fail("After contractor submit, the tender status and company submit status is not correct,test fail!");
    }

    public void changeTenderStatusInDB(String prNo) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = df.format(new Date());
        String currentDateBefore = commonPage.getSpecifiedDayBefore(currentDate);
        DBHelper.changeClosingDate(currentDateBefore, prNo);
    }

    public void checkTenderStatus() throws Exception {
        commonPage.wait(getDriver(), 2);
        getDriver().navigate().refresh();
        commonPage.wait(getDriver(), 5);
        startAnalysisBtn.click();
        commonPage.wait(getDriver(), 3);
        if (tenderStatus.getText().contains("REVIEW")) {
            System.out.println("Tender is after closing date the status changed to review,test pass!");
        } else
            Assert.fail("Tender is after closing date the status does not changed to review,test fail!");

    }

    public void clearTenderFromDb() throws Exception {
        DBHelper.clearDataFromDB("tenders");
    }

    public void deleteSpecifiedTenderFromDB(String prNumber) throws Exception {
        DBHelper.clearSpecifiedTenderData(prNumber);
    }

    public void inputPRNumber(String prNumber) {
        commonPage.sendKeysOnElement(prNumberTextbox, prNumber);
        prNumberAddBtn.click();
    }

    public void clickPRInfoSaveBtn() {
        prNumberInfoSaveBtn.click();
    }

    public void clickSaveBtn() {
        commonPage.scrollToElement(saveBtn);
        saveBtn.click();
        commonPage.wait(getDriver(), 5);
    }

    public void validateHeaderMessage(String ExpectedMsg) {
        Assert.assertTrue("Header message is not shown", headerMessage.isVisible());
        Assert.assertTrue("Header message is not as expected", headerMessage.getText().contains(ExpectedMsg));
    }

    public void clickItemsServicesTab() {
        commonPage.scrollToElement(itemsServicesTab);
        itemsServicesTab.click();
        commonPage.wait(getDriver(), 2);
    }

    public void inputSectionTitle(int index, String sectionTitle) {
        String id = String.format("tender.section.title_" + (index - 1));
        WebElement sectionTitleField = getDriver().findElement(By.id(id));
        commonPage.sendKeysOnElement(sectionTitleField, sectionTitle);
    }

    private void clickSectionActionsDropdown(int index) {
        String xpath = String.format(".//*[@id='section-actions-dropdown_" + (index - 1)) + "']/li/i";
        WebElement sectionActionDropdown = getDriver().findElement(By.xpath(xpath));
        sectionActionDropdown.click();
    }

    private void cilckItemsActionsDropdown(int sectionIndex, int itemIndex) {
        String xpath = String.format(".//*[@id='line-actions-dropdown_" + (sectionIndex - 1) + "_" + (itemIndex - 1) + "']/li/i");
        WebElement itemActionDropdown = getDriver().findElement(By.xpath(xpath));
        itemActionDropdown.click();
    }

    public void clickSectionAction(int index, String action) {
        clickSectionActionsDropdown(index);
        String id = String.format("section.action_" + (index - 1));
        switch (action) {
            case "Add Section":
                id = id + "_addSection";
                break;
            case "Add Section Description":
                id = id + "_addSectionDesc";
                break;
            case "Add Line":
                id = id + "_addLine";
                break;
            case "Delete":
                id = id + "_deleteSection";
                break;
            default:
                System.out.println(action + "option is not found for section action");
        }
        getDriver().findElement(By.id(id)).click();
    }

    public int sectionsQuantity() {
        return sections.size();
    }

    public int itemsQuantity(int sectionIndex) {
        List<WebElement> itemNumbers = sections.get(sectionIndex - 1).findElements(By.xpath(".//td[@class='number']"));
        return itemNumbers.size();
    }

    public void inputItemDescription(int sectionIndex, int itemIndex, String description) {
        String id = String.format("line.desc_" + (sectionIndex - 1) + "_" + (itemIndex - 1));
        WebElement itemDescriptionField = getDriver().findElement(By.id(id));
        commonPage.sendKeysOnElement(itemDescriptionField, description);
    }

    public void inputItemQty(int sectionIndex, int itemIndex, String qty) {
        String id = String.format("line.qty_" + (sectionIndex - 1) + "_" + (itemIndex - 1));
        WebElement itemQtyField = getDriver().findElement(By.id(id));
        commonPage.sendKeysOnElement(itemQtyField, qty);
    }

    private String getRandomUnit(int sectionIndex, int itemIndex) {
        String id = String.format("line.unit_" + (sectionIndex - 1) + "_" + (itemIndex - 1));
        WebElement lineUnit = sections.get(sectionIndex - 1).findElement(By.id(id));
        List<WebElement> unitElements = lineUnit.findElements(By.cssSelector("span[class='multiselect__option'] span"));
        int index = (int) (Math.random() * unitElements.size());
        return unitElements.get(index).getAttribute("textContent");
    }

    public void selectItemUnit(int sectionIndex, int itemIndex) {
        String xpathInput = String.format(".//*[@id='line.unit_" + (sectionIndex - 1) + "_" + (itemIndex - 1) + "']/div[1]/div[2]/input");
        String xpathSelectedUnit = String.format(".//*[@id='line.unit_" + (sectionIndex - 1) + "_" + (itemIndex - 1) + "']/div[1]/div[3]/ul/li[1]/span");
        WebElement unitInputField = getDriver().findElement(By.xpath(xpathInput));
        WebElement dropDownSelectedUnit = getDriver().findElement(By.xpath(xpathSelectedUnit));
        String randomUnit = getRandomUnit(sectionIndex, itemIndex);
        commonPage.sendKeysOnElement(unitInputField, randomUnit);
        dropDownSelectedUnit.click();
    }

    public void clickItemAction(int sectionIndex, int itemIndex, String action) {
        cilckItemsActionsDropdown(sectionIndex, itemIndex);
        String id = String.format("line.action_" + (sectionIndex - 1) + "_" + (itemIndex - 1));
        switch (action) {
            case "Add Line":
                id = id + "_addLine";
                break;
            case "Add Option":
                id = id + "_addOption";
                break;
            case "Add Section":
                id = id + "_addSection";
                break;
            case "Duplicate":
                id = id + "_duplicateLine";
                break;
            case "Delete":
                id = id + "_deleteLine";
                break;
            default:
                System.out.println(action + "option is not found for item action");
        }
        getDriver().findElement(By.id(id)).click();
    }

    private List<WebElement> getOptionDescriptionFields(int sectionIndex, int itemIndex) {
        String id = String.format("[id^='option.desc_" + (sectionIndex - 1) + "_" + (itemIndex - 1) + "']");
        return getDriver().findElements(By.cssSelector(id));
    }

    private void clickOptionActionsDropdown(int sectionIndex, int itemIndex, int optionIndex) {
        String xpath = String.format(".//*[@id='option-actions-dropdown_" + (sectionIndex - 1) + "_" + (itemIndex - 1) + "_" + (optionIndex - 1) + "']/li/i");
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public int OptionQuantity(int sectionIndex, int itemIndex) {
        return getOptionDescriptionFields(sectionIndex, itemIndex).size();
    }

    public void inputOptionDescription(int sectionIndex, int itemIndex, int optionIndex, String optionDescription) {
        commonPage.sendKeysOnElement(getOptionDescriptionFields(sectionIndex, itemIndex).get(optionIndex - 1), optionDescription);
    }

    public void clickOptionAction(int sectionIndex, int itemIndex, int optionIndex, String action) {
        clickOptionActionsDropdown(sectionIndex, itemIndex, optionIndex);
        String id = String.format("option.action_" + (sectionIndex - 1) + "_" + (itemIndex - 1));
        switch (action) {
            case "Add Option":
                id = id + "_addOption";
                break;
            case "Delete":
                id = id + "_deleteOption";
                break;
            default:
                System.out.println(action + " is not found for option action");
        }
        getDriver().findElements(By.id(id)).get(optionIndex - 1).click();
    }

    public String getPRAmountFromGeneralTab() {
        return prAmount.getAttribute("textContent");
    }

    public void clickFloatingButton(String buttonName) {
        List<WebElement> floatButtons = getDriver().findElements(By.xpath(".//*[@id='sticky-tender-tabs']/div/div/a"));
        for (WebElement button : floatButtons) {
            if (button.getAttribute("textContent").contains(buttonName)) {
                button.click();
                commonPage.wait(getDriver(), 2);
                return;
            }
        }
        Assert.fail(buttonName + " is not a valid float button");
    }

    public void runAnalysis() throws Exception {
        startAnalysisBtn.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        String id = currentUrl.split("/")[5];
        String comparisonUrl = "http://hkld-qa.princeton.epam.com/#/comparison/" + id;
        //tenderSummaryDropdown.click();
        //analysisFromSummaryDropdown.click();
        //commonPage.wait(getDriver(),3);
        runAnalysisBtn.click();
        commonPage.wait(getDriver(), 3);
        commonPage.navigatePage(comparisonUrl);
        commonPage.wait(getDriver(), 3);
        Assert.assertTrue("Comparison table is not generated", comparisonTable.isVisible());
        Assert.assertFalse("None of the lowest prices is shown in the comparison table", lowestPricesInComparisonTable.isEmpty());
    }

    public void vendorInputRateForItemsServices() {
        itemsServicesTab.click();
        List<WebElement> rateFields = getDriver().findElements(By.xpath(".//*[@id='tab-services']/div/div/form/div[@class='card-section hover']//input[@required='required']"));
        for (int i=0; i<rateFields.size(); i++){
            int randomRate = (int)Math.round(Math.random()*989+10);
            commonPage.sendKeysOnElement(rateFields.get(i), Integer.toString(randomRate));
            if((i+1)<rateFields.size()){
                commonPage.scrollToElement(rateFields.get(i+1));
            }
        }
    }

    public void vendorInputTermsInfo() {
        commonPage.scrollToElement(termsTab);
        termsTab.click();
        termsCheckbox1.click();
        commonPage.sendKeysOnElement(termsNameTextbox, TestDataPathConstants.testInfo);
        commonPage.sendKeysOnElement(termsPositionTextbox, TestDataPathConstants.testInfo);
        termsCheckbox2.click();
    }

    public void vendorClickSubmitButton() {
        commonPage.scrollToElement(vendorSaveButton);
        vendorSaveButton.click();
        commonPage.wait(getDriver(), 5);
        vendorSubmitButton.click();
        commonPage.wait(getDriver(), 2);
        vendorConfirmSubmitBtn.click();
        commonPage.wait(getDriver(), 5);
    }

    public void clickViewAllTendersBtn() throws Exception {
        dashboardPage.viewAllTendersBtn.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);

    }

    public void viewAllPageSearch() throws Exception {
        if(allTendersPageTitle.getText().contains("All ITQ/Tenders")){
            System.out.println("Open view all tenders page succeed,test pass!");
        } else
            Assert.fail("Open view all tenders page get error,test fail!");
        commonPage.wait(getDriver(), 2);
        commonPage.sendKeysOnElement(prNoInputBox,"58668");
        commonPage.wait(getDriver(), 2);
        statusDropdown.click();
        commonPage.wait(getDriver(), 2);
        statusDropdownItem.click();
        commonPage.wait(getDriver(), 2);
        searchBtn.click();
        commonPage.wait(getDriver(), 2);
        if(searchResult.getText().contains("58668")){
            System.out.println("Search function on view all tenders page works well,test pass!");
        } else
            Assert.fail("Search function on view all tenders page does not work well,test fail!");
    }

    public void clickTenderItem() throws Exception {
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
    }

    public void cancelTender() throws Exception {
        tenderOptionBtn.click();
        commonPage.wait(getDriver(), 2);
        tenderCancelBtn.click();
        commonPage.wait(getDriver(), 2);
        continueCancelBtn.click();
        commonPage.wait(getDriver(), 1);
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println("Cancel tender succeed,test pass!");
        } else
            Assert.fail("Cancel tender get error,test fail!");
        commonPage.wait(getDriver(), 3);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        if(!commonPage.isContentAppeared(getDriver(),"58668"))
        {
            System.out.println("Canceled tender is not appeared on dashboard page,test pass!");
        } else
            Assert.fail("Canceled tender still appear on dashboard page,test fail!");
    }

    public void rejectTender() throws Exception {
        getDriver().get(URLConstants.hkldLoginPage);
        commonPage.wait(getDriver(), 2);
        loginPage.Login(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        adminRejectBtn.click();
        commonPage.wait(getDriver(), 2);
        rejectTenderTextbox.click();
        Actions actions =new Actions(getDriver());
        actions.sendKeys(Keys.SPACE).perform();
        actions.sendKeys("aaa").perform();
        actions.sendKeys(Keys.TAB).perform();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(rejectWindowRejectBtn);
        rejectWindowRejectBtn.click();
        commonPage.wait(getDriver(), 1);
        checkSucceed("Admin reject tender");
        commonPage.wait(getDriver(), 3);
    }

    public void checkTenderStatus(String status) throws Exception {
        getDriver().get(URLConstants.hkldLoginPage);
        commonPage.wait(getDriver(), 2);
        loginPage.Login(TestAccountsConstants.hkldUserName, TestAccountsConstants.hkldUserPwd);
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        if (dashboardPage.tenderStatusColumn.getText().contains(status)) {
            System.out.println("Tender status is correct,test pass!");
        } else
            Assert.fail("Tender status is not correct,test fail!");
    }

    public void resetToDraft() throws Exception {
        getDriver().get(URLConstants.hkldLoginPage);
        commonPage.wait(getDriver(), 2);
        loginPage.Login(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        tenderOptionBtn.click();
        commonPage.wait(getDriver(), 2);
        resetToDraftBtn.click();
        commonPage.wait(getDriver(), 2);
        resetToDraftContinueBtn.click();
        commonPage.wait(getDriver(), 1);
        checkSucceed("Reset tender to draft");
    }

    public void checkSucceed(String info) throws Exception {
        if (saveSuccessInfo.getText().contains("Success")) {
            System.out.println(info+" succeed,test pass!");
        } else
            Assert.fail(info+" get error,test fail!");
    }

    public void doAddendum() throws Exception {
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(dashboardPage.tenderItem58668);
        dashboardPage.tenderItem58668.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        startAddendumBtn.click();
        commonPage.wait(getDriver(), 2);
        addendumYesBtn.click();
        commonPage.wait(getDriver(), 2);
        //modify general tab info
        projectDescriptionTextbox.clear();
        commonPage.wait(getDriver(), 1);
        commonPage.sendKeysOnElement(projectDescriptionTextbox, "editDescription");
        commonPage.wait(getDriver(), 1);
        projectLocationTextbox.clear();
        commonPage.wait(getDriver(), 1);
        commonPage.sendKeysOnElement(projectLocationTextbox, "editLocation");
        commonPage.wait(getDriver(), 1);
        requestExtensionBtn.click();
        commonPage.wait(getDriver(), 2);
        if(requestExtensionInfo.getText().contains("Extension Requested")){
            System.out.println("Reqest extension succeed,test pass!");
        }
        else
            Assert.fail("Reqest extension get error,test fail!");
        //modify items/services tab info
        inputItemsServicesTabInfo("edit","edit","20","kg");
        //modify attachment tab info
        commonPage.wait(getDriver(), 2);
        addendumSaveBtn.click();
        commonPage.wait(getDriver(), 2);
        getDriver().navigate().refresh();
        commonPage.wait(getDriver(), 5);
        submitAddendumBtn.click();
        commonPage.wait(getDriver(), 2);
        chooseApproveDropdown.click();
        commonPage.wait(getDriver(), 2);
        approveDropdownItem.click();
        commonPage.wait(getDriver(), 1);
        find(By.xpath(".//*[@id='chooseApprModal']/div[2]/button[2]")).click();
        commonPage.wait(getDriver(), 2);
        if(extensionRequestLable.getText().contains("Yes")&&locationLable.getText().contains("edit")){
            System.out.println("Tender addendum update info succeed,test pass!");
        }
        else
            Assert.fail("Tender addendum update info get error,test fail!");
        commonPage.wait(getDriver(), 2);
        addendumSubmitBtn.click();
        commonPage.wait(getDriver(), 2);
        if (sendForApproveInfo.getText().contains("Your tender has been sent for approval, Stay tuned")) {
            System.out.println("Send tender for approve succeed, test pass!");
            sendForApproveInfo.click();
            Actions action = new Actions(getDriver());
            action.sendKeys(Keys.TAB).perform();
            commonPage.wait(getDriver(), 1);
            action.sendKeys(Keys.ENTER).perform();
            commonPage.wait(getDriver(), 2);
        } else
            Assert.fail("Send tender for approve get error, test fail!");
    }

}
