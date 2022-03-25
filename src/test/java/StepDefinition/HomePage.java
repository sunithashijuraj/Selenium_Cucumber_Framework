package StepDefinition;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class HomePage {
	WebDriver driver = null;


	@Given("I am on the FedEx Home Page")
	public void FedEx_Home_Page() throws InterruptedException {
		System.out.println("Open the Chrome Browser");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://www.fedex.com/en-gb/home.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='fxg-geo-locator__country']//child::ul//following-sibling::li/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class ='fxg-cookie-consent__actions']/button[2]")).click();
		Thread.sleep(2000);
	String signup = driver.findElement(By.partialLinkText("Sign Up")).getText();
	assertEquals(signup, "Sign Up/Log In");
	}


	@When("^I Search for (.*) button$")
	public void Search_for_button(String stringValue) throws Throwable {
		String string = driver.findElement(By.id("btnSingleTrack")).getText();
	
		if(string.equalsIgnoreCase(stringValue)) {
			System.out.println("The button Value displayed in the page is: "+stringValue);
		}else
			System.out.println("I am on the wrong page");

	}


	@Then("^the page title should start with FedEx$")
	public void verifyTitle(){

		if(driver.getTitle().contains("FedEx"))  {
			System.out.println("Title of the Page Starts with FedEx");
		}else
			System.out.println("Currently the loaded title is: "+driver.getTitle());
		driver.close();
	

	}

}
