package com.selenium.PageobjectModel;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestClass {
	
	@Test
	public void test(){
		 System.setProperty("webdriver.gecko.driver",
					"E:\\jar-libraries\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		  FirefoxDriver driver = new FirefoxDriver();
		  driver.get("https://www.amazon.in/");
	}

}
