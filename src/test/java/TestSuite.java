import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Poppy_Zhang on 2017/4/28.
 */
//@RunWith(Cucumber.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/"},
        features = {"src/test/resources/settingsPage","src/test/resources" }
//        tags = {"@RejectProject"}
)
public class TestSuite {
}
