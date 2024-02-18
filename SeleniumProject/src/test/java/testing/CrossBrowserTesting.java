package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CrossBrowserTesting {
	
	@Parameters("browserName")	
	@Test(testName="Cross-browser Test")
	public void test(String Name) throws InterruptedException 
	{
		if(Name.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.youtube.com/");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebElement ele = driver.findElement(By.cssSelector("input[id='search']"));
			ele.sendKeys("MJ Songs",Keys.ENTER);
			Thread.sleep(3000);
			driver.close();
			System.out.println("Chrome Test completed successfully!");
		}
		
		else if(Name.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.youtube.com/");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebElement ele = driver.findElement(By.cssSelector("input[id='search']"));
			ele.sendKeys("MJ Songs",Keys.ENTER);
			Thread.sleep(3000);
			driver.close();
			System.out.println("Firefox Test completed successfully!");
		}
		else if(Name.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.youtube.com/");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebElement ele = driver.findElement(By.cssSelector("input[id='search']"));
			ele.sendKeys("MJ Songs",Keys.ENTER);
			Thread.sleep(3000);
			driver.close();
			System.out.println("Edge Test completed successfully!");
		}
			
	}
	
}
