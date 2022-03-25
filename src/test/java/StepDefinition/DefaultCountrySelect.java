package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class DefaultCountrySelect {
	WebDriver driver;
	@Given("user navigated to the home page")
	public void user_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Open the Chrome Browser");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	driver.navigate().to("https://www.fedex.com/en-gb/home.html");
	Thread.sleep(2000);
	
	}

	@When("Choose Geo popup is displayed")
	public void choose_Geo_popup_is_displayed() {
	  
	}

	@Then("user is able to select the English Language under UK")
	public void user_is_able_to_select_the_English_Language_under_UK() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='fxg-geo-locator__button-label'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class ='fxg-cookie-consent__actions']/button[2]")).click();
		Thread.sleep(2000);
		if(driver.getTitle().contains("FedEx"))  {
			System.out.println("Title of the Page Starts with FedEx");
		}else
			System.out.println("Currently the loaded title is: "+driver.getTitle());
		driver.close();
	
	}

}
