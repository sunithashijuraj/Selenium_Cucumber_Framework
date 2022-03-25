package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",tags = "@Regression", glue= {"StepDefinition"},

monochrome = true,

plugin = {"pretty","html:target/HTMLReports",
		  "html:target/cucumber-reports"},
strict = true

		)

public class TestRunner {

}
