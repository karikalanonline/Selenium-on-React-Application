package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;

public class ProductDetailsPage extends ProjectSpecificMethods {

	
	public ProductDetailsPage enterProductName() {
		driver.findElement(By.xpath("//div[.='Agreement name']//input")).sendKeys("Automation");
		return this;
	}

	public ProductDetailsPage goToProductMetaTab(String tabName) throws InterruptedException {
		String attribute = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('class');",
				driver.findElement(By.xpath("//a[text()='" + tabName + "']/parent::li[contains(@class,'fa-tab ')]")));

		System.out.println("attribute values " + attribute);
		if (!attribute.contains("fa-tab active")) {
			WebElement faTab = driver
					.findElement(By.xpath("//li[contains(@class,'fa-tab ')]//a[text()='" + tabName + "']"));
			driver.executeScript("arguments[0].click();", faTab);
		}
		return this;

	}

	public ProductDetailsPage clickAddProductsButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addProductsButton = driver.findElement(By.xpath("//button[@class='fa-button fa-button--brand']"));
		wait.until(ExpectedConditions.elementToBeClickable(addProductsButton));
		addProductsButton.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<>(allWindows);
		driver.switchTo().window(list.get(1));
		return this;
	}

	public ProductDetailsPage addProduct() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Filter products']")).sendKeys("XXLx12");
		Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[normalize-space()='XXLx12'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='fa-modal-footer']//button[normalize-space()='Add Selected']"))
		.click();
		return this;
	}

	private WebElement addedProduct(String productName) {
		return driver.findElement(
				By.xpath("//div[@class='products-card__inner']//div[normalize-space()='" + productName + "']"));
	}

	private String getProductName(String productName) {
		return addedProduct(productName).getText();
	}

	public ProductDetailsPage verifyAddedProduct(String productName) {
		if (getProductName(productName).equals(productName)) {
			System.out.println("productname is " + getProductName(productName));
			System.out.println(productName + "added successfully");
		} else {
			System.out.println("Products are not added successfully");
		}
		return this;
	}

	public ProductDetailsPage saveProduct() {
		WebElement saveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		return this;

	}

	public ProductDetailsPage verifySuccessMessage() {
		try {
			By successMessageLocator = By.xpath("//span[normalize-space()='Successfuly saved frame agreement!']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement successMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
			System.out.println("success message is :" + successMessage.getText());
		} catch (Exception e) {
			System.out.println("Success Message not displayed in the specified time");
		}
		return this;
	}

	public DashBoardPage backToDashboardPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[name()='svg'][@class='icon icon-back '])[1]")).click();
		return new DashBoardPage();
	}

	public ProductDetailsPage findAddedProduct(String productName) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Product name is " + getProductName(productName));
		if (getProductName(productName).contains(productName)) {
			System.out.println(getProductName(productName) + "present in the pop up");
		} else {
			System.out.println(getProductName(productName) + "Not present in the pop up");
		}
		return this;
	}

	public ProductDetailsPage selectCheckBox(String productName) throws InterruptedException {
		List<WebElement> productCards = driver.findElements(By.xpath("//div[@class='product-card__container']"));
		System.out.println("size is " + productCards.size());// 3 0 1 2
		for (int i = 1; i <= productCards.size(); i++) {// 1 2 3
			// Thread.sleep(3000);
			System.out.println("product cards" + productCards.get(i - 1).getText());// 0 0-1
			if (productCards.get(i - 1).getText().contains(productName)) {// 0-1
				WebElement productCheckBox = driver
						.findElement(By.xpath("(//div[@class='container__checkbox'])[" + i + "]/div"));

				driver.executeScript("arguments[0].click();", productCheckBox);
			}
		}
		return this;
	}

	public ProductDetailsPage deleteProduct() {
		driver.findElement(By.xpath("//span[contains(text(), 'Delete Products')]")).click();
		driver.findElement(By.xpath("//button[@class='fa-button fa-button--brand']")).click();
		return this;
	}

	public ProductDetailsPage deleteAddons() {
		driver.findElement(By.xpath("//span[contains(text(), 'Delete Add Ons')]")).click();
		driver.findElement(By.xpath("//button[@class='fa-button fa-button--brand']")).click();
		return this;
	}

	public ProductDetailsPage verifyDeletion(String productName) {
		List<WebElement> list = driver.findElements(
				By.xpath("//div[@class='products-card__inner']//div[normalize-space()= '" + productName + " ']"));
		int productCount = list.size();
		System.out.println("product count is  " + productCount);
		if (productCount == 0) {
			System.out.println("The product has been deleted successfully");
		} else {
			System.out.println("The product is not deleted due to some reason");
		}
		return this;
	}

	public ProductDetailsPage clickStandaloneAddons() {
		driver.findElement(By.xpath("//li[@class='fa-tab ']//a[normalize-space()='Standalone Addons']")).click();
		return this;
	}

	public ProductDetailsPage clickAddAddons() {
		driver.findElement(By.xpath("//button[@class='fa-button fa-button--brand' and text()='Add Add Ons']")).click();
		return this;
	}

	public ProductDetailsPage filterAddon() {
		driver.findElement(By.xpath("//input[@placeholder='Filter addons']")).sendKeys("Call");
		return this;
	}

	public ProductDetailsPage selectAddon() {
		List<WebElement> retrievedAddons = driver.findElements(
				By.xpath("//div[@class='fa-modal-product-list']//span[contains(normalize-space(), 'Call')]"));
		System.out.println("Addons size is " + retrievedAddons.size());
		for (int i = 1; i <= retrievedAddons.size(); i++) {
			if (retrievedAddons.get(i - 1).getText().toLowerCase().contains("call")) {
				// retrievedAddons.get(i-1).click();
				WebElement addon = driver.findElement(
						By.xpath("(//div[@class='fa-modal-product-list']//span[contains(normalize-space(), 'Call')])["
								+ i + "]"));

				addon.click();

			}

		}

		return this;
	}

	public ProductDetailsPage clickAddSelected() {
		driver.findElement(By.xpath("//div[@class='fa-modal-footer']//button[normalize-space()='Add Selected']"))
		.click();
		return this;

	}

	public ProductDetailsPage verifyAddedStandaloneAddon() {
		String AddonName = driver.findElement(By.xpath("//div[@class='fields__item fields__item--title']")).getText();
		if (AddonName.contains("Waiting")) {
			System.out.println(AddonName + "Addon has been added successfully");
		} else {
			System.out.println(AddonName + "has not added due to some issues");
		}
		return this;
	}

	public ProductDetailsPage searchAddon(String addonName) {
		driver.findElement(By.xpath("//input[@placeholder='Quick search']")).sendKeys(addonName);
		return this;
	}

	public ProductDetailsPage clickAddGroup() {
		driver.findElement(By.xpath("//div[@class='css-151xaom-placeholder']")).click();

		return this;
	}

}
