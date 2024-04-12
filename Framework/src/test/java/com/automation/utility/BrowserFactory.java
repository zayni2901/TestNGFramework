package com.automation.utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
public static WebDriver startApplication (WebDriver driver, String browserName,String appURL) {
	
	if(browserName.equals("Chrome")) {
		
		driver= new ChromeDriver();
		
		
		
	}
	
	else if(browserName.equals("Firefox")) {
		driver= new FirefoxDriver();

	}
	
	else if(browserName.equals("IE")) {
		driver= new EdgeDriver();

	}
	else {
		System.out.println("We don't recognize the Browser");
	}
	driver.get(appURL);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
}



public static void quitBrowser(WebDriver driver) {
	
	driver.quit();
	
}

}
