package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
	private static WebDriver driver = null;
	
	By searchbox = By.cssSelector("input#twotabsearchtextbox");
	By clickbutton = By.cssSelector("input#nav-search-submit-button");
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setText(String text) {
		driver.findElement(searchbox).sendKeys(text);
	}
	
	public void ClickSearch() {
		driver.findElement(clickbutton).click();
	}
	
	public void no_input_elements() {
		List<WebElement> elem_list = driver.findElements(By.xpath("//input"));
		int size = elem_list.size();
		System.out.println("Total number of input elements in the page: "+ size);
	}
	
}

