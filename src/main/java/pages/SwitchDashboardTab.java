package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class SwitchDashboardTab extends ProjectSpecificMethods {
	
   
	public DashBoardPage switchToFamTab() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<>(allWindows);
		driver.switchTo().window(list.get(1));
		return new DashBoardPage();
	}
}
