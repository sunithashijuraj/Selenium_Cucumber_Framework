package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class TrackingMenu {
	WebDriver driver = null;
	@Given("User landed on the home page")
	public void user_landed_on_the_home_page() throws InterruptedException {
//		System.out.println("Open the Chrome Browser");
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
		driver.navigate().to("https://www.fedex.com/en-gb/home.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='fxg-geo-locator__country']//child::ul//following-sibling::li/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class ='fxg-cookie-consent__actions']/button[2]")).click();
		Thread.sleep(2000);
		
	}

	@When("user Click on Tracking Menu")
	public void user_Click_on_Tracking_Menu() {
		driver.findElement(By.linkText("Tracking")).click();
	}

	@And("Enter the all tracking services")
	public void enter_the() {
		driver.findElement(By.linkText("ALL TRACKING SERVICES")).click();
	}

	@Then("user Landed in Track your shipment page")
	public void click_on_Track_shipment() {
		String title = driver.getTitle();
		boolean expectedResult = Boolean.parseBoolean(title);
		if(expectedResult) {
			Assert.assertTrue(expectedResult);
		}else
			Assert.assertFalse(expectedResult);

	} 

}
