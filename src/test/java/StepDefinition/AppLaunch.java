package StepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;


public class AppLaunch  {

	WebDriver driver;


	@Given("Open Chrome")
	public void open_Chrome() {
		System.out.println("Open the Chrome Browser");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}
	

	@And("Launch the Application")
	public void launch_the_Application() {
		System.out.println("Launch Application in the Chrome Browser");
		driver.navigate().to("https://www.fedex.com/en-gb/home.html");
	}

	@And("verify the default location")
	public void verify_the_default_location() {
		System.out.println("Verify the Default location selected popup is opened");

		WebElement location = driver.findElement(By.partialLinkText("NEDERLANDS"));
		String locName = location.getText();
		System.out.println(locName);
		String pageSource= driver.getPageSource();
		System.out.println("Page Source" +pageSource);
	}


	@And("Click on the default Language")
	public void Click_on_the_default_Language() throws Exception {
		System.out.println("Verify the Default language selected");
		driver.findElement(By.xpath("//div[@class='fxg-geo-locator__country']//child::ul//following-sibling::li/a")).click();
		Thread.sleep(2000);
	}

	@Then("Click on Accept Cookies")
	public void Click_on_Accept_Cookies() throws InterruptedException {
		System.out.println("Accepting cookies Page");
		driver.findElement(By.xpath("//div[@class ='fxg-cookie-consent__actions']/button[2]")).click();
		Thread.sleep(1000);
		driver.close();
	}
}

