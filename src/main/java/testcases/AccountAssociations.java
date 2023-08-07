package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.DashBoardPage;

public class AccountAssociations extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		testName = "Account association";
		testDescription = "Associate the product into different account";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
	@Test
	public void associateAccounts() throws InterruptedException {
		DashBoardPage dashBoardPage = new DashBoardPage();
		dashBoardPage.clickThreeDots()
		.selectAccountOption()
		.selectAssociations()
		.selectAccountToAsso()
		.verifyAssociatedAccount()
		.clickDone();
	}

}
