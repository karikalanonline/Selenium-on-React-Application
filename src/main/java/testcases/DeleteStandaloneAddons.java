package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ProductDetailsPage;

public class DeleteStandaloneAddons extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		testName = "Delete the standalone addons";
		testDescription = "Delete standalone addons";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	@Test
	public void deleteStandaloneAddons() throws InterruptedException {
	    String addonName = "Call Waiting";
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		productDetailsPage
		.selectCheckBox(addonName)
		.deleteAddons()
		.verifyDeletion(addonName);
		
		
	}

}
