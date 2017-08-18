package steps.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import serenity.ITQSteps;
import serenity.ProjectSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class ProjectStepDefinitions {
    @Steps
    ProjectSteps projectSteps;

    @And("^Create project with ([^\"]*) and add doc type and invite vendor$")
    public void create_project_with_and_add_doc_type_and_invite_vendor(String poNo) throws Throwable {
        projectSteps.create_project(poNo);
    }

    @And("^Vendor login to do the first partial submission ([^\"]*)$")
    public void vendor_login_to_do_the_first_partial_submission(String completionAmount) throws Throwable {
        projectSteps.first_submission(completionAmount);
    }

    @And("^Engineer approve the first partial submission and check project status$")
    public void engineer_approve_the_first_partial_submission_and_check_project_status() throws Throwable {
        projectSteps.engineer_approve_submission();
    }

    @And("^Vendor login to do the second partial submission ([^\"]*)$")
    public void vendor_login_to_do_the_second_partial_submission(String completionAmount1) throws Throwable {
        projectSteps.second_submission(completionAmount1);
    }

    @And("^Engineer approve the second partial submission and check project status$")
    public void engineer_approve_the_second_partial_submission_and_check_project_status() throws Throwable {
        projectSteps.engineer_approve_second_submission();
    }


    @And("^Vendor login to do the third partial final submission without uploading the needed docs ([^\"]*)$")
    public void vendor_login_to_do_the_third_partial_final_submission_without_uploading_the_needed_docs(String completionAmount2) throws Throwable {
        projectSteps.third_final_submission(completionAmount2);
    }

    @Then("^Check there is remind info for uploading docs$")
    public void check_there_is_remind_info_for_uploading_docs() throws Throwable {
        projectSteps.check_remind_upload_doc();
    }

    @Then("^Vendor upload all the docs and do the third partial final submission$")
    public void vendor_upload_all_the_docs_and_do_the_third_partial_final_submission() throws Throwable {
        projectSteps.vendor_upload_docs_submit();
    }

    @Then("^Engineer approve the third final submission without approve the docs$")
    public void engineer_approve_the_third_final_submission_without_approve_the_docs() throws Throwable {
        projectSteps.engineer_approve_third_submission();
    }

    @Then("^Check there is remind info for approve all docs$")
    public void check_there_is_remind_info_for_approve_all_docs() throws Throwable {
        projectSteps.remind_approve_doc();
    }

    @Then("^Engineer re-approve the third final submission and check project status$")
    public void engineer_re_approve_the_third_final_submission_and_check_project_status() throws Throwable {
        projectSteps.approve_doc_check_status();
    }

    @Then("^Clear project test data in db$")
    public void clear_project_test_data_in_db() throws Throwable {
        projectSteps.clear_project_in_db();
    }

    @And("^Vendor login to do the full submission ([^\"]*) without uploading the needed docs$")
    public void vendor_login_to_do_the_full_submission_without_uploading_the_needed_docs(String amount) throws Throwable {
        projectSteps.full_submission(amount);
    }

    @Then("^Vendor do the full submission with all needed docs uploaded$")
    public void vendor_do_the_full_submission_with_all_needed_docs_uploaded() throws Throwable {
        projectSteps.vendor_upload_docs_submit();
    }

    @Then("^Engineer reject the full submission and check project status$")
    public void engineer_reject_the_full_submission_and_check_project_status() throws Throwable {
        projectSteps.reject_Submission();
    }

    @Then("^Vendor login to check project status$")
    public void vendor_login_to_check_project_status() throws Throwable {
        projectSteps.vendor_check_project_status();
    }

    @And("^Vendor login to test po amount field ([^\"]*)$")
    public void vendor_login_to_test_po_amount_field(String amount) throws Throwable {
        projectSteps.vendor_check_amount(amount);
    }

}

