package serenity;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.DashboardPage;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardPageSteps {
    DashboardPage dashboardPage;

    @Step
    public void click_humburgerIcon(){
        dashboardPage.clickHamburgerIcon();
    }

    @Step
    public void click_settingLink(){
        dashboardPage.clickSettingLink();
    }

    @Step
    public void checkSettingLinkVisible(String expected){
        switch (expected){
            case "is":
                Assert.assertTrue(dashboardPage.settingLinkVisible());
                break;
            case "is not":
                Assert.assertFalse(dashboardPage.settingLinkVisible());
                break;
        }
    }

    @Step
    public void click_HKLDLogo(){
        dashboardPage.clickHKLDLogo();
    }

}
