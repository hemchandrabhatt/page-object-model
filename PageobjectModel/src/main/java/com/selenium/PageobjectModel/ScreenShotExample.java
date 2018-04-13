package com.selenium.PageobjectModel;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotExample {

	//private static final int priority = 0;
	// Create Webdriver reference
	static WebDriver driver;
	@BeforeMethod
	public void beforMehtod(){
		System.setProperty("webdriver.gecko.driver",
				"E:\\jar libraries\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}
	
	@Test(priority=3, enabled=false)
	public static void captureScreenMethod() throws Exception {
		
		driver.get("https://www.softwaretestingmaterial.com");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id='cse-search-box']/div/input[4]"))
				.sendKeys("agile"); // Statement with correct Xpath
		// driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("agile");
		// //Statement with incorrect Xpath
	}

	@Test(priority=2, enabled=false)
	public void pageLoadTest() {

		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))
				.sendKeys("Mobiles");
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("mi mobiles")))
				.perform();*/
		driver.findElement(By.partialLinkText("mi mobiles")).click();
		

	}
	
	@Test(priority=1)
	public void googleSearchTest(){
		 driver.get("http://www.google.com");
		    WebElement query = driver.findElement(By.name("q"));
		    query.sendKeys("s");
		    WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
		    WebDriverWait wait = new WebDriverWait(driver,10);
		    wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
		        int indexToSelect =3;
				if(indexToSelect <=optionsToSelect.size()) {
		        	System.out.println("Trying to select based on index: "+indexToSelect);
		           optionsToSelect.get(indexToSelect).click();
				}
		    driver.findElement(By.name("btnK")).click();
	}

	@AfterMethod
	// AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter
		// into if condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that
				// screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("D:\\" + result.getName()
						+ ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot "
						+ e.getMessage());
			}
		}
		 //driver.quit();
	}
}