package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.DashBoardPage;

public class RemoveAccountAssociations extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		testName = "Remove Account Association";
		testDescription = "Remove the products from the accounts";
		testCategory = "Smoke";
		testAuthor = "Karikalan";
	}
@Test
	public void removeAccountAssociation() {
		DashBoardPage dashBoardPage = new DashBoardPage();
		dashBoardPage.clickThreeDots()
		.selectAccountOption()
		.removeAssociatedAccount()
		.verifyRemovedAccount()
		.clickDone();
	}
}
