package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	
	public LoginPage enterUserName() {
		try {
			driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
			stepLevelReport("Username is entered successfully", "Pass");
		} catch (Exception e) {
			stepLevelReport("Username is not entered successfully.." + e, "Fail");
		}
		return this;
	}
	
	public LoginPage enterPassword() {
		try {
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			stepLevelReport("Password is entered successfully", "Pass");
		} catch (Exception e) {
			stepLevelReport("Password is not entered successfully.." + e, "Fail");
		}
		return this;
	}
	
	public SfHomePage clickLoginButton() {
		try {
			driver.findElement(By.id("Login")).click();
			stepLevelReport("Login button is clicked successfully", "Pass");
		} catch (Exception e) {
			stepLevelReport("Failed to click the Login button.." + e, "Fail" );
		}
		return new SfHomePage();  
		
	}

}
