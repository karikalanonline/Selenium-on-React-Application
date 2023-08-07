package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ProductDetailsPage;

public class AddStandaloneAddons extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		testName = "Login into the salesforce";
		testDescription = "Login with valid credentials";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	@Test
	public void addStandaloneAddons() throws InterruptedException {
	
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		productDetailsPage
		.goToProductMetaTab("Standalone Addons")
		.clickAddAddons()
		.filterAddon()
		.selectAddon()
		.clickAddSelected()
		.verifyAddedStandaloneAddon();
		
	}

}
