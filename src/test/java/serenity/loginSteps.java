package serenity;

import net.thucydides.core.annotations.Step;
import pages.itqPage;
import pages.loginPage;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class loginSteps {
    loginPage loginpage;

    @Step
    public void open_login_page() throws Exception {
        loginpage.open();
    }

    @Step
    public void valid_hkld_login() throws Exception {
        loginpage.validLogin();
    }

    @Step
    public void check_login_succeed() throws Exception {
        loginpage.checkLoginSucceed();
    }

    @Step
    public void invalid_hkld_login() throws Exception {
        loginpage.invalidLogin();
    }

    @Step
    public void login_disabled() throws Exception {
        loginpage.loginDisabled();
    }



}
