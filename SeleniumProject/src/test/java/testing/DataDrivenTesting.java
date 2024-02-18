package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.ExcelUtils;


public class DataDrivenTesting {
	
	@Test(dataProvider="testdata", testName="login_test", description="This is a simple OrangeHRM Login Test")
	@Severity(SeverityLevel.CRITICAL)
	public void test_login(String username, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		
		try {
			List<WebElement> inp_fields = driver.findElements(By.xpath("//input"));
			inp_fields.get(1).sendKeys(username);
			inp_fields.get(2).sendKeys(password);
			WebElement login_button = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
			login_button.click();
			Thread.sleep(3);
			String dashboard_txt = driver.findElement(By.cssSelector("h6.oxd-text--h6")).getText();
			Assert.assertEquals(dashboard_txt,"Dashboard","Test Passed");
			driver.close();
		}
		catch(Exception ex) {
			System.out.println("Elements not found!");
			Assert.fail("Test Failed!");
			driver.close();
		}				
	}
	
	@DataProvider(name = "testdata")
	public Object[][] getData(){
		String excel_path = "/Excel/LoginData.xlsx";
		Object arr[][] = get_cell_data(excel_path,"Sheet1");
		return arr;
	}

	public Object[][] get_cell_data(String excel_path, String sheet_name) {
		
		ExcelUtils excel = new ExcelUtils(excel_path,sheet_name);
		int rownum = excel.getRowCount();
		int colnum = excel.getColCount();
		Object arr[][] = new Object[rownum-1][colnum];
		for(int i = 1; i < rownum; i++) {
			for(int j = 0; j < colnum; j++) {
				try {
					arr[i-1][j] = excel.getStringCellValue(i,j);
				}
				catch(Exception ex) {
					arr[i-1][j] = excel.getNumCellValue(i,j);
				}
			}
//		    System.out.println();
		}
		return arr;
	}
}

