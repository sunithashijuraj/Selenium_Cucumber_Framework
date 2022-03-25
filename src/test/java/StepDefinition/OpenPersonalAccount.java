package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class OpenPersonalAccount {
	WebDriver driver = null;
	@Given("User is on the Open Account Page")
	public void user_is_on_the_Open_Account_Page() throws InterruptedException {
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
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.linkText("OPEN AN ACCOUNT")).click();

	}

	@When("User clicks on the Open a Personal Account button")
	public void user_clicks_on_the_Open_a_Personal_Account_button() {
	driver.findElement(By.linkText("OPEN A PERSONAL ACCOUNT")).click();
	}

	@Then("user navigates to the Contact details Page of Personal Account creation")
	public void user_navigates_to_the_Contact_details_Page_of_Personal_Account_creation() {
	 
	}

	@Then("Enter the {string}, {string}, {string},{string}, {string},{string}, {string}, {string}")
	public void enter_the(String firstName, String lastName, String country, String Address, String postalcode, String city, String phone, String email) {
	driver.findElement(By.id("first-name")).sendKeys(firstName);
	driver.findElement(By.id("last-name")).sendKeys(lastName);
	Select selcountry = new Select(driver.findElement(By.id("country")));
	selcountry.selectByVisibleText(country);
	driver.findElement(By.id("address")).sendKeys(Address);
	driver.findElement(By.id("postal-code")).sendKeys(postalcode);
	driver.findElement(By.id("city")).sendKeys(city);
	driver.findElement(By.id("phone")).sendKeys(phone);
	driver.findElement(By.id("email")).sendKeys(email);
	}

	@Then("click on Enter Login Details")
	public void click_on_Enter_Login_Details() {
	driver.findElement(By.xpath("//div[@class='action-bar ng-tns-c91-1']")).click();
	driver.close();
	}
}
