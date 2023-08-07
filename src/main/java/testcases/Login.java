package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class Login extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		testName = "Login into the salesforce";
		testDescription = "Login with valid credentials";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	
	@Test
	public void verifyLogin() {
		LoginPage lp = new LoginPage();
		lp.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.switchToClassic()
		.clickAccountTab()
		.clickAccountLink("Account1")
		.clickPackageCustomButton();
}
	
	
	
	
	
	
	
	
	
	
	





}