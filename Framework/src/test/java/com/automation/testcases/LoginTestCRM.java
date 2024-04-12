package com.automation.testcases;




import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;



import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;


public class LoginTestCRM  extends BaseClass{
	
	
	
	
	
	@Test(priority = 1)
	public void loginApp() {
		
		log = report.createTest("Login to CRM");
		LoginPage loginPage =PageFactory.initElements(driver, LoginPage.class);
		log.info("Starting the Application");
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		log.pass("Login is Success");
		
	
		
		
	}
	//@Test(priority = 2)
public void logoutApp() {
		
		log = report.createTest("Login to CRM");
	
		log.fail("Logout is Failed");
		
	
		
		
	}

	

}
