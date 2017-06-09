package serenity;

import net.thucydides.core.annotations.Step;
import pages.CommonPage;
import pages.poppytest1Page;

/**
 * Created by Poppy_Zhang on 2017/6/7.
 */
public class poppytest1Steps {
    poppytest1Page poppytest1Page;

    @Step
    public void opens_home_page() {
        poppytest1Page.open();
    }

    @Step
    public void check_logo() {
        poppytest1Page.elementExist();
        //CommonPage.elementExist();
    }

    @Step
    public void close_browser(){
        poppytest1Page.getDriver().quit();
    }

    @Step
    public void click_link(){
        poppytest1Page.clickElement();
    }

    @Step
    public void navigate_page()
            throws Exception {
        {
            poppytest1Page.navigatePage();
        }
    }
}
