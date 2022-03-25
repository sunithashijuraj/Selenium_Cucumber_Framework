package StepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class AccountMenu {
	WebDriver driver = null;
	@Given("User is on the FedEx homepage")
	public void user_is_on_the_FedEx_homepage() throws InterruptedException {
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

	}

	@When("user clicks on the Account Menu")
	public void user_clicks_on_the_Account_Menu() {
		driver.findElement(By.linkText("Account")).click();
	}

	@Then("click on the OPEN AN ACCOUNT Menu")
	public void click_on_the_OPEN_AN_ACCOUNT_Menu() throws InterruptedException {
		driver.findElement(By.linkText("OPEN AN ACCOUNT")).click();
		Thread.sleep(2000);
	}

	@And("User should be navigated to the Open Account Page")
	public void user_should_be_navigated_to_the_Open_Account_Page() {
		String title = driver.getTitle();
		boolean expectedResult = Boolean.parseBoolean(title);
		if(expectedResult) {
			Assert.assertTrue(expectedResult);
		}else
			Assert.assertFalse(expectedResult);
	}


	@Then("Personal Account and Business Account details are visible")
	public void personal_Account_and_Business_Account_details_are_visible() {
		String text = driver.findElement(By.xpath("//div[@class='row ']//descendant::div[@class='title section']/h3[1]")).getText();
		boolean expectedResult = Boolean.parseBoolean(text);
		if(expectedResult) {
			Assert.assertTrue(expectedResult);
		}else
			Assert.assertFalse(expectedResult);
		driver.close();
	}

}
