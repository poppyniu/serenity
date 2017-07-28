package pages;

import constants.DBHelper;
import constants.TestAccountsConstants;
import constants.TestDataPathConstants;
import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Poppy_Zhang on 2017/7/19.
 */
public class TenderPage extends PageObject {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;
    String testDataPath = System.getProperty("testdata");
    String currentUrl;
    CommonPage commonPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @FindBy(xpath="html/body/div[1]/div[2]/div[1]/div/div[3]/div[2]/a[2]")
    WebElement saveBtn;
    //General tab elements
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[1]/div[@class='multiselect__select']")
    WebElement workingHoursDropdown1;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[2]/div[@class='multiselect__select']")
    WebElement workingHoursDropdown2;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[3]/div[@class='multiselect__select']")
    WebElement workingHoursDropdown3;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[4]/div[@class='multiselect__select']")
    WebElement workingHoursDropdown4;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[1]/ul/li/span/span[contains(text(),'Friday')]")
    WebElement workingHoursDropdown1Item1;
    @FindBy(xpath=".//*[@id='tender.general.projectDescription']")
    WebElement projectDescriptionTextbox;
    @FindBy(xpath=".//*[@id='tender.general.projectLocation']")
    WebElement projectLocationTextbox;
    @FindBy(xpath=".//*[@id='tender.general.projectStart']")
    WebElement tentativeProjectStartTextbox;
    @FindBy(xpath=".//*[@id='tender.general.estimatedProjectDuration']")
    WebElement projectDurationTextbox;
    @FindBy(xpath=".//*[@id='modules-tenders-edit-general-working-hour-add']")
    WebElement addWorkingHoursBtn;
    @FindBy(xpath=".//*[@id='tender.general.validityPeriod']")
    WebElement periodTextbox;
    @FindBy(xpath=".//*[@id='tender.general.prNo']")
    WebElement prNumberTextbox;
    @FindBy(xpath="//a[contains(@id,'modules-tenders-edit-general-pr-add')][text()='Add']")
    WebElement prNumberAddBtn;
    @FindBy(xpath=".//*[@id='tender.general.contractData.save']")
    WebElement prNumberInfoSaveBtn;
    //ScopeOfWork tab elements
    @FindBy(xpath=".//*[@id='tab-scope-label']")
    WebElement scopeOfWorkTab;
    @FindBy(xpath=".//*[@id='tinymce']")
    WebElement scopeOfWorkTextBox;
    @FindBy(xpath=".//iframe[@id='generalDesc_ifr']")
    WebElement scopeOfWorkFreame1;
    @FindBy(xpath=".//iframe[@id='generalSpec_ifr']")
    WebElement scopeOfWorkFreame2;
    @FindBy(xpath=".//iframe[@id='particularDesc_ifr']")
    WebElement scopeOfWorkFreame3;
    //Items Services tab elements
    @FindBy(xpath=".//*[@id='tab-services-label']")
    WebElement itemsServicesTab;
    @FindBy(xpath=".//*[@id='tender.section.title_0']")
    WebElement addSectionTitleTextbox;
    @FindBy(xpath=".//*[@id='line.desc_0_0']")
    WebElement addDescriptionTextbox;
    @FindBy(xpath=".//*[@id='line.qty_0_0']")
    WebElement addQTYTextbox;
    @FindBy(xpath=".//*[@id='line.unit_0_0']/div[1]/div[1]")
    WebElement unitDropdown;
    @FindBy(xpath=".//*[@id='line.unit_0_0']/div[1]/ul/li[3]/span/span")
    WebElement unitDropdownItem;
    //Attachments tab elements
    @FindBy(xpath=".//*[@id='tab-attachment-label']")
    WebElement attachmentsTab;
    @FindBy(xpath=".//*[@id='dropzone']/div/img")
    WebElement uploadAttachmentBtn;
    @FindBy(xpath=".//input[@type='file']")
    WebElement uploadFileTextbox;
    @FindBy(xpath=".//*[@id='attachment-desc-form']/textarea")
    WebElement attachmentDescription;
    @FindBy(xpath=".//*[@id='fileupload']/table/tbody/tr/td[2]/a")
    WebElement uploadedFileName;
    @FindBy(xpath=".//*[@id='mini-toastr']/div/div")
    WebElement saveSuccessInfo;
    @FindBy(xpath=".//*[@class='clearfix']/div[2]/a[3]")
    WebElement previewSubmitBtn;
    @FindBy(xpath=".//*[@id='submit_tender']")
    WebElement submitBtn;
    @FindBy(xpath=".//*[@class='reveal-overlay']/div/div[1]/div[2]/div[1]")
    WebElement chooseApproveDropdown;
    @FindBy(xpath=".//*[@class='reveal-overlay']/div/div[1]/div[2]/ul/li[1]/span/span")
    WebElement approveDropdownItem;
    @FindBy(xpath=".//*[@class='reveal-overlay']/div/div[2]/button[2]")
    WebElement chooseApproveEnterBtn;
    @FindBy(xpath=".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div/div[1]/p")
    WebElement sendForApproveInfo;
    @FindBy(xpath=".//*[@class='reveal-overlay']/div/div[2]/button[contains(text(),'Okay')]")
    WebElement sendForApproveEnterBtn;
    @FindBy(xpath=".//*[@class='tender-head-info columns clearfix']/div[3]/div[2]/a")
    WebElement adminApproveBtn;
    @FindBy(xpath=".//*[@class='tender-head-info columns clearfix']/div[3]/div[2]/a")
    WebElement engineerIssueBtn;
    @FindBy(xpath=".//*[@id='edit-closing-date-picker']/div[1]/div[1]/span/i")
    WebElement closingDateDropdown1;
    @FindBy(xpath=".//*[@id='edit-closing-date-picker']/div[1]/div[2]/div[1]/span[3]")
    WebElement closingDateDropdown1LeftBtn;
    @FindBy(xpath=".//*[@id='edit-closing-date-picker']/div[1]/div[2]/div[2]/span[15]")
    WebElement closingDateNextPageItem1;
    @FindBy(xpath=".//*[@id='edit-closing-date-picker']/div[2]/div[1]")
    WebElement closingDateDropdown2;
    @FindBy(xpath=" .//*[@id='edit-closing-date-picker']/div[2]/ul/li[2]/span/span")
    WebElement closingDateDropdown2item;





    public void clickCreateTender() throws Exception {
        dashboardPage.selectCreateTenderDropdown("tender");
    }

    public void inputGeneralTabInfo(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Exception {
        commonPage.sendKeysOnElement(projectDescriptionTextbox,Description);
        commonPage.wait(getDriver(),1000);
        commonPage.sendKeysOnElement(projectLocationTextbox,Location);
        commonPage.wait(getDriver(),1000);
        commonPage.sendKeysOnElement(tentativeProjectStartTextbox,ProjectStart);
        commonPage.wait(getDriver(),1000);
        commonPage.sendKeysOnElement(projectDurationTextbox,Duration);
        commonPage.wait(getDriver(),1000);
        //select working hours dropdown1
        workingHoursDropdown1.click();
        commonPage.wait(getDriver(),2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(1,WorkingHours1);
        //select working hours dropdown2
        workingHoursDropdown2.click();
        commonPage.wait(getDriver(),2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(2,WorkingHours2);
        commonPage.wait(getDriver(),2000);
        workingHoursDropdown3.click();
        commonPage.wait(getDriver(),2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(3,WorkingHours3);
        workingHoursDropdown4.click();
        commonPage.wait(getDriver(),2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(4,WorkingHours4);
        commonPage.wait(getDriver(),3000);
        addWorkingHoursBtn.click();
        commonPage.wait(getDriver(),1000);
        periodTextbox.clear();
        commonPage.sendKeysOnElement(periodTextbox,Period);
        commonPage.wait(getDriver(),1000);
        commonPage.sendKeysOnElement(prNumberTextbox,PRNumber);
        commonPage.wait(getDriver(),2000);
        prNumberAddBtn.click();
        commonPage.wait(getDriver(),2000);
        prNumberInfoSaveBtn.click();
        commonPage.wait(getDriver(),2000);
    }

    public void inputScopeOfWorkTabInfo(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Exception {
        scopeOfWorkTab.click();
        commonPage.wait(getDriver(),2000);
        getDriver().switchTo().frame(scopeOfWorkFreame1);
        commonPage.wait(getDriver(),2000);
        scopeOfWorkTextBox.click();
        scopeOfWorkTextBox.sendKeys(GeneralDescriptionofWork);
        getDriver().switchTo().defaultContent();
        commonPage.wait(getDriver(),2000);
        getDriver().switchTo().frame(scopeOfWorkFreame2);
        commonPage.wait(getDriver(),2000);
        scopeOfWorkTextBox.click();
        scopeOfWorkTextBox.sendKeys(GeneralSpecifications);
        getDriver().switchTo().defaultContent();
        commonPage.wait(getDriver(),2000);
        getDriver().switchTo().frame(scopeOfWorkFreame3);
        commonPage.wait(getDriver(),2000);
        scopeOfWorkTextBox.click();
        scopeOfWorkTextBox.sendKeys(ParticularSpecifications);
        commonPage.wait(getDriver(),1000);
        Actions actions=new Actions(getDriver());
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        commonPage.wait(getDriver(),2000);
        getDriver().switchTo().defaultContent();
        commonPage.wait(getDriver(),3000);
    }

    public void inputItemsServicesTabInfo(String SectionTitle1, String DescriptionofWork1,String QTY1,String UNIT1) throws Exception {
        itemsServicesTab.click();
        commonPage.wait(getDriver(),2000);
        commonPage.sendKeysOnElement(addSectionTitleTextbox,SectionTitle1);
        commonPage.wait(getDriver(),2000);
        addDescriptionTextbox.clear();
        commonPage.sendKeysOnElement(addDescriptionTextbox,DescriptionofWork1);
        commonPage.wait(getDriver(),2000);
        addQTYTextbox.clear();
        commonPage.sendKeysOnElement(addQTYTextbox,QTY1);
        commonPage.wait(getDriver(),1000);
        unitDropdown.click();
        commonPage.wait(getDriver(),2000);
        unitDropdownItem.click();
    }

    public void inputAttachmentsTabInfo(String ProjectDescription) throws Exception {
        attachmentsTab.click();
        commonPage.wait(getDriver(),2000);
        commonPage.sendKeysOnElement(attachmentDescription,ProjectDescription);
        commonPage.wait(getDriver(),1000);
        //Upload file：
        WebElement uploadFileElement = getDriver().findElements(By.xpath("//input[@type='file']")).get(0);
        JavascriptExecutor removeAttribute = (JavascriptExecutor)getDriver();
        removeAttribute.executeScript("arguments[0].removeAttribute('style');", uploadFileElement);
        commonPage.wait(getDriver(),2000);
        if(testDataPath==null)
        {
            testDataPath= TestDataPathConstants.uploadFilePath;
        }
        uploadFileTextbox.sendKeys(testDataPath);
        commonPage.wait(getDriver(),4000);
        boolean uploadFileExist=commonPage.elementExist(uploadedFileName);
        if(uploadFileExist==true){
            System.out.println("Upload file succeed,test pass!");
        }
        else
            System.out.println("Upload file get error,test fail!");
        saveBtn.click();
        commonPage.wait(getDriver(),1000);
        if(saveSuccessInfo.getText().contains("Success")){
            System.out.println("Save succeed,test pass!");
        }
        else
            System.out.println("Save get error,test fail!");
        commonPage.wait(getDriver(),5000);
    }

    public void submitTenderForApprove() throws Exception {
        dashboardPage.hkldLogo.click();
        commonPage.wait(getDriver(),2000);
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),2000);
        dashboardPage.itqTenderItemOne.click();
        commonPage.wait(getDriver(),2000);
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),2000);
        previewSubmitBtn.click();
        commonPage.wait(getDriver(),1000);
        commonPage.wait(getDriver(),1000);
        if(saveSuccessInfo.getText().contains("Success")){
            System.out.println("Preview and submit succeed,test pass!");
        }
        else
            System.out.println("Preview and submit get error,test fail!");
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),2000);
        submitBtn.click();
        commonPage.wait(getDriver(),2000);
        chooseApproveDropdown.click();
//        commonPage.wait(getDriver(),4000);
//        chooseApproveDropdown.click();
        commonPage.wait(getDriver(),2000);
        approveDropdownItem.click();
        commonPage.wait(getDriver(),1000);
        chooseApproveEnterBtn.click();
        commonPage.wait(getDriver(),2000);
        if(sendForApproveInfo.getText().contains("Your tender has been sent for approval, Stay tuned"))
        {
            System.out.println("Send tender for approve succeed, test pass!");
            sendForApproveInfo.click();
            Actions action=new Actions(getDriver());
            action.sendKeys(Keys.TAB).perform();
            commonPage.wait(getDriver(),1000);
            action.sendKeys(Keys.ENTER).perform();
            commonPage.wait(getDriver(),2000);
        }
        else
            System.out.println("Send tender for approve get error, test fail!");
    }

    public void adminApprove() throws Exception{
        getDriver().get(URLConstants.hkldLoginPage);
        commonPage.wait(getDriver(),2000);
        loginPage.Login(TestAccountsConstants.hkldAdmin,TestAccountsConstants.hkldUserPwd);
        dashboardPage.itqTenderItemOne.click();
        commonPage.wait(getDriver(),2000);
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),2000);
        adminApproveBtn.click();
        commonPage.wait(getDriver(),1000);
        if(saveSuccessInfo.getText().contains("Approve ITQ/Tender: Success")){
            System.out.println("Admin approve tender succeed,test pass!");
        }
        else
            System.out.println("Admin approve tender get error,test fail!");
    }

    public void engineerIssueTender() throws Exception{
        commonPage.navigatePage(URLConstants.hkldLoginPage);
        loginPage.Login(TestAccountsConstants.hkldUserName,TestAccountsConstants.hkldUserPwd);
        dashboardPage.itqTenderItemOne.click();
        commonPage.wait(getDriver(),2000);
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),2000);
        closingDateDropdown1.click();
        commonPage.wait(getDriver(),1000);
        closingDateDropdown1LeftBtn.click();
        commonPage.wait(getDriver(),1000);
        closingDateNextPageItem1.click();
        commonPage.wait(getDriver(),1000);
        closingDateDropdown2.click();
        commonPage.wait(getDriver(),1000);
        closingDateDropdown2item.click();
        commonPage.wait(getDriver(),1000);
        engineerIssueBtn.click();
        if(saveSuccessInfo.getText().contains("Issue ITQ/Tender: Success")){
            System.out.println("Engineer issue tender succeed,test pass!");
        }
        else
            System.out.println("Engineer issue tender get error,test fail!");
    }

    public void clearTenderFromDb() throws Exception {
        //SQL语句
        sql = "Delete from tenders where 1=1";
        //创建DBHelper对象
        db1 = new DBHelper(sql);
        try {
            //执行语句，得到结果集
           int result= db1.pst.executeUpdate();
           if(result==1) {
               System.out.println("Clear data in tenders table from database succeed, test pass!");
           }
           else
            System.out.println("Clear data in tenders table from database get error, test fail!");
            //关闭连接
            db1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
