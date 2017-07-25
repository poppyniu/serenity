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
public class loginPage extends PageObject {
    CommonPage commonPage;
    dashboardPage dashboardpage;
    @FindBy(xpath = ".//*[@name='username']")
    WebElement UserNameTextbox;
    @FindBy(xpath = ".//*[@name='password']")
    WebElement UserPwdTextbox;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;
    @FindBy(xpath = "//span[contains(text(),'Please input your correct username')]")
    WebElement UserNameInvalidInfo;
    @FindBy(xpath = "//span[contains(text(),'Please input your password')]")
    WebElement UserPwdInvalidInfo;
    @FindBy(xpath = "")
    WebElement NamePwdInvalidInfo;

    public void validLogin() throws Exception {
        Thread.sleep(3000);
        UserNameTextbox.click();
        //UserNameTextbox.sendKeys(TestAccountsConstants.HKLDUserName);
        commonPage.sendKeysOnElement(UserNameTextbox,TestAccountsConstants.HKLDUserName);
        Thread.sleep(1000);
        UserPwdTextbox.click();
        //UserPwdTextbox.sendKeys(TestAccountsConstants.HKLDUserPwd);
        commonPage.sendKeysOnElement(UserPwdTextbox,TestAccountsConstants.HKLDUserPwd);
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(6000);
    }

    public void checkLoginSucceed() throws Exception {
        String currentUrl = getDriver().getCurrentUrl();
        Thread.sleep(2000);
        commonPage.navigatePage(currentUrl);
        Thread.sleep(3000);
        String userNameText = dashboardpage.UserName.getAttribute("innerHTML");
        String AmoutText = dashboardpage.HKLDAmount.getText();
        if (AmoutText.contains("AMOUNT") && userNameText.contains("sophie")) {
            System.out.println("HkLD engineer login succeed, test pass!");
        } else
            System.out.println("HkLD engineer login get error, test fail!");
    }

    public void invalidLogin() throws Exception {
        //input invalid username and pwd
        Thread.sleep(3000);
        //UserNameTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserName);
        commonPage.sendKeysOnElement(UserNameTextbox,TestAccountsConstants.InvalidHKLDUserName);
        Thread.sleep(2000);
        boolean nameInvalidInfoExist = commonPage.elementExist(UserNameInvalidInfo);
        if (nameInvalidInfoExist == true) {
            System.out.println("Input invalid name see the correct info, test pass!");
        } else
            System.out.println("Input invalid name does not see the correct info, test fail!");
      //  UserPwdTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserPwd);
        commonPage.sendKeysOnElement(UserPwdTextbox,TestAccountsConstants.InvalidHKLDUserPwd);
        Thread.sleep(2000);
        boolean pwdInvalidInfoExist = commonPage.elementExist(UserPwdInvalidInfo);
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
        UserNameTextbox.clear();
        Thread.sleep(1000);
        UserPwdTextbox.click();
        UserPwdTextbox.clear();
        Thread.sleep(1000);
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
        commonPage.sendKeysOnElement(UserNameTextbox,TestAccountsConstants.InvalidHKLDUserName1);
        Thread.sleep(1000);
//        UserPwdTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserPwd1);
        commonPage.sendKeysOnElement(UserPwdTextbox,TestAccountsConstants.InvalidHKLDUserPwd1);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
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
        commonPage.sendKeysOnElement(UserNameTextbox, userName);
        commonPage.sendKeysOnElement(UserPwdTextbox, UserPwd);
        loginBtn.click();
        Thread.sleep(6000);
    }

}
