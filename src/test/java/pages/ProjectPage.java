package pages;

import constants.DBHelper;
import constants.TestAccountsConstants;
import constants.TestDataPathConstants;
import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
//@DefaultUrl("http://10.22.17.96/")
public class ProjectPage extends PageObject {
    String testDataPath = System.getProperty("testdata");
    CommonPage commonPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    String currentUrl;
    @FindBy(xpath = ".//*[@id='tab-1-label']")
    WebElement addDocTab;
    @FindBy(xpath = ".//*[@id='project-documents-documents-add']")
    WebElement addDocTypeBtn;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/table/tbody/tr[1]/td[2]/div/i[2]")
    WebElement addDocTypeBtn1;
    @FindBy(xpath = ".//*[@id='confirm-create-container']/table/tbody/tr[3]/td[2]/div/i[2]")
    WebElement addDocTypeBtn2;
    @FindBy(xpath = ".//*[@class='row align-spaced action-buttons']//button[2]")
    WebElement addDocTypeBtn3;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/div/div/button")
    WebElement inviteBtn;
    @FindBy(xpath = ".//*[@id='project-detail-invite-vendor']/div[4]/div/button")
    WebElement inviteBtn1;
    @FindBy(xpath = ".//*[@id='project-detail-invite-success']/div[4]/div/button")
    WebElement inviteOkBtn;
    @FindBy(xpath = ".//*[@id='mini-toastr']/div/div")
    WebElement successInfo;
    @FindBy(xpath = ".//*[@id='tab-0']/div/div/div[1]/button")
    WebElement submissionBtn;
    @FindBy(xpath = ".//*[@id='sr-completionType-partial']")
    WebElement partialRadioBtn;
    @FindBy(xpath = ".//*[@id='sr-completionType-full']")
    WebElement fullRadioBtn;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[2]/div/div[1]/span/i")
    WebElement completeOnBtn;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[2]/div/div[2]/div[2]/span[15]")
    WebElement calenderItem;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[3]/div/div/textarea")
    WebElement itemsServiceTextBox;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[4]/div/div[3]/div[2]/div/input")
    WebElement amountTextbox;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[6]/div[1]/div/div/textarea")
    WebElement personTextBox;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[6]/div[2]/div/div/textarea")
    WebElement positionTextBox;
    @FindBy(xpath = ".//*[@id='project-sr-accordion-0']/div/div/button[1]")
    WebElement submitBtn;
    @FindBy(xpath = ".//*[@id='project-sr-accordion-0']/div/div[8]/div[1]/a[2]")
    WebElement approveBtn;
    @FindBy(xpath = ".//*[@id='project-sr-accordion-0']/div/div[8]/div[1]/a[1]")
    WebElement rejectBtn;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[3]/div/div[1]/table/tbody/tr[1]/td[3]/span")
    WebElement projectStatus;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[3]/div/div[1]/table/tbody/tr/td[4]")
    WebElement projectCompletion;
    @FindBy(xpath = ".//*[@id='sr-completionType-final-partial']")
    WebElement finalPartialCheckbox;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]/div[1]/span")
    WebElement uploadDocRemindInfo;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]/div[2]/button")
    WebElement uploadDocRemindInfoYesBtn;
    @FindBy(xpath = ".//*[@id='tab-1-label']")
    WebElement documentTab;
    //    @FindBy(xpath = ".//body/input[@type='file'][4]")
//    WebElement uploadFileTextbox;
    @FindBy(xpath = ".//*[@class='project-documents-accordion-container']/div/ul/li[1]/div[2]/div[2]/table/tbody/tr/td[2]/a")
    WebElement uploadedFileName1;
    @FindBy(xpath = ".//*[@class='project-documents-accordion-container']/div/ul/li[2]/div[2]/div[2]/table/tbody/tr/td[2]/a")
    WebElement uploadedFileName2;
    @FindBy(xpath = ".//*[@id='project-docs-accordion-1-label']/div/div/span")
    WebElement secondDocType;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]/div[1]/span")
    WebElement approveDocRemindInfo;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]/div[2]/button")
    WebElement approveDocRemindInfoOkBtn;
    @FindBy(xpath = ".//*[@class='project-documents-accordion-container']/div/ul/li[1]/div[3]/div/div/div/div/a[2]")
    WebElement approveDocBtn1;
    @FindBy(xpath = ".//*[@class='project-documents-accordion-container']/div/ul/li[2]/div[3]/div/div/div/div/a[2]")
    WebElement approveDocBtn2;
    @FindBy(xpath = ".//*[@id='project-docs-accordion']/li[2]/a/div/div")
    WebElement docTwoPanel;
    @FindBy(xpath = ".//*[@id='alertModal']/div[2]/button[2]")
    WebElement approveDocYesBtn;
    @FindBy(xpath = ".//*[@id='tab-0-label']")
    WebElement sumissionRequestTab;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]/div[1]/textarea")
    WebElement rejectTextbox;
    @FindBy(xpath = "//div[contains(@style,'block')]/div/a[text()='Reject']")
    WebElement rejectWindowRejectBtn;
    @FindBy(xpath = ".//*[@id='project-sr-accordion-0-label']/div/div/label")
    WebElement rejectByLable;
    @FindBy(xpath = ".//*[@id='project-sr-accordion-0-label']/div/div/pre/p")
    WebElement rejectByName;
    @FindBy(xpath = ".//*[@id='submission-request-form']/div/div[4]/div/div[4]/label[1]")
    WebElement remainText;
    @FindBy(xpath = ".//*[@id='project-sr-dotted-dropdown-0']/li/i")
    WebElement requestChangeDropDown;
    @FindBy(xpath = ".//*[@id='project-sr-dotted-dropdown-0']/li/ul/li/div")
    WebElement requestChangeDropDownItem;
    @FindBy(xpath = ".//*[@id='project-sr-request-change-modal']/div[4]/div/button")
    WebElement requestChangeYesContinue;




    public void createProject(String poNo) throws Exception {
        dashboardPage.clickCreateProject(poNo);
        //add doc type
        addDocTab.click();
        commonPage.wait(getDriver(), 2);
        addDocTypeBtn.click();
        commonPage.wait(getDriver(), 2);
        addDocTypeBtn1.click();
//        commonPage.wait(getDriver(), 1);
//        addDocTypeBtn2.click();
        commonPage.wait(getDriver(), 1);
        addDocTypeBtn3.click();
        commonPage.wait(getDriver(), 2);
        inviteBtn.click();
        commonPage.wait(getDriver(), 2);
        inviteBtn1.click();
        commonPage.wait(getDriver(), 5);
        inviteOkBtn.click();
        commonPage.wait(getDriver(), 2);
        if(dashboardPage.projectItem80070962.getText().contains("80070962")){
            System.out.println("Create project succeed, test pass!");
        }
        else
            System.out.println("Create project get error, test fail!");
    }

    public void createProject1(String poNo) throws Exception {
        dashboardPage.clickCreateProject(poNo);
    }

    public void firstSubmission(String amount) throws Exception {
        partialOrFullSubmission(amount, "partial", false
        );
        checkSucceed("Partial submission");
    }

    public void engineerApproveSubmission() throws Exception {
        engineerLoginApproveOrReject("approve");
        checkProjectStatus("1st");
        checkProjectCompletion("26.88%");

    }

    public void secondSubmission(String amount1) throws Exception {
        partialOrFullSubmission(amount1, "partial", false);
        checkSucceed("Partial submission");
    }

    public void engineerApproveSecondSubmission() throws Exception {
        engineerLoginApproveOrReject("approve");
        checkProjectStatus("2nd");
        checkProjectCompletion("67.20%");
    }

    public void thirdFinalSubmission(String amount2) throws Exception {
        partialOrFullSubmission(amount2, "partial", true);
    }

    public void checkUploadDocInfo() throws Exception {
        if (uploadDocRemindInfo.getText().contains("Please upload all required documents to proceed to submission")) {
            System.out.println("Final submission do not upload docs, see the remind info,test pass!");
        } else
            Assert.fail("Do not see the upload doc remind info,test fail!");
        commonPage.wait(getDriver(), 2);
        uploadDocRemindInfoYesBtn.click();
        commonPage.wait(getDriver(), 2);
    }

    public void uploadDocsAndSubmit() throws Exception {
        commonPage.scrollToElement(documentTab);
        documentTab.click();
        commonPage.wait(getDriver(), 2);
//        commonPage.scrollToElement(secondDocType);
//        secondDocType.click();
        //upload first file
        commonPage.wait(getDriver(), 2);
        uploadDoc();
//        uploadDoc2();
        //resubmit final submission
        commonPage.scrollToElement(sumissionRequestTab);
        sumissionRequestTab.click();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(submitBtn);
        submitBtn.click();
        commonPage.wait(getDriver(), 1);
        checkSucceed("Submission");
    }

    public void uploadDoc() throws Exception {
        int uploadFileCount = getDriver().findElements(By.xpath(".//body/input[@type='file']")).size();
        System.out.println("1111111111111111111"+uploadFileCount);
        for (int i = 1; i <= uploadFileCount; i++) {
            WebElement uploadFileElement = getDriver().findElements(By.xpath(".//body/input[@type='file'][" + i + "]")).get(0);
            JavascriptExecutor removeAttribute = (JavascriptExecutor) getDriver();
            removeAttribute.executeScript("arguments[0].removeAttribute('style');", uploadFileElement);
            commonPage.wait(getDriver(), 2);
            WebElement uploadFileTextbox = getDriver().findElement(By.xpath(".//body/input[@type='file'][" + i + "]"));
            if (testDataPath == null) {
                testDataPath = TestDataPathConstants.uploadFilePath;
            }
            uploadFileTextbox.sendKeys(testDataPath);
            commonPage.wait(getDriver(), 4);
            boolean uploadFileExist = commonPage.isContentAppeared(getDriver(), "test.jpg");
            if (uploadFileExist == true) {
                System.out.println("Upload first file succeed,test pass!");
                break;
            }
        }
    }

    public void uploadDoc2() throws Exception {
        int uploadFileCount = getDriver().findElements(By.xpath(".//body/input[@type='file']")).size();
        WebElement uploadFileElement = getDriver().findElements(By.xpath(".//body/input[@type='file'][6]")).get(0);
        JavascriptExecutor removeAttribute = (JavascriptExecutor) getDriver();
        removeAttribute.executeScript("arguments[0].removeAttribute('style');", uploadFileElement);
        commonPage.wait(getDriver(), 2);
        WebElement uploadFileTextbox = getDriver().findElement(By.xpath(".//body/input[@type='file'][6]"));
        if (testDataPath == null) {
            testDataPath = TestDataPathConstants.uploadFilePath;
        }
        uploadFileTextbox.sendKeys(testDataPath);
        commonPage.wait(getDriver(), 4);
        boolean uploadFileExist = commonPage.isContentAppeared(getDriver(), "test.jpg");
        if (uploadFileExist == true) {
            System.out.println("Upload first file succeed,test pass!");
        }
    }

    public void engineerApproveThirdSubmission() throws Exception {
        engineerLoginOpenProjectItem();
        commonPage.scrollToElement(approveBtn);
        approveBtn.click();
        commonPage.wait(getDriver(), 1);
    }

    public void remindApproveDoc() throws Exception {
        if (commonPage.elementExist(approveDocRemindInfo)) {
            System.out.println("Final approve do not upload docs, see the remind info,test pass!");
        } else
            Assert.fail("Do not see the approve doc remind info,test fail!");
        commonPage.wait(getDriver(), 2);
        approveDocRemindInfoOkBtn.click();
        commonPage.wait(getDriver(), 2);
    }

    public void approveDocCheckStatus() throws Exception {
        commonPage.scrollToElement(documentTab);
        documentTab.click();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(approveDocBtn1);
        approveDocBtn1.click();
        commonPage.wait(getDriver(), 2);
        approveDocYesBtn.click();
//        commonPage.scrollToElement(docTwoPanel);
//        docTwoPanel.click();
//        commonPage.wait(getDriver(), 2);
//        approveDocBtn2.click();
//        commonPage.wait(getDriver(), 2);
//        approveDocYesBtn.click();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(sumissionRequestTab);
        sumissionRequestTab.click();
        commonPage.wait(getDriver(), 2);
        commonPage.scrollToElement(approveBtn);
        approveBtn.click();
        commonPage.wait(getDriver(), 1);
        if (successInfo.getText().contains("Success")) {
            System.out.println("Engineer approve final submission succeed,test pass!");
        } else
            Assert.fail("Engineer approve final submission get error,test fail!");
        commonPage.wait(getDriver(), 3);
        commonPage.scrollToElement(dashboardPage.hkldLogo);
        dashboardPage.hkldLogo.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
        checkProjectStatus("3rd");
        checkProjectCompletion("80.65%");
    }

    public void checkProjectStatus(String expectedStatus) throws Exception {
        String autualStatus = projectStatus.getText();
        if (autualStatus.contains(expectedStatus)) {
            System.out.println("Current project status is:" + expectedStatus + ",test pass!");
        } else
            Assert.fail("Current project status is not correct,test fail!");
    }

    public void checkProjectCompletion(String expectedCompletion) throws Exception {
        String autualCompletion = projectCompletion.getText();
        if (autualCompletion.contains(expectedCompletion)) {
            System.out.println("Current project completion status is:" + expectedCompletion + ",test pass!");
        } else
            Assert.fail("Current project completion status is not correct,test fail!");
    }

    public void clearProjectTable(String poNo) throws Exception {
        DBHelper.clearProjectDataFromDB("projects",poNo);
    }

    public void fullSubmission(String amount) throws Exception {
        partialOrFullSubmission(amount, "full", false);
    }

    public void rejectSubmission() throws Exception {
        engineerLoginApproveOrReject("reject");
        commonPage.scrollToElement(rejectTextbox);
        rejectTextbox.click();
//        rejectTextbox.sendKeys(TestDataPathConstants.testInfo);
        Actions actions =new Actions(getDriver());
        actions.sendKeys(Keys.SPACE).perform();
        actions.sendKeys("aaa").perform();
        commonPage.wait(getDriver(), 1);
        actions.sendKeys(Keys.TAB).perform();
        commonPage.scrollToElement(rejectWindowRejectBtn);
        rejectWindowRejectBtn.click();
        commonPage.wait(getDriver(), 1);
        checkSucceed("Reject submission");
    }

    public void vendorCheckProjectStatus() throws Exception {
        contractorLoginOpenProjectItem();
        if(rejectByLable.getText().contains("REJECTED BY")&&rejectByName.getText().contains("sophie"))
        {
            System.out.println("The project is rejected,test pass!");
        }
        else
            Assert.fail("The project is not rejected,test fail!");
    }

    public void vendorCheckAmount(String amount) throws Exception {
        contractorLoginOpenProjectItem();
        submissionBtn.click();
        commonPage.wait(getDriver(), 2);
        amountTextbox.clear();
        commonPage.scrollToElement(amountTextbox);
        commonPage.sendKeysOnElement(amountTextbox, amount);
        commonPage.wait(getDriver(), 2);
        itemsServiceTextBox.click();
        if(remainText.getText().contains("5,440")){
            System.out.println("The amount function works well,test pass!");
        }
        else
            Assert.fail("The amount function does not work well,test fail!");
    }

    public void partialOrFullSubmission(String amount, String type, Boolean partialFinal) throws Exception {
        contractorLoginOpenProjectItem();
        submissionBtn.click();
        commonPage.wait(getDriver(), 2);
        if (type.contains("partial") && partialFinal.booleanValue() == false) {
            partialRadioBtn.click();
        } else if (type.contains("partial") && partialFinal.booleanValue() == true) {
            partialRadioBtn.click();
            commonPage.wait(getDriver(), 1);
            finalPartialCheckbox.click();
            commonPage.wait(getDriver(), 1);
        } else if (type.contains("full")) {
            fullRadioBtn.click();
        }
        commonPage.wait(getDriver(), 1);
        completeOnBtn.click();
        commonPage.wait(getDriver(), 2);
        calenderItem.click();
        commonPage.sendKeysOnElement(itemsServiceTextBox, TestDataPathConstants.testInfo);
        amountTextbox.clear();
        commonPage.sendKeysOnElement(amountTextbox, amount);
        commonPage.scrollToElement(personTextBox);
        commonPage.sendKeysOnElement(personTextBox, TestDataPathConstants.testInfo);
        commonPage.scrollToElement(positionTextBox);
        commonPage.sendKeysOnElement(positionTextBox, TestDataPathConstants.testInfo);
        submitBtn.click();
        commonPage.wait(getDriver(), 1);
    }

    public void checkSucceed(String info) throws Exception {
        if (successInfo.getText().contains("Success")) {
            System.out.println(info+" succeed,test pass!");
        } else
            Assert.fail(info+" get error,test fail!");
    }

    private void engineerLoginApproveOrReject(String type) throws Exception {
        engineerLoginOpenProjectItem();
        if(type.contains("approve")) {
            commonPage.scrollToElement(approveBtn);
            approveBtn.click();
            commonPage.wait(getDriver(), 1);
            if (successInfo.getText().contains("Success")) {
                System.out.println("Engineer approve submission succeed,test pass!");
            } else
                Assert.fail("Engineer approve submission get error,test fail!");
            commonPage.wait(getDriver(), 3);
            commonPage.scrollToElement(dashboardPage.hkldLogo);
            dashboardPage.hkldLogo.click();
            commonPage.wait(getDriver(), 2);
            currentUrl = getDriver().getCurrentUrl();
            commonPage.navigatePage(currentUrl);
            commonPage.wait(getDriver(), 2);
        }
        else if(type.contains("reject")) {
            commonPage.scrollToElement(rejectBtn);
            rejectBtn.click();
            commonPage.wait(getDriver(), 3);
        }
    }

    private void contractorLoginOpenProjectItem() throws Exception{
        getDriver().get(URLConstants.contractorLoginPage);
        commonPage.wait(getDriver(), 2);
        loginPage.Login(TestAccountsConstants.contractorName, TestAccountsConstants.contractorPwd);
        dashboardPage.projectItem80070962.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 3);
    }

    private void engineerLoginOpenProjectItem() throws Exception{
        getDriver().get(URLConstants.hkldLoginPage);
        commonPage.wait(getDriver(), 2);
        loginPage.Login(TestAccountsConstants.hkldUserName1, TestAccountsConstants.contractorPwd);
        dashboardPage.engineerProjectItemOne.click();
        commonPage.wait(getDriver(), 2);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 2);
    }

    public void poValidation() throws Exception{
        dashboardPage.hkldLogo.click();
        commonPage.wait(getDriver(), 2);
        getDriver().navigate().refresh();
        commonPage.wait(getDriver(), 5);
        dashboardPage.createProjectBtn.click();
        commonPage.wait(getDriver(), 2);
        commonPage.sendKeysOnElement(dashboardPage.poNoTextbox,"333");
        dashboardPage.addPoNoBtn.click();
        commonPage.wait(getDriver(), 6);
        dashboardPage.checkPoValidationInfo("Invalid PO Number, please input another PO Number");
        inputPo("80070962");
        dashboardPage.checkPoValidationInfo("Duplicate PO Number, please input another PO Number");
        inputPo("80055582");
        dashboardPage.checkPoValidationInfo("You are not allowed to view this PO, please input another PO number");
    }

    private void inputPo(String poNumber) throws Exception{
        dashboardPage.poNoTextbox.clear();
        commonPage.sendKeysOnElement(dashboardPage.poNoTextbox,poNumber);
        dashboardPage.addPoNoBtn.click();
        commonPage.wait(getDriver(), 2);
        dashboardPage.addPoNoBtn.click();
        commonPage.wait(getDriver(), 3);
    }

    public void poRequestChange() throws Exception{
        commonPage.wait(getDriver(), 2);
        dashboardPage.projectItem80070962.click();
        commonPage.wait(getDriver(), 3);
        requestChangeDropDown.click();
        commonPage.wait(getDriver(), 2);
        requestChangeDropDownItem.click();
        commonPage.wait(getDriver(), 2);
        requestChangeYesContinue.click();
        commonPage.wait(getDriver(), 1);
        checkSucceed("Request change") ;
    }

    public void vendorCheckCanEditSubmission() throws Exception{
        contractorLoginOpenProjectItem();
        //can do the submission directly without re-input
        commonPage.scrollToElement(positionTextBox);
        positionTextBox.clear();
        commonPage.sendKeysOnElement(positionTextBox, "edit");
        submitBtn.click();
        commonPage.wait(getDriver(), 1);
        checkSucceed("After change request do the re-submission") ;
    }

}
