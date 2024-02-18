package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting {
	
	@Test(testName = "Google Test")
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.cssSelector("textarea#APjFqb"));
		ele.sendKeys("abc",Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("Google Test Thread: "+Thread.currentThread().getId());
		driver.close();
	}
	
	@Test(testName = "Youtube Test")
	public void test2() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.cssSelector("input#search"));
		ele.sendKeys("abc",Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("Youtube Test Thread: "+Thread.currentThread().getId());
		driver.close();
		
	}
	
	@Test(testName = "Amazon Test")
	public void test3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		ele.sendKeys("abc",Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("Amazon Test Thread: "+Thread.currentThread().getId());
		driver.close();
	}
}
