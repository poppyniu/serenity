package steps.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.poppytest1Steps;

/**
 * Created by Poppy_Zhang on 2017/6/7.
 */
public class poppytest1StepDefinitions {
    @Steps
    poppytest1Steps poppytest1Steps;

    @Given("^Open baidu home page with Browser$")
    public void open_baidu_home_page_with_Browser() throws Throwable {
        poppytest1Steps.opens_home_page();
    }

    @When("^See baidu home logo$")
    public void see_baidu_home_logo() throws Throwable {
        poppytest1Steps.check_logo();
    }

    @Then("^Close browser$")
    public void close_browser() throws Throwable {
        poppytest1Steps.close_browser();
    }

    @Then("^Click news hyperlink$")
    public void click_news_hyperlink() throws Throwable {
        poppytest1Steps.click_link();
    }

    @Then("^Go to news page$")
    public void go_to_news_page() throws Throwable {
        poppytest1Steps.navigate_page();
    }
}
