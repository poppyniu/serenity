package steps.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.itqSteps;
import serenity.loginSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class loginStepDefinitions {
    @Steps
    loginSteps loginsteps;

    @Given("^Open ETender system login page$")
    public void open_ETender_system_login_page() throws Throwable {
        loginsteps.open_login_page();
    }

    @When("^Input valid user name and pwd and click login button$")
    public void input_valid_user_name_and_pwd_and_click_login_button() throws Throwable {
        loginsteps.valid_hkld_login();
    }

    @Then("^HKLD engineer login to ETender system succeed$")
    public void hkld_engineer_login_to_ETender_system_succeed() throws Throwable {
        loginsteps.check_login_succeed();
    }

    @When("^Input invalid user name and pwd and click login button$")
    public void input_invalid_user_name_and_pwd_and_click_login_button() throws Throwable {
        loginsteps.invalid_hkld_login();
    }

    @Then("^HKLD engineer login disalbed$")
    public void hkld_engineer_login_disalbed() throws Throwable {
        loginsteps.login_disabled();
    }


    }
