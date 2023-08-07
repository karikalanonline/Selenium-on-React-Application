package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.DashBoardPage;
 
public class DeleteProduct extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		testName = "Login into the salesforce";
		testDescription = "Login with valid credentials";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	@Test
	public void deleteProduct() throws InterruptedException {
		String productName = "XXLx12";
		DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickThreeDots()
        .selectEdit()
        .findAddedProduct(productName)
        .selectCheckBox(productName)
        .deleteProduct()
        .verifyDeletion(productName);
     
	}

}
