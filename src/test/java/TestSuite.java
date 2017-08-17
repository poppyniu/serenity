import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Poppy_Zhang on 2017/4/28.
 */
//@RunWith(Cucumber.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/"},
        features = "src/test/resources/",
        tags = {"@ITQFlow"}
)
public class TestSuite {
}
