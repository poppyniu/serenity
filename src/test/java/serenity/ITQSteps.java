package serenity;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;
import pages.ITQPage;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class ITQSteps {
    ITQPage itqPage;

    @Step
    public void click_create_itq() throws Exception {
        itqPage.clickCreateITQ();
    }

    @Step
    public void preview_and_issue_itq() throws Exception {
        itqPage.previewIssueITQ();
    }


}
