package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
//@DefaultUrl("http://10.22.17.96/")
public class ITQPage extends PageObject {
    CommonPage commonPage;
    DashboardPage dashboardPage;
    TenderPage tenderPage;
    String currentUrl;
    @FindBy(xpath=".//div[contains(@class, 'tender-view-button-bar')]/div/a[2]")
    WebElement itqIssueBtn;

    public void clickCreateITQ() throws Exception {
        //bug exist can not use this function
       // dashboardPage.selectCreateTenderDropdown("itq");
        commonPage.wait(getDriver(),2);
        dashboardPage.createTenderBtn.click();
        commonPage.wait(getDriver(),2);
        commonPage.wait(getDriver(),2);
        dashboardPage.selectTypeEnterBtn.click();
        commonPage.wait(getDriver(),3);
        String currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3);
    }
    public void previewIssueITQ() throws Exception {
        commonPage.wait(getDriver(),2);
        tenderPage.previewSubmitBtn.click();
        commonPage.wait(getDriver(),1);
        if(tenderPage.saveSuccessInfo.getText().contains("Success")){
            System.out.println("Preview and submit succeed,test pass!");
        }
        else
            Assert.fail("Preview and submit get error,test fail!");
        currentUrl=getDriver().getCurrentUrl();
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),2);
        tenderPage.closingDateDropdown1.click();
        commonPage.wait(getDriver(),1);
        tenderPage.closingDateDropdown1LeftBtn.click();
        commonPage.wait(getDriver(),1);
        tenderPage.closingDateNextPageItem1.click();
        commonPage.wait(getDriver(),1);
        tenderPage.closingDateDropdown2.click();
        commonPage.wait(getDriver(),1);
        tenderPage.closingDateDropdown2item.click();
        commonPage.wait(getDriver(),1);
        itqIssueBtn.click();
        if(tenderPage.saveSuccessInfo.getText().contains("Success")){
            System.out.println("Engineer issue itq succeed,test pass!");
        }
        else
            Assert.fail("Engineer issue itq get error,test fail!");
        commonPage.wait(getDriver(), 5);
    }


}
