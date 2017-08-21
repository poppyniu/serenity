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
                loginPage.anyUserLogin(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
                break;
            case "HKLD Engineer":
                loginPage.anyUserLogin(TestAccountsConstants.hkldUserName, TestAccountsConstants.hkldUserPwd);
                break;
            case "HKLD Approver":
                loginPage.anyUserLogin(TestAccountsConstants.hkldAdmin, TestAccountsConstants.hkldUserPwd);
                break;
            default:
                LOGGER.warn(("Unexpected user type: " + userType));
        }
    }

    @Step
    public void anyUser_login(String userName, String password) throws Exception{
        loginPage.anyUserLogin(userName, password);
    }

    @Step
    public void open_contractor_login_page() throws Exception{
        loginPage.openContractorLoginPage();
    }

    @Step
    public void contractor_valid_login() throws Exception{
        loginPage.contractorLogin();
    }

    @Step
    public void check_contractor_login_succeed() throws Exception{
        loginPage.checkContractorLogin();
    }

    @Step
    public void contractor_invalid_login() throws Exception{
        loginPage.contractorInvalidLogin();
    }

    @Step
    public void check_contractor_login_fail() throws Exception{
        loginPage.checkContractorLoginFail();
    }

    @Step
    public void click_forgot_pwd_send_email() throws Exception{
        loginPage.forgotPwdSendEmail();
    }

    @Step
    public void check_reset_pwd_info() throws Exception{
        loginPage.checkResetPwdInfo();
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    @Step
    public void check_logout_success() {
        loginPage.CheckLogOut_success();
    }

}
