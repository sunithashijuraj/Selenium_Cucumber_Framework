package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Shipping {
WebDriver driver = null;

@Given("User is on the FedEx Home Page")
public void user_is_on_the_FedEx_Home_Page() throws InterruptedException {
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

@When("User click on the Shipping Menu")
public void user_click_on_the_Shipping_Menu() {
    driver.findElement(By.linkText("Shipping")).click();
   
}

@Then("User should be able to see the subMenu")
public void user_should_be_able_to_see_the_subMenu() {
    
}

@When("Click the E-commerse")
public void click_the_E_commerse() {
	 driver.findElement(By.linkText("E-commerce")).click();
}

@Then("User landed to the E-commerse Page")
public void user_landed_to_the_E_commerse_Page() {
   String title = driver.getTitle();
   System.out.println("The title of the page is "+title);
   }

}
