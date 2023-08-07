package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.DashBoardPage;

public class DeletePackage extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		testName = "Delete FA";
		testDescription = "Delete the FA";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
    @Test
	public void deleteProduct() throws InterruptedException {
	  DashBoardPage dashBoardPage = new DashBoardPage();
		 dashBoardPage.clickThreeDots()
		.beforeProductCount()
		.DeleteProduct()
		.afterProductCount()
		.verifyDelete();
		
	}
}
