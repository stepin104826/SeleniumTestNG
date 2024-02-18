package testing;
import java.util.List;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import pageObjects.AmazonHomePage;


public class AmazonWebpageTest 
{
	static WebDriver driver = null; // Class Variable
	public static void main(String[] args) throws InterruptedException 
	{
		test_AmazonSearch();
	}	
	
	public static void test_AmazonSearch() throws InterruptedException 
	{
		// Get the path to the project
		String ProjectPath = System.getProperty("user.dir");
		System.out.println("ProjectPath: "+ProjectPath );
		
		
		WebDriverManager.firefoxdriver().setup(); // We can use WebDriverManager library to setup the drivers.
		driver = new FirefoxDriver();
		driver.manage().window().maximize();   // maximize the window
		driver.navigate().to("https://amazon.com/");
		System.out.println(driver.getCurrentUrl()); // get the current page URL
		System.out.println(driver.getTitle()); // get the page title
		Thread.sleep(3000);
			
		AmazonHomePage obj = new AmazonHomePage(driver);
		obj.setText("Airpods Pro");
		obj.ClickSearch();
		driver.navigate().back();  // Navigate back to search home page
		obj.no_input_elements();
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,150)");  // Scroll down the page
		
		Thread.sleep(3000);
		
		driver.close();   // Close the driver
		System.out.println("Amazon Test method ran succesfully!");
	}
}
