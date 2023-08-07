package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class SfHomePage extends ProjectSpecificMethods {

	public SfHomePage switchToClassic() {
		String url = driver.getCurrentUrl();
		try {
			if (url.contains("lightning")) {
				driver.findElement(By.xpath("(//div[@style ='background-color: #65CAE4'])[1]")).click();
				driver.findElement(By.xpath("(//div[@class=\"profile-card-footer\"]/a)[1]")).click();
			} else {
				try {
					WebElement popup = driver.findElement(By.id("tryLexDialogX"));
					if (popup.isDisplayed()) {
						popup.click();
					}
				} catch (NoSuchElementException e) {
					System.out.println("No popup found");
				}
			}
		} catch (Exception e) {
			System.out.println("Error occurred while switching to Classic: " + e.getMessage());
		}
		return this;
	}

	public AccountsPage clickAccountTab() {
		driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();
		return new AccountsPage();
	}

	public SfHomePage handlePopup() {
		WebElement popup = driver.findElement(By.id("tryLexDialogX"));
		if (popup.isDisplayed()) {
			popup.click();
		}
		return this;
	}
}
