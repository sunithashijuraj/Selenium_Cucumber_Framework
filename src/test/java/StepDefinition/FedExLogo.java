package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class FedExLogo {
	WebDriver driver;
	@Given("when user landed into the home page")
	public void when_user_landed_into_the_home_page() throws InterruptedException {
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

	@Then("check FedEx logo is present")
	public void check_FedEx_logo_is_present() {
	  String logoName = "";
	   WebElement logo = driver.findElement(By.xpath("//img[@class='fxg-header__logo']"));
	   logoName = logo.getAttribute("src");
	   System.out.println("logo image path is: "+logoName);
		driver.close();
	}
}
