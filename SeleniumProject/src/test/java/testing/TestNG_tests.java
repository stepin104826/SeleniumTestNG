package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.SkipException;


public class TestNG_tests {

//	WebDriver driver = new ChromeDriver();
	
//	@BeforeTest  // This is a TestNG annotation for running it before the test method.
//	public void setUpTest() {
//		
//		String project_path = System.getProperty("user.dir");
//		System.out.println(project_path);
//		
//	}
	
	@Test(priority = 1, description="This is the first test")    // This is the actual test method.
	@Description("This is a simple test for Google Searchbox")
	@Severity(SeverityLevel.CRITICAL)
	public void GoogleSearchTest() throws InterruptedException {
		 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();   // maximize the window
		driver.navigate().to("https://google.com/");
		System.out.println(driver.getCurrentUrl()); // get the current page URL
		System.out.println(driver.getTitle()); // get the page title
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.cssSelector("textarea#APjFqb"));
		ele.sendKeys("abc",Keys.ENTER);
		Thread.sleep(3000);
		driver.navigate().back();  // Navigate back to search home page
		List<WebElement> elemsList = driver.findElements(By.xpath("//input"));
		int Listsize = elemsList.size();
		System.out.println("Total no. of input elements in the home page: "+Listsize);
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,150)");  // Scroll down the page
		
		Thread.sleep(3000);	
		driver.close();
		System.out.println("Hello from TestNG Test 1!");
	}
	
	@Test(priority = 3,description="This is the second test")
	@Description("Test method for account registration")
	public void AccountRegistration() {
		
		System.out.println("This is test 2!");  // Skipping this test
	}
	
	@Ignore
	@Test(priority = 2,description="This is the third test")
	@Severity(SeverityLevel.MINOR)
	public void SimpleTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://youtube.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement textbox = driver.findElement(By.cssSelector("input#search"));
		textbox.sendKeys("Tesla");
		driver.close();
		System.out.println("Hello from TestNG Test 3!");
		
	}
	
//	@AfterTest
//	public void tearDownTest() {
//		
//		driver.close();
//		System.out.println("Google Test methods ran succesfully!");
//	}
}
