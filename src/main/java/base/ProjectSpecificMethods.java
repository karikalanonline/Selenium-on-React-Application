package base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ProjectSpecificMethods {
	public static ChromeDriver driver;
	public static Properties prop;
	public String excelfilename;
	public static ExtentReports extent;
	public static ExtentTest test1;
	public String testName, testDescription, testAuthor, testCategory;

	@BeforeSuite
	public static void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod  
	public void preCondition() throws IOException {
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		prop = new Properties();
		prop.load(fis);
		driver = new ChromeDriver();
		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@BeforeClass
	public void testDetails() {
		test1 = extent.createTest(testName, testDescription);
		test1.assignCategory(testCategory);
		test1.assignAuthor(testAuthor);
	}

	public void stepLevelReport(String stepMessage, String status) {
		if (status.equalsIgnoreCase("pass")) {
			test1.pass(stepMessage);
		} else if (status.equalsIgnoreCase("fail")) {
			test1.fail(stepMessage);
		}
	}

//	@AfterTest
//	public void postCondition() {
//		
//		driver.close();
//		
//	}

	@AfterTest
	public void stopReport() {
		extent.flush();
	}
}
