package serenity;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maggie_Ping on 7/25/2017.
 */
public class DashboardPageSteps {
    DashboardPage dashboardPage;

    @Step
    public void click_humburgerIcon(){
        dashboardPage.clickHamburgerIcon();
    }

    @Step
    public void click_settingLink(){
        dashboardPage.clickSettingLink();
    }

    @Step
    public void checkSettingLinkVisible(String expected){
        switch (expected){
            case "is":
                Assert.assertTrue(dashboardPage.settingLinkVisible());
                break;
            case "is not":
                Assert.assertFalse(dashboardPage.settingLinkVisible());
                break;
        }
    }

    @Step
    public void click_HKLDLogo(){
        dashboardPage.clickHKLDLogo();
    }

    @Step
    public void checkSpecifiedTenderVisible(String prNumber, String expected){
        List<WebElement> links = dashboardPage.getLinksFromTenderTable();
        List<String> linksText = links.stream().map(element -> {return element.getAttribute("textContent");}).collect(Collectors.toList());
        switch (expected){
            case "is":
                Assert.assertTrue(linksText.contains(prNumber));
                break;
            case "is not":
                Assert.assertFalse(linksText.contains(prNumber));
                break;
        }
    }

    @Step
    public void user_Logout(){
        dashboardPage.clickLogoutLink();
    }

    @Step
    public void check_BubbleNumber(String type){
        if(type.contains("tender")){
            int tenderBubbleNumber = Integer.parseInt(dashboardPage.getTenderBubbleNumber());
            int tenderNumber = dashboardPage.getLinksFromTenderTable().size()/2;
            Assert.assertEquals("Tender number displayed in the bubble is not equal to the number in the table list.", tenderBubbleNumber, tenderNumber);
        }else if(type.contains("project")){
            int projectBubbleNumber = Integer.parseInt(dashboardPage.getProjectBubbleNumber());
            int projectNumber = dashboardPage.getLinksFromProjectTable().size()/2;
            Assert.assertEquals("Project number displayed in the bubble is not equal to the number in the project list.", projectBubbleNumber, projectNumber);
        }else{
            Assert.fail("Unexpected type: "+type);
        }
    }

    @Step
    public void check_HelloNameOnDashboard(String expectedName){
        String actualName = dashboardPage.getHelloNameOnDashboard();
        Assert.assertTrue("Hello Name is incorrect, and the actual name is "+actualName, expectedName.contains(actualName.toLowerCase().replace(" ", "_")));
    }

    @Step
    public void check_HelloNameOnHamburger(String expectedName){
        String actualName = dashboardPage.getHelloNameOnHamburger();
        Assert.assertTrue("The Hello name on hamburger is incorrect, and it's "+ actualName, expectedName.contains(actualName.toLowerCase().replace(" ", "_")));
    }

    @Step
    public void check_TenderParameterValue(String prNumber, String expectedValue){
        List<WebElement> allTenderLines = dashboardPage.getAllTenderLines();
        for (WebElement tender:allTenderLines) {
            if(tender.getText().contains(prNumber)){
                Assert.assertTrue(tender.getText().replace("\n", "").contains(expectedValue));
                return;
            }
        }
        Assert.fail(prNumber + " is not found from the dashboard.");
    }

    @Step
    public void click_specifiedTender(String prNumber){
        dashboardPage.clickSpecifiedTender(prNumber);
    }

    @Step
    public void wait_for_Ready_For_Review(String prNumber) {
        dashboardPage.refreshToSeeReadyForReview(prNumber);
    }
}
