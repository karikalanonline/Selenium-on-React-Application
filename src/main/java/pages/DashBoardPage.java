package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;

public class DashBoardPage extends ProjectSpecificMethods {
	public List<WebElement> countOfFa;
	public int productCountAfter;
	public int productCountBefore;



	public DashBoardPage switchToProductTab() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<>(allWindows);
		driver.switchTo().window(list.get(1));
		return this;
	}

	public DashBoardPage clickAddProductButton() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@class = 'fa-dropdown-group']//button[@class = 'fa-button fa-button--brand']")).click();
		return this;
	}

	public ProductDetailsPage selectProduct() {
		driver.findElement(By.xpath("//button[@id='createnewchild']")).click();
		return new ProductDetailsPage();
	}

	public DashBoardPage clickThreeDots() {
		driver.findElement(By.cssSelector(".icon.icon-threedots_vertical")).click();
		return this;
	}

	public DashBoardPage beforeProductCount() {
		countOfFa = productLocator();
		productCountBefore = countOfFa.size();
		System.out.println("Before FA Count is " + productCountBefore);
		return this;

	}

	public DashBoardPage cloneProduct() {
		driver.findElement(
				By.xpath("//div[@class='fa-dropdown fa-dropdown--secondary']//span[normalize-space()='Clone']"))
				.click();
		driver.findElement(By.xpath("//div[@class='fa-modal-footer']//button[normalize-space()='Clone']")).click();

		return this;

	}

	public DashBoardPage DeleteProduct() {
		driver.findElement(
				By.xpath("//div[@class='fa-dropdown fa-dropdown--secondary']//span[normalize-space()='Delete']"))
				.click();
		driver.findElement(By.xpath("//div[@class='fa-modal-footer']//button[normalize-space()='Delete']")).click();
		return this;

	}

	public DashBoardPage afterProductCount() throws InterruptedException {
		Thread.sleep(2000);
		countOfFa = productLocator();
		productCountAfter = countOfFa.size();
		System.out.println("After FA Count is " + productCountAfter);
		return this;
	}

	private List<WebElement> productLocator() {
		return driver.findElements(By.xpath("//div[@class='fa-panel']//span[normalize-space()='Automation']"));

	}

	public DashBoardPage verifyClone() {
		if (productCountAfter == productCountBefore + 1) {
			System.out.println("FA Clone successfully, Now the FA count is " + productCountAfter);
		} else {
			System.out.println("Cloned is not success");
		}
		return this;
	}

	public DashBoardPage verifyDelete() {
		if (productCountAfter == productCountBefore - 1) {
			System.out.println("FA Delete successfully, Now the FA count is " + productCountAfter);
		} else {
			System.out.println("Deleted is not success");
		}
		return this;
	}

	public DashBoardPage selectAccountOption() {
		driver.findElement(
				By.xpath("//div[@class='fa-dropdown fa-dropdown--secondary']//span[normalize-space()='Accounts']"))
				.click();
		return this;
	}

	public DashBoardPage selectAssociations() {
		driver.findElement(By.xpath("//div[@class='vertical-tab ']//h3[normalize-space()='Associations']")).click();
		return this;
	}

	public DashBoardPage selectAccountToAsso() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Filter records...']")).sendKeys("Global");
		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// WebElement filteredAccount = driver
		// .findElement(By.xpath("//div[@class='fa-modal-product-list']//span[normalize-space()='Global
		// Media']"));
		// wait.until(ExpectedConditions.elementToBeClickable(filteredAccount));
		// filteredAccount.click();
		driver.findElement(By.xpath("//div[@class='fa-modal-product-list']//span[normalize-space()='Global Media']"))
				.click();

		return this;

	}

	public DashBoardPage verifyAssociatedAccount() {
		WebElement chosenAccount = driver
				.findElement(By.xpath("//p[@class='vertical-tab-subtitle']//span[normalize-space()='Global Media']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(chosenAccount));
		if (chosenAccount.getText().contains("Global")) {
			System.out.println("The account has been associated successfully");
		} else {
			System.out.println("The account association failed");
		}
		return this;
	}

	public DashBoardPage removeAssociatedAccount() {
		driver.findElement(
				By.xpath("//div[@class='vertical-tab ']//p[@class='vertical-tab-subtitle']//*[name()='svg']")).click();
		return this;
	}

	public DashBoardPage verifyRemovedAccount() {
		String text = driver
				.findElement(By.xpath(
						"//p[@class='vertical-tab-subtitle']//span[normalize-space()='--no associated accounts']"))
				.getText();
		if (text.contains("no associated")) {
			System.out.println("The account has been removed successfully");
		} else {
			System.out.println("The script failed to remove to account association due to some reason");
		}
		return this;
	}

	public DashBoardPage clickDone() {
		driver.findElement(By.xpath("//button[@class='fa-button fa-button--default']")).click();
		return this;
	}

	public ProductDetailsPage selectEdit() {
		driver.findElement(
				By.xpath("//div[@class='fa-dropdown fa-dropdown--secondary']//span[normalize-space()='Edit']")).click();
		return new ProductDetailsPage();
	}

}
