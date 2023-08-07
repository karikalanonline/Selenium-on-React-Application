package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ProductDetailsPage;

public class CloneProduct extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		testName = "Clone product";
		testDescription = "Clone the product";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	@Test
	public void cloneProduct() throws InterruptedException {
	ProductDetailsPage productDetailsPage = new ProductDetailsPage();
	productDetailsPage.backToDashboardPage()
	.beforeProductCount()
	.clickThreeDots()
	.cloneProduct()
	.afterProductCount()
	.verifyClone();
	
	}
}
