package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenShot(WebDriver driver) {
		
		
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshopath = System.getProperty("users.dir","./Screenshots/Google"+getCurrentDate()+".png");
		
		try {
			FileHandler.copy(src, new File(screenshopath));
			
		System.out.println("Screenshot Captured");
		} catch (IOException e) {
		
			System.out.println("Unable to Capture screenshot "+e.getMessage());
		}
		
		return screenshopath;
		
	}
	
public static String getCurrentDate() {
	
	DateFormat customFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	Date curentDate = new Date();
	
	return customFormat.format(curentDate);
}
}
