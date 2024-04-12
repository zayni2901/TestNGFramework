package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass {
	
	public WebDriver driver;	
	public ExcelDataProvider excel;	
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest log;
	
	@BeforeSuite
	public void SetupSuite() {
		Reporter.log("Setup is Started",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(System.getProperty("users.dir", "./Reports/Google"+Helper.getCurrentDate()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setup is Done",true);
		
		
	}
	
	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start Browser",true);
		driver = BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingURl());
		Reporter.log("Browser has been started",true);
	}
	
	@AfterMethod
	
	public void tearDownMethod(ITestResult result) throws IOException 
	{
		Reporter.log("Test is about to end",true);
		if (result.getStatus()==ITestResult.FAILURE) {
			

			log.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS) {
			
			log.pass("Test Success", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
	
			
			
		
		
		report.flush();
		Reporter.log("Test is completed >>> Reports Generated",true);
		
	}
	
	@AfterClass
	public void tearDown() {
	
	BrowserFactory.quitBrowser(driver);
	
}

}
