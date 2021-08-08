package cucumber.runner;

import cucumber.base.CucumberBaseClass;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions (features = {"src/test/java/features"}, glue = "cucumber.steps",
					monochrome = true)
public class CucumberRunner extends CucumberBaseClass {

}
