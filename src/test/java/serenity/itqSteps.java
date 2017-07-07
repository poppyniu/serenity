package serenity;

import net.thucydides.core.annotations.Step;
import pages.itqPage;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class itqSteps {
    itqPage itqpage;

    @Step
    public void create_new_itq() throws Exception {
        itqpage.createITQ();
    }

    @Step
    public void navigate_create_itq() throws Exception {
        itqpage.navigateCreateITQ();
    }

    @Step
    public void select_dropdownlist() throws Exception {
        itqpage.selectDropdown();
    }


}
