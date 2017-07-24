package pages;

import constants.DBHelper;
import constants.TestAccountsConstants;
import constants.TestDataPathConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.jruby.RubyProcess;
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
public class tenderPage extends PageObject {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;
    String testDataPath = System.getProperty("testdata");
    CommonPage commonPage;
    dashboardPage dashboardPage;

    @FindBy(xpath="html/body/div[1]/div[2]/div[1]/div/div[3]/div[2]/a[2]")
    WebElement saveBtn;
    //General tab elements
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[1]/div[@class='multiselect__select']")
    WebElement WorkingHoursDropdown1;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[2]/div[@class='multiselect__select']")
    WebElement WorkingHoursDropdown2;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[3]/div[@class='multiselect__select']")
    WebElement WorkingHoursDropdown3;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[4]/div[@class='multiselect__select']")
    WebElement WorkingHoursDropdown4;
    @FindBy(xpath = "//div[contains(@id,'workingHours')]/div[contains(@id,'add')]/div[1]/ul/li/span/span[contains(text(),'Friday')]")
    WebElement WorkingHoursDropdown1Item1;
    @FindBy(xpath=".//*[@id='tender.general.projectDescription']")
    WebElement ProjectDescriptionTextbox;
    @FindBy(xpath=".//*[@id='tender.general.projectLocation']")
    WebElement ProjectLocationTextbox;
    @FindBy(xpath=".//*[@id='tender.general.projectStart']")
    WebElement TentativeProjectStartTextbox;
    @FindBy(xpath=".//*[@id='tender.general.estimatedProjectDuration']")
    WebElement ProjectDurationTextbox;
    @FindBy(xpath=".//*[@id='modules-tenders-edit-general-working-hour-add']")
    WebElement AddWorkingHoursBtn;
    @FindBy(xpath=".//*[@id='tender.general.validityPeriod']")
    WebElement PeriodTextbox;
    @FindBy(xpath=".//*[@id='tender.general.prNo']")
    WebElement PRNumberTextbox;
    @FindBy(xpath="//a[contains(@id,'modules-tenders-edit-general-pr-add')][text()='Add']")
    WebElement PRNumberAddBtn;
    @FindBy(xpath=".//*[@id='tender.general.contractData.save']")
    WebElement PRNumberInfoSaveBtn;
    //ScopeOfWork tab elements
    @FindBy(xpath=".//*[@id='tab-scope-label']")
    WebElement ScopeOfWorkTab;
    @FindBy(xpath=".//*[@id='tinymce']")
    WebElement ScopeOfWorkTextBox;
    @FindBy(xpath=".//iframe[@id='generalDesc_ifr']")
    WebElement ScopeOfWorkFreame1;
    @FindBy(xpath=".//iframe[@id='generalSpec_ifr']")
    WebElement ScopeOfWorkFreame2;
    @FindBy(xpath=".//iframe[@id='particularDesc_ifr']")
    WebElement ScopeOfWorkFreame3;
    //Items Services tab elements
    @FindBy(xpath=".//*[@id='tab-services-label']")
    WebElement ItemsServicesTab;
    @FindBy(xpath=".//*[@id='tender.section.title_0']")
    WebElement AddSectionTitleTextbox;
    @FindBy(xpath=".//*[@id='line.desc_0_0']")
    WebElement AddDescriptionTextbox;
    @FindBy(xpath=".//*[@id='line.qty_0_0']")
    WebElement AddQTYTextbox;
    @FindBy(xpath=".//*[@id='line.unit_0_0']/div[1]/div[1]")
    WebElement UnitDropdown;
    @FindBy(xpath=".//*[@id='line.unit_0_0']/div[1]/ul/li[3]/span/span")
    WebElement UnitDropdownItem;
    //Attachments tab elements
    @FindBy(xpath=".//*[@id='tab-attachment-label']")
    WebElement AttachmentsTab;
    @FindBy(xpath=".//*[@id='dropzone']/div/img")
    WebElement UploadAttachmentBtn;
    @FindBy(xpath=".//input[@type='file']")
    WebElement UploadFileTextbox;
    @FindBy(xpath=".//*[@id='attachment-desc-form']/textarea")
    WebElement AttachmentDescription;
    @FindBy(xpath=".//*[@id='fileupload']/table/tbody/tr/td[2]/a")
    WebElement UploadedFileName;
    @FindBy(xpath=".//*[@id='mini-toastr']/div/div")
    WebElement SaveSuccessInfo;


    public void clickCreateTender() throws Exception {
        Thread.sleep(2000);
        dashboardPage.CreateTenderBtn.click();
        Thread.sleep(2000);
        dashboardPage.SelectTypeDropdown.click();
        Thread.sleep(1000);
        dashboardPage.SelectTypeDropdown.click();
        Thread.sleep(2000);
        dashboardPage.SelectTypeDropdownItemTender.click();
        Thread.sleep(2000);
        dashboardPage.SelectTypeEnterBtn.click();
        Thread.sleep(3000);
        String currentUrl = getDriver().getCurrentUrl();
        Thread.sleep(2000);
        commonPage.navigatePage(currentUrl);
        Thread.sleep(3000);
    }

    public void inputGeneralTabInfo(String Description, String Location, String ProjectStart, String Duration, String WorkingHours1, String WorkingHours2, String WorkingHours3, String WorkingHours4, String Period, String Retention, String DefectsLiabilityPeriod, String LiquidatedDamages, String SuretyBond, String PRNumber) throws Exception {
//        ProjectDescriptionTextbox.sendKeys(Description);
        commonPage.sendKeysOnElement(ProjectDescriptionTextbox,Description);
        Thread.sleep(1000);
//       ProjectLocationTextbox.sendKeys(Location);
        commonPage.sendKeysOnElement(ProjectLocationTextbox,Location);
        Thread.sleep(1000);
//        TentativeProjectStartTextbox.sendKeys(ProjectStart);
        commonPage.sendKeysOnElement(TentativeProjectStartTextbox,ProjectStart);
        Thread.sleep(1000);
//        ProjectDurationTextbox.sendKeys(Duration);
        commonPage.sendKeysOnElement(ProjectDurationTextbox,Duration);
        Thread.sleep(1000);
        //select working hours dropdown1
        WorkingHoursDropdown1.click();
        Thread.sleep(2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(1,WorkingHours1);
        //select working hours dropdown2
        WorkingHoursDropdown2.click();
        Thread.sleep(2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(2,WorkingHours2);
        Thread.sleep(2000);
        WorkingHoursDropdown3.click();
        Thread.sleep(2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(3,WorkingHours3);
        WorkingHoursDropdown4.click();
        Thread.sleep(2000);
        commonPage.selectWorkingHoursDrodownByItemAndNumber(4,WorkingHours4);
        Thread.sleep(3000);
        AddWorkingHoursBtn.click();
        Thread.sleep(1000);
        PeriodTextbox.clear();
//        PeriodTextbox.sendKeys(Period);
        commonPage.sendKeysOnElement(PeriodTextbox,Period);
        Thread.sleep(1000);
//        PRNumberTextbox.sendKeys(PRNumber);
        commonPage.sendKeysOnElement(PRNumberTextbox,PRNumber);
        Thread.sleep(2000);
        PRNumberAddBtn.click();
        Thread.sleep(2000);
        PRNumberInfoSaveBtn.click();
        Thread.sleep(2000);
    }

    public void inputScopeOfWorkTabInfo(String GeneralDescriptionofWork, String GeneralSpecifications, String ParticularSpecifications) throws Exception {
        ScopeOfWorkTab.click();
        Thread.sleep(2000);
        getDriver().switchTo().frame(ScopeOfWorkFreame1);
        Thread.sleep(2000);
        ScopeOfWorkTextBox.click();
        ScopeOfWorkTextBox.sendKeys(GeneralDescriptionofWork);
        getDriver().switchTo().defaultContent();
        Thread.sleep(2000);
        getDriver().switchTo().frame(ScopeOfWorkFreame2);
        Thread.sleep(2000);
        ScopeOfWorkTextBox.click();
        ScopeOfWorkTextBox.sendKeys(GeneralSpecifications);
        getDriver().switchTo().defaultContent();
        Thread.sleep(2000);
        getDriver().switchTo().frame(ScopeOfWorkFreame3);
        Thread.sleep(2000);
        ScopeOfWorkTextBox.click();
        ScopeOfWorkTextBox.sendKeys(ParticularSpecifications);
        Thread.sleep(1000);
        Actions actions=new Actions(getDriver());
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        Thread.sleep(2000);
        getDriver().switchTo().defaultContent();
        Thread.sleep(3000);
    }

    public void inputItemsServicesTabInfo(String SectionTitle1, String DescriptionofWork1,String QTY1,String UNIT1) throws Exception {
        ItemsServicesTab.click();
        Thread.sleep(2000);
//        AddSectionTitleTextbox.sendKeys(SectionTitle1);
        commonPage.sendKeysOnElement(AddSectionTitleTextbox,SectionTitle1);
        Thread.sleep(2000);
        AddDescriptionTextbox.clear();
//        AddDescriptionTextbox.sendKeys(DescriptionofWork1);
        commonPage.sendKeysOnElement(AddDescriptionTextbox,DescriptionofWork1);
        Thread.sleep(2000);
        AddQTYTextbox.clear();
//        AddQTYTextbox.sendKeys(QTY1);
        commonPage.sendKeysOnElement(AddQTYTextbox,QTY1);
        Thread.sleep(1000);
        UnitDropdown.click();
        Thread.sleep(2000);
        UnitDropdownItem.click();
    }

    public void inputAttachmentsTabInfo(String ProjectDescription) throws Exception {
        AttachmentsTab.click();
        Thread.sleep(2000);
        commonPage.sendKeysOnElement(AttachmentDescription,ProjectDescription);
        Thread.sleep(1000);
        //Upload file：
        WebElement uploadFileElement = getDriver().findElements(By.xpath("//input[@type='file']")).get(0);
        JavascriptExecutor removeAttribute = (JavascriptExecutor)getDriver();
        removeAttribute.executeScript("arguments[0].removeAttribute('style');", uploadFileElement);
        Thread.sleep(2000);
        if(testDataPath==null)
        {
            testDataPath= TestDataPathConstants.UploadFilePath;
        }
        UploadFileTextbox.sendKeys(testDataPath);
        Thread.sleep(4000);
        boolean uploadFileExist=commonPage.elementExist(UploadedFileName);
        if(uploadFileExist==true){
            System.out.println("Upload file succeed,test pass!");
        }
        else
            System.out.println("Upload file get error,test fail!");
        saveBtn.click();
        Thread.sleep(1000);
        if(SaveSuccessInfo.getText().contains("Success")){
            System.out.println("Save succeed,test pass!");
        }
        else
            System.out.println("Save get error,test fail!");
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
