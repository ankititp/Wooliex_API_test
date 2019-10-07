package MyRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			
			features = "/Users/ankit/Downloads/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/Features/Holiday.feature",

			//glue="/Users/ankit/Downloads/CucumberSeleniumFramework-master/src/main/java/stepDefinitions/Brokers.java"//the path of the step definition files
				glue = {"stepDefinitions"},
			plugin={"pretty","html:target\\cucumber","json:target\\json\\cucumber.json"},tags={"~@ignore"})
	 
	public class TestRunner {
	 
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

