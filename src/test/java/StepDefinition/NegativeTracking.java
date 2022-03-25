package StepDefinition;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class NegativeTracking {
	WebDriver driver=null;
	@Given("Track module is highlighted by default")
	public void TrackModule_isHighlighted() throws InterruptedException {
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
		String string = driver.findElement(By.xpath("//ul[@class='fxg-cube-container']//descendant:: span[2]")).getText();
		if(string.equalsIgnoreCase("TRACK")) {
			System.out.println("The Selected Module in the FedEx Page is: "+string);
		}else
			System.out.println("I am on the wrong page");
	}

	@When("user enter wrong trackingNumber")
	public void user_enter_wrong_trackingNumber() throws InterruptedException {
		System.out.println("User is entering the Wrong shipmentid number:");
		driver.findElement(By.name("trackingnumber")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='fxg-field']/input[@name='trackingnumber']")).sendKeys("T12345");
		Thread.sleep(2000);
		}

	@And("Click on Track button")
	public void click_on_Track_button() throws InterruptedException {
		System.out.println("user should click the track button to track the shipment id");
		driver.findElement(By.id("btnSingleTrack")).click();
		Thread.sleep(2500);

	}

	@Then("User should Navigate to the Detail tracking page")
	public void user_should_Navigate_to_the_Detail_tracking_page() {
		String title = driver.getTitle();
		assertEquals(title, "Detailed Tracking");
	   
	}

	@And("Error message should display")
	public void error_message_should_display() {
		boolean contains = driver.getPageSource().contains("No record of this tracking number");
		System.out.println("Error message is getting displayed as expected");
	driver.close();
	}


}
