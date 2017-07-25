package serenity;

import net.thucydides.core.annotations.Step;
import pages.dashboardPage;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardPageSteps {
    dashboardPage dashboardPage;

    @Step
    public void click_settingLink(){
        dashboardPage.clickSettingLink();
    }

}
