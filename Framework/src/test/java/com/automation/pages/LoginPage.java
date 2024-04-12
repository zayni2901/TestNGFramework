package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage{
	
	WebDriver driver;

	
	public LoginPage(WebDriver dlriver) {
		
		this.driver=dlriver;

}
	
	@FindBy(name="q") WebElement uname;
	@FindBy(name="q") WebElement pass;
	@FindBy(xpath="//input[@class=\"gNO89b\"]") WebElement loginButton;
	
	public void loginToCRM(String username, String password ) {
		
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
		//loginButton.click();
		
		
		
	}
	
}