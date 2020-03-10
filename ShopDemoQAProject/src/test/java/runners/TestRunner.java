package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/pageObjectsFeatures", glue="", monochrome=true, tags={"@Smoke, @Regression"}, dryRun=false)
public class TestRunner {

}