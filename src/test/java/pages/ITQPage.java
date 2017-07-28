package pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
//@DefaultUrl("http://10.22.17.96/")
public class ITQPage extends PageObject {
    CommonPage commonPage;
    DashboardPage dashboardPage;

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

}
