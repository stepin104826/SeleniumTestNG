package testing;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionHandling {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest(description = "This is the setup method.")
	public void setup() {
		WebDriverManager.chromedriver().setup();		
		driver.navigate().to("https://www.youtube.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test_search() throws InterruptedException {
		
		try {
			WebElement box = driver.findElement(By.cssSelector("inut#search"));
			box.sendKeys("Special 26");
			Thread.sleep(3000);
		}
		catch(Exception ex) {
			System.out.println("Element not found!");
			Assert.fail();
		}		
		System.out.println("Search Test method executed!");
	}
	
	@AfterTest(description = "This is the teardown method")
	public void tearDown() {
		driver.manage().window().minimize();
		driver.close();
	}
	
}
