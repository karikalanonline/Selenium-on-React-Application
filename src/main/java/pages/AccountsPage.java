package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class AccountsPage extends ProjectSpecificMethods {
	
	
	public AccountsPage clickAccountLink(String accountname) {
		driver.findElement(By.xpath("//a[contains(text(),'" +accountname+ "')]")).click();
		return this;
	}
	
	public DashBoardPage clickPackageCustomButton() {
		driver.findElement(By.xpath("(//input[@value='pack_Custom2'])[1]")).click();
		return new DashBoardPage();
		
	}
	
	

}
