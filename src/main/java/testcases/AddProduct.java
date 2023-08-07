package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ProductDetailsPage;

public class AddProduct extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		testName = "Add Product";
		testDescription = "Add products";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	@Test //add and verify the added products in newly created FA
	public void addProducts() throws InterruptedException  {
		String productName = "XXLx12";
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		productDetailsPage
		.goToProductMetaTab("Products")
		.clickAddProductsButton()
		.addProduct()
		.verifyAddedProduct(productName)
		.saveProduct()
		.verifySuccessMessage();
	}
}
