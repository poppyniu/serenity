package pages;

import constants.TestAccountsConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

/**
 * Created by Poppy_Zhang on 2017/6/21.
 */
@DefaultUrl("http://10.22.16.18/#/login")
public class loginPage extends PageObject {
    CommonPage commonPage;
    @FindBy(xpath = ".//*[@name='username']")
    WebElement UserNameTextbox;
    @FindBy(xpath = ".//*[@name='password']")
    WebElement UserPwdTextbox;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;
    @FindBy(xpath = ".//*[@id='logo']/img")
    WebElement HKLDLogo;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/thead/tr/th[6]")
    WebElement HKLDAmount;
    @FindBy(xpath = "//span[contains(text(),'Please input your correct username')]")
    WebElement UserNameInvalidInfo;
    @FindBy(xpath = "//span[contains(text(),'Please input your password')]")
    WebElement UserPwdInvalidInfo;

    public void validLogin() throws Exception {
        Thread.sleep(3000);
        UserNameTextbox.sendKeys(TestAccountsConstants.HKLDUserName);
        Thread.sleep(1000);
        UserPwdTextbox.sendKeys(TestAccountsConstants.HKLDUserPwd);
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(6000);
    }

    public void checkLoginSucceed() throws Exception {
        String currentUrl = getDriver().getCurrentUrl();
        Thread.sleep(2000);
        commonPage.navigatePage(currentUrl);
        Thread.sleep(3000);
        boolean logoExist = commonPage.elementExist(HKLDLogo);
        String AmoutText = HKLDAmount.getText();
        if (logoExist == true && AmoutText.contains("AMOUNT")) {
            System.out.println("HkLD engineer login succeed, test pass!");
        } else
            System.out.println("HkLD engineer login get error, test fail!");
    }

    public void invalidLogin() throws Exception {
        Thread.sleep(3000);
        UserNameTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserName);
        Thread.sleep(2000);
        boolean nameInvalidInfoExist=commonPage.elementExist(UserNameInvalidInfo);
        if (nameInvalidInfoExist == true) {
            System.out.println("Input invalid name see the correct info, test pass!");
        } else
            System.out.println("Input invalid name does not see the correct info, test fail!");
        UserPwdTextbox.sendKeys(TestAccountsConstants.InvalidHKLDUserPwd);
        Thread.sleep(2000);
        boolean pwdInvalidInfoExist=commonPage.elementExist(UserPwdInvalidInfo);
        if (pwdInvalidInfoExist == true) {
            System.out.println("Input invalid pwd see the correct info, test pass!");
        } else
            System.out.println("Input invalid pwd does not see the correct info, test fail!");
    }

    public void loginDisabled() throws Exception {
        boolean loginBtnEnable=loginBtn.isEnabled();
        if (loginBtnEnable == false) {
            System.out.println("Input invalid username or pwd the login button is disabled, test pass!");
        } else
            System.out.println("Input invalid username or pwd the login button is not disabled, test fail!");
    }

}
