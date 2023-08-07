package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.SfHomePage;

public class NewProudctCreation extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		testName = "New package creation";
		testDescription = "Create a package with appropirate details";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}

	@Test
	public void createNewPackage() throws InterruptedException {
		SfHomePage sFHomePage = new SfHomePage();
		sFHomePage
		
		.clickAccountTab()
		.clickAccountLink("Account")
		.clickPackageCustomButton()
		.switchToProductTab()
		.clickAddProductButton()
		.selectProduct()
		.enterProductName()
		.saveProduct()
		.verifySuccessMessage();

	}
}