package steps.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.LoginSteps;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class LoginStepDefinitions {
    @Steps
    LoginSteps loginSteps;

    @Given("^Open ETender system login page$")
    public void open_ETender_system_login_page() throws Throwable {
        loginSteps.open_login_page();
    }

    @When("^Input valid user name and pwd and click login button$")
    public void input_valid_user_name_and_pwd_and_click_login_button() throws Throwable {
        loginSteps.valid_hkld_login();
    }

    @Then("^HKLD engineer login to ETender system succeed$")
    public void hkld_engineer_login_to_ETender_system_succeed() throws Throwable {
        loginSteps.check_login_succeed();
    }

    @When("^Input invalid user name and pwd and click login button$")
    public void input_invalid_user_name_and_pwd_and_click_login_button() throws Throwable {
        loginSteps.invalid_hkld_login();
    }

    @Then("^HKLD engineer login disalbed$")
    public void hkld_engineer_login_disalbed() throws Throwable {
        loginSteps.login_disabled();
    }

    @When("^user logs in as the user type ([^\"]*)$")
    public void the_user_logs_in_as_the_user_type(String userType) throws Exception {
        loginSteps.hkld_login(userType);
    }

    @When("^user logs in with user name ([^\"]*) and password ([^\"]*)$")
    public void user_logs_in_with_username_and_password(String userName, String password) throws Exception {
        loginSteps.anyUser_login(userName, password);
    }

}
