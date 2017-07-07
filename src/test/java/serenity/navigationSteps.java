package serenity;

import net.thucydides.core.annotations.Step;
import pages.navigationPage;

/**
 * Created by Poppy_Zhang on 2017/6/14.
 */
public class navigationSteps {
    navigationPage navigationPage;
    @Step
    public void opens_home_page() {
        navigationPage.open();
    }

    @Step
    public void clickHamburger() throws Exception{
        navigationPage.clickHamburger();
    }

    @Step
    public void navigateITQTenders() throws Exception{
        navigationPage.navigateITQTenders();
    }
}
