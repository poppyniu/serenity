package serenity;

import net.thucydides.core.annotations.Step;
import pages.DashboardPage;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardPageSteps {
    DashboardPage dashboardPage;

    @Step
    public void click_settingLink(){
        dashboardPage.clickSettingLink();
    }

}
