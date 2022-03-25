package StepDefinition;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;


public class Hooks {
	WebDriver driver = null;
	@Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
	}
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
	
    }
}