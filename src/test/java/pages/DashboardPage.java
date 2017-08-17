package pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Poppy_Zhang on 2017/7/10.
 */
public class DashboardPage extends PageObject {
    CommonPage commonPage;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/thead/tr/th[6]")
    WebElement hkldAmount;
    @FindBy(xpath = ".//*[@id='create_tender']")
    WebElement createTenderBtn;
    @FindBy(xpath = ".//*[starts-with(@id, 'modal-dialog')]/div[2]/button[2]")
    WebElement selectTypeEnterBtn;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[1]/span[2]")
    WebElement userName;
    @FindBy(xpath = ".//*[@id='logo']/img")
    WebElement hkldLogo;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")
    WebElement itqTenderItemOne;
    @FindBy(id = "hamburger")
    WebElement hamburgerIcon;
    @FindBy(id = "hamburger3")
    WebElementFacade settingLink;
    @FindBy(xpath = ".//*[@id='user_name']")
    WebElement helloNameOnHamburger;
    @FindBy(xpath = ".//div[@class = 'tender-table']")
    WebElement tenderTable;
    @FindBy(xpath = ".//div[@class='project-container clearfix']/div[1]")
    WebElement projectTable;
    @FindBy(id = "logout")
    WebElement logoutLink;
    @FindBy(xpath = ".//div[@class='summary-badge summary-badge__dark']")
    WebElement tendersBubbleNumber;
    @FindBy(xpath = ".//div[@class='summary-badge summary-badge__normal']")
    WebElement projectBubbleNumber;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[1]/span[2]")
    WebElement helloNameOnDashboard;
    @FindBy(xpath = "//button[contains(text(),\"Create Project\")]")
    WebElement createProjectBtn;
    @FindBy(xpath = ".//*[@id='projects-po-number-input']")
    WebElement poNoTextbox;
    @FindBy(xpath = ".//*[@id='po-data-modal']/div[2]/button[2]")
    WebElement poDataYesBtn;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[3]/div/div[2]/table/tbody/tr/td[1]/a")
    WebElement projectItemOne;
    @FindBy(xpath = "html/body/div[1]/div[2]/div[3]/div/div[1]/table/tbody/tr/td[1]/a")
    WebElement engineerProjectItemOne;
    @FindBy(xpath = ".//*[@id='create-project-modal']/div/button[2]")
    WebElement addPoNoBtn;




    /*
        If get to the dashboard twice in the same scenario, webElements from the pop out of create tender would not be unique.
        So selectCreateTenderDropdown() is updated to find the pop out first.
     */
    public void selectCreateTenderDropdown(String item) throws Exception {
        commonPage.wait(getDriver(),2);
        createTenderBtn.click();
        commonPage.wait(getDriver(),2);
        WebElement element = getDriver().findElements(By.cssSelector("div[style^='display: block;']")).get(1);
        WebElement inputField = element.findElement(By.xpath(".//*[@id='confirm-create-container']/div/div[2]/input"));
        WebElement selectTypeDropdownItem= element.findElement(By.xpath(".//*[@id='confirm-create-container']/div/div[3]/ul/li[1]/span"));
        WebElement selectTypeEnterBtn1 = element.findElement(By.xpath(".//*[starts-with(@id, 'modal-dialog')]/div[2]/button[2]"));

        if(item.contains("tender")) {
            commonPage.sendKeysOnElement(inputField, "Tender");
            selectTypeDropdownItem.click();
        }
        if(item.contains("itq")) {
            commonPage.sendKeysOnElement(inputField, "ITQ");
            selectTypeDropdownItem.click();
        }
        commonPage.wait(getDriver(),2);
        selectTypeEnterBtn1.click();
        commonPage.wait(getDriver(),3);
        String currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(),2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(),3);
    }

    public void clickHamburgerIcon(){
        hamburgerIcon.click();
    }

    public void clickSettingLink(){
        settingLink.click();
    }

    public boolean settingLinkVisible(){
        return settingLink.isVisible();
    }

    public void clickHKLDLogo(){
        hkldLogo.click();
        commonPage.wait(getDriver(),5);
    }

    public List<WebElement> getLinksFromTenderTable(){
        List<WebElement> linksFromTenderTable = tenderTable.findElements(By.xpath(".//a[@class = 'link_text']"));
        return linksFromTenderTable;
    }

    public void clickLogoutLink(){
        logoutLink.click();
        commonPage.wait(getDriver(),3);
    }

    public String getTenderBubbleNumber(){
        return tendersBubbleNumber.getAttribute("textContent");
    }

    public String getProjectBubbleNumber() {
        return projectBubbleNumber.getAttribute("textContent");
    }

    public List<WebElement> getLinksFromProjectTable(){
        List<WebElement> linksFromProjectTable = tenderTable.findElements(By.xpath(".//a[@class = 'link_text']"));
        return linksFromProjectTable;
    }

    public String getHelloNameOnDashboard(){
        return helloNameOnDashboard.getAttribute("textContent");
    }

    public String getHelloNameOnHamburger(){
        return helloNameOnHamburger.getAttribute("textContent");
    }

    public List<WebElement> getAllTenderLines() {
        commonPage.wait(getDriver(), 3);
       List<WebElement>  allTenderLines = getDriver().findElements(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/table/tbody/tr"));
       return allTenderLines;
    }

    public void clickSpecifiedTender(String prNumber){
        List<WebElement>  allTenderLines = getAllTenderLines();
        for(WebElement tender : allTenderLines){
            if(tender.getText().contains(prNumber)){
                tender.findElements(By.xpath(".//a[@class = 'link_text']")).get(0).click();
                commonPage.wait(getDriver(), 3);
            }
        }
    }

    public void clickCreateProject(String poNo) throws Exception{
        commonPage.wait(getDriver(), 2);
        createProjectBtn.click();
        commonPage.wait(getDriver(), 2);
        commonPage.sendKeysOnElement(poNoTextbox, poNo);
        commonPage.wait(getDriver(), 1);
        addPoNoBtn.click();
        commonPage.wait(getDriver(), 2);
        poDataYesBtn.click();
        commonPage.wait(getDriver(), 2);
        String currentUrl = getDriver().getCurrentUrl();
        commonPage.wait(getDriver(), 2);
        commonPage.navigatePage(currentUrl);
        commonPage.wait(getDriver(), 3);
    }
}
