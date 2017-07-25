package serenity;

import constants.TestAccountsConstants;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Step
    public void hkld_login(String userType) throws Exception {
        switch (userType) {
            case "HKLD Admin":
                loginpage.hkldUserLogin(TestAccountsConstants.HKLDAdminName, TestAccountsConstants.HKLDAdminPwd);
                break;
            case "HKLD Engineer":
                loginpage.hkldUserLogin(TestAccountsConstants.HKLDUserName, TestAccountsConstants.HKLDUserPwd);
                break;
            case "HKLD Approver":
                loginpage.hkldUserLogin(TestAccountsConstants.HKLDApproverName, TestAccountsConstants.HKLDApproverPwd);
                break;
            default:
                LOGGER.warn(("Unexpected user type: " + userType));
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(loginSteps.class);

}
