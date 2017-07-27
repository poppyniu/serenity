package serenity;

import constants.TestAccountsConstants;
import net.thucydides.core.annotations.Step;
import pages.LoginPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void open_login_page() throws Exception {
        loginPage.open();
    }

    @Step
    public void valid_hkld_login() throws Exception {
        loginPage.validLogin();
    }

    @Step
    public void check_login_succeed() throws Exception {
        loginPage.checkLoginSucceed();
    }

    @Step
    public void invalid_hkld_login() throws Exception {
        loginPage.invalidLogin();
    }

    @Step
    public void login_disabled() throws Exception {
        loginPage.loginDisabled();
    }

    @Step
    public void hkld_login(String userType) throws Exception {
        switch (userType) {
            case "HKLD Admin":
                loginPage.hkldUserLogin(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
                break;
            case "HKLD Engineer":
                loginPage.hkldUserLogin(TestAccountsConstants.hkldUserName, TestAccountsConstants.hkldUserPwd);
                break;
            case "HKLD Approver":
                loginPage.hkldUserLogin(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
                break;
            default:
                LOGGER.warn(("Unexpected user type: " + userType));
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

}
