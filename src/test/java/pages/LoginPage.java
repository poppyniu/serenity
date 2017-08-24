package pages;

import constants.TestAccountsConstants;
import constants.TestDataPathConstants;
import constants.URLConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
@DefaultUrl("http://hkld-qa.princeton.epam.com/#/login")
//@DefaultUrl("http://epcnszxw0187.princeton.epam.com/#/")
public class LoginPage extends PageObject {
    String currentUrl;
    CommonPage commonPage;
    DashboardPage dashboardpage;
    @FindBy(xpath = ".//*[@name='username']")
    WebElement userNameTextbox;
    @FindBy(xpath = ".//*[@name='password']")
    WebElement userPwdTextbox;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;
    @FindBy(xpath = "//span[contains(text(),'Please input your correct username')]")
    WebElement userNameInvalidInfo;
    @FindBy(xpath = "//span[contains(text(),'Please input your password')]")
    WebElement userPwdInvalidInfo;
    @FindBy(xpath = ".//*[@id='modules-vendors-login-form']/div[4]/a")
    WebElement forgotPwdLink;
    @FindBy(xpath = "html/body/div[1]/div[2]/form/label/input")
    WebElement emailTextbox;
    @FindBy(xpath = ".//*[@id='forgotpwd-form-send']")
    WebElement sendEmailBtn;
    @FindBy(xpath = ".//*[@class='reveal-overlay fade-in mui-enter mui-enter-active']/div[1]/div[1]/div/span")
    WebElement resetPwdInfo;






    public void validLogin() throws Exception {
        commonPage.wait(getDriver(),3);
        userNameTextbox.click();
        commonPage.sendKeysOnElement(userNameTextbox,TestAccountsConstants.hkldUserName);
        commonPage.wait(getDriver(),1);
        userPwdTextbox.click();
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.hkldUserPwd);
        commonPage.wait(getDriver(),1);
        loginBtn.click();
        commonPage.wait(getDriver(),5);
    }

    public void Login(String name,String password) throws Exception {
        commonPage.wait(getDriver(),3);
        userNameTextbox.click();
        userNameTextbox.clear();
        commonPage.sendKeysOnElement(userNameTextbox,name);
        commonPage.wait(getDriver(),1);
        userPwdTextbox.click();
        userPwdTextbox.clear();
        commonPage.sendKeysOnElement(userPwdTextbox,password);
        commonPage.wait(getDriver(),1);
        loginBtn.click();
        commonPage.wait(getDriver(),5);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3);
    }

    public void checkLoginSucceed() throws Exception {
        currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3);
        String userNameText = dashboardpage.userName.getAttribute("innerHTML");
        String AmoutText = dashboardpage.hkldAmount.getText();
        if (AmoutText.contains("AMOUNT") && userNameText.contains("sophie")) {
            System.out.println("HkLD engineer login succeed, test pass!");
        } else
            Assert.fail("HkLD engineer login get error, test fail!");
    }

    public void invalidLogin() throws Exception {
        //input invalid username and pwd
        commonPage.wait(getDriver(),3);
        commonPage.sendKeysOnElement(userNameTextbox,TestAccountsConstants.invalidHKLDUserName);
        commonPage.wait(getDriver(),2);
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.invalidHKLDUserPwd);
        commonPage.wait(getDriver(),2);
        boolean pwdInvalidInfoExist = commonPage.elementExist(userPwdInvalidInfo);
        if (pwdInvalidInfoExist == true) {
            System.out.println("Input invalid pwd see the correct info, test pass!");
        } else
            Assert.fail("Input invalid pwd does not see the correct info, test fail!");
        boolean loginBtnEnable = loginBtn.isEnabled();
        if (loginBtnEnable == false) {
            System.out.println("Input invalid username or pwd the login button is disabled, test pass!");
        } else
            Assert.fail("Input invalid username or pwd the login button is not disabled, test fail!");
        //input empty pwd
        userPwdTextbox.click();
        userPwdTextbox.clear();
        commonPage.wait(getDriver(),1);
        if (pwdInvalidInfoExist == true) {
            System.out.println("Input empty pwd see the correct info, test pass!");
        } else
            Assert.fail("Input empty pwd does not see the correct info, test fail!");
        if (loginBtnEnable == false) {
            System.out.println("Input invalid username or pwd the login button is disabled, test pass!");
        } else
            Assert.fail("Input invalid username or pwd the login button is not disabled, test fail!");
        //input invlaid email address and pwd
        commonPage.wait(getDriver(),1);
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.invalidHKLDUserPwd1);
        commonPage.wait(getDriver(),2);
        loginBtn.click();
        commonPage.wait(getDriver(),5);
    }

    public void loginDisabled() throws Exception {
        Alert alert = getAlert();
        String alertText = alert.getText();
        if (alertText.contains("Invalid User/Password") == true) {
            System.out.println("Input invalid email address and pwd see the correct popup window, test pass!");
            alert.accept();
        } else
            Assert.fail("Input invalid email address does not see the correct popup window, test fail!");
    }

    public void anyUserLogin(String userName, String UserPwd) throws Exception{
        commonPage.sendKeysOnElement(userNameTextbox, userName);
        commonPage.sendKeysOnElement(userPwdTextbox, UserPwd);
        commonPage.wait(getDriver(),2);
        loginBtn.click();
        commonPage.wait(getDriver(),5);
    }

    public void openContractorLoginPage() throws Exception {
        getDriver().get(URLConstants.contractorLoginPage);
        commonPage.wait(getDriver(),2);
    }

    public void contractorLogin() throws Exception {
        Login(TestAccountsConstants.contractorNameTender,TestAccountsConstants.contractorPwd);
    }

    public void checkContractorLogin() throws Exception {
        dashboardpage.hamburgerIcon.click();
        commonPage.wait(getDriver(),4);
        if(dashboardpage.helloNameOnHamburger.getText().contains(TestAccountsConstants.afterLoginName)){
            System.out.println("Input valid contractor name and pwd login succeed, test pass!");
        } else
            Assert.fail("Input valid contractor name and pwd login succeed, test fail!");

    }

    public void contractorInvalidLogin() throws Exception {
        commonPage.wait(getDriver(),3);
        commonPage.sendKeysOnElement(userNameTextbox,TestAccountsConstants.invalidHKLDUserName);
        commonPage.wait(getDriver(),2);
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.invalidHKLDUserPwd);
        commonPage.wait(getDriver(),2);
        boolean nameInvalidInfoExist = commonPage.elementExist(userNameInvalidInfo);
        boolean pwdInvalidInfoExist = commonPage.elementExist(userPwdInvalidInfo);
        boolean loginBtnEnable = loginBtn.isEnabled();
        if (nameInvalidInfoExist==true&&pwdInvalidInfoExist == true&&loginBtnEnable==false) {
            System.out.println("Input invalid name and pwd see the correct info,and login button is disabled, test pass!");
        } else
            Assert.fail("Input invalid name and pwd does not see the correct info,,and login button is disabled, test fail!");
        userNameTextbox.click();
        userNameTextbox.clear();
        commonPage.wait(getDriver(),1);
        userPwdTextbox.click();
        commonPage.wait(getDriver(),1);
        userPwdTextbox.clear();
        commonPage.wait(getDriver(),1);
        if (nameInvalidInfoExist==true&&pwdInvalidInfoExist == true&&loginBtnEnable==false) {
            System.out.println("Input empty name and pwd see the correct info,and login button is disabled, test pass!");
        } else
            Assert.fail("Input empty name and pwd does not see the correct info,,and login button is disabled, test fail!");
        commonPage.wait(getDriver(),2);
        commonPage.sendKeysOnElement(userNameTextbox, TestAccountsConstants.invalidUserName1);
        commonPage.sendKeysOnElement(userPwdTextbox, TestAccountsConstants.invalidHKLDUserPwd1);
        commonPage.wait(getDriver(),2);
        loginBtn.click();
        commonPage.wait(getDriver(),5);
    }

    public void checkContractorLoginFail() throws Exception {
        loginDisabled();
    }

    public void forgotPwdSendEmail() throws Exception {
        forgotPwdLink.click();
        currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3);
        commonPage.sendKeysOnElement(emailTextbox,TestAccountsConstants.contractorNameTender);
        sendEmailBtn.click();
        commonPage.wait(getDriver(),3);
    }

    public void checkResetPwdInfo() throws Exception {
        if(resetPwdInfo.getText().contains(TestDataPathConstants.resetPwdInfo)){
            System.out.println("Send email to reset pwd see the correct info, test pass!");
        } else
            Assert.fail("Send email to reset pwd does not see the correct info, test fail!");
    }

    public void CheckLogOut_success() {
        currentUrl = getDriver().getCurrentUrl();
        if(currentUrl.equals(URLConstants.hkldLoginPage)){
            System.out.println("Logout successfully");
            System.out.println(currentUrl);
        } else
            Assert.fail("logout fail");
    }
}
