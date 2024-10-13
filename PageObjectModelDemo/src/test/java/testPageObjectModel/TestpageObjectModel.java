package testPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestpageObjectModel {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://arehare.com/");
		
	}
	@Test 
	public void pagetitle() {
		String title=driver.getTitle();
		System.out.println("page title:"+title);
		Assert.assertEquals(title,"AreHare", "page title does not match");
		
	}
	@Test
	public void testFromSubmission() {
		driver.findElement(By.xpath("//*[@id=\"navbarTogglerDemo02\"]/div/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"id_username\"]")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.xpath("/html/body/center/div/div/form/button")).click();
		
		String successMessage=driver.findElement(By.id("sucessmessage")).getText();
		Assert.assertTrue(successMessage.contains("success"), "from submission failed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
