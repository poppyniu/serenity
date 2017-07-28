package pages;

import constants.TestAccountsConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
@DefaultUrl("http://hkld-qa.princeton.epam.com/#/login")
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
    @FindBy(xpath = "")
    WebElement namePwdInvalidInfo;

    public void validLogin() throws Exception {
        commonPage.wait(getDriver(),3000);
        userNameTextbox.click();
        //UserNameTextbox.sendKeys(TestAccountsConstants.HKLDUserName);
        commonPage.sendKeysOnElement(userNameTextbox,TestAccountsConstants.hkldUserName);
        commonPage.wait(getDriver(),1000);
        userPwdTextbox.click();
        //UserPwdTextbox.sendKeys(TestAccountsConstants.HKLDUserPwd);
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.hkldUserPwd);
        commonPage.wait(getDriver(),1000);
        loginBtn.click();
        commonPage.wait(getDriver(),5000);
    }

    public void Login(String name,String password) throws Exception {
        commonPage.wait(getDriver(),3000);
        userNameTextbox.click();
        userNameTextbox.clear();
        commonPage.sendKeysOnElement(userNameTextbox,name);
        commonPage.wait(getDriver(),1000);
        userPwdTextbox.click();
        userPwdTextbox.clear();
        commonPage.sendKeysOnElement(userPwdTextbox,password);
        commonPage.wait(getDriver(),1000);
        loginBtn.click();
        commonPage.wait(getDriver(),5000);
        currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2000);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3000);
    }

    public void checkLoginSucceed() throws Exception {
        currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2000);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3000);
        String userNameText = dashboardpage.userName.getAttribute("innerHTML");
        String AmoutText = dashboardpage.hkldAmount.getText();
        if (AmoutText.contains("AMOUNT") && userNameText.contains("sophie")) {
            System.out.println("HkLD engineer login succeed, test pass!");
        } else
            System.out.println("HkLD engineer login get error, test fail!");
    }

    public void invalidLogin() throws Exception {
        //input invalid username and pwd
        commonPage.wait(getDriver(),3000);
        //UserNameTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserName);
        commonPage.sendKeysOnElement(userNameTextbox,TestAccountsConstants.invalidHKLDUserName);
        commonPage.wait(getDriver(),2000);
        boolean nameInvalidInfoExist = commonPage.elementExist(userNameInvalidInfo);
        if (nameInvalidInfoExist == true) {
            System.out.println("Input invalid name see the correct info, test pass!");
        } else
            System.out.println("Input invalid name does not see the correct info, test fail!");
      //  UserPwdTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserPwd);
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.invalidHKLDUserPwd);
        commonPage.wait(getDriver(),2000);
        boolean pwdInvalidInfoExist = commonPage.elementExist(userPwdInvalidInfo);
        if (pwdInvalidInfoExist == true) {
            System.out.println("Input invalid pwd see the correct info, test pass!");
        } else
            System.out.println("Input invalid pwd does not see the correct info, test fail!");
        boolean loginBtnEnable = loginBtn.isEnabled();
        if (loginBtnEnable == false) {
            System.out.println("Input invalid username or pwd the login button is disabled, test pass!");
        } else
            System.out.println("Input invalid username or pwd the login button is not disabled, test fail!");
        //input empty name and pwd
        userNameTextbox.clear();
        commonPage.wait(getDriver(),1000);
        userPwdTextbox.click();
        userPwdTextbox.clear();
        commonPage.wait(getDriver(),1000);
        if (nameInvalidInfoExist == true) {
            System.out.println("Input empty name see the correct info, test pass!");
        } else
            System.out.println("Input empty name does not see the correct info, test fail!");
        if (pwdInvalidInfoExist == true) {
            System.out.println("Input empty pwd see the correct info, test pass!");
        } else
            System.out.println("Input empty pwd does not see the correct info, test fail!");
        if (loginBtnEnable == false) {
            System.out.println("Input invalid username or pwd the login button is disabled, test pass!");
        } else
            System.out.println("Input invalid username or pwd the login button is not disabled, test fail!");
        //input invlaid email address and pwd
//        UserNameTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserName1);
        commonPage.sendKeysOnElement(userNameTextbox,TestAccountsConstants.invalidHKLDUserName1);
        commonPage.wait(getDriver(),1000);
//        UserPwdTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserPwd1);
        commonPage.sendKeysOnElement(userPwdTextbox,TestAccountsConstants.invalidHKLDUserPwd1);
        commonPage.wait(getDriver(),2000);
        loginBtn.click();
        commonPage.wait(getDriver(),2000);
    }

    public void loginDisabled() throws Exception {
        Alert alert = getAlert();
        String alertText = alert.getText();
        if (alertText.contains("Invalid User/Password") == true) {
            System.out.println("Input invalid email address and pwd see the correct popup window, test pass!");
            alert.accept();
        } else
            System.out.println("Input invalid email address does not see the correct popup window, test fail!");
    }

    public void hkldUserLogin(String userName, String UserPwd) throws Exception{
        commonPage.sendKeysOnElement(userNameTextbox, userName);
        commonPage.sendKeysOnElement(userPwdTextbox, UserPwd);
        commonPage.wait(getDriver(),2000);
        loginBtn.click();
        commonPage.wait(getDriver(),5000);
    }

}
