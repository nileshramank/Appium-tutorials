import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class htmlreport {
	 public static	AndroidDriver d;
	 ExtentHtmlReporter htmlreporter;
	 ExtentReports extent;
	 ExtentTest test;
		@Test
	private void tc1() throws IOException,AWTException, InterruptedException{
			DesiredCapabilities cap =new DesiredCapabilities();
			htmlreporter = new ExtentHtmlReporter("calculatorreport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlreporter);
			test = extent.createTest("Android","calculator application");
			Properties property = new Properties();
			FileInputStream fis =new FileInputStream("E:\\Appiummain\\Appium\\File\\congif.properties");
			property.load(fis);
	
	cap.setCapability("platformName", property.getProperty("platformName"));
	cap.setCapability("platformVersion",property.getProperty("Version"));
	cap.setCapability("deviceName", property.getProperty("name"));
	cap.setCapability("udid", property.getProperty("udid"));
	cap.setCapability("appPackage", property.getProperty("appPackage"));
	cap.setCapability("appActivity", property.getProperty("appActivity"));
	URL url = new URL("http://0.0.0.0:4723/wd/hub");
	d = new AndroidDriver(url, cap);
		Thread.sleep(5000);
		test.log(Status.INFO, "appium click the three button");
		WebElement three = d.findElement(By.xpath(property.getProperty("three")));
		three.click();
		test.log(Status.INFO, "appium click the six button");
		WebElement six = d.findElement(By.xpath(property.getProperty("six")));
		six.click();
		test.log(Status.INFO, "appium click the add button");
		WebElement add = d.findElement(By.xpath(property.getProperty("add")));
	add.click();
	test.log(Status.INFO, "appium click the eight button");
	WebElement eight = d.findElement(By.xpath(property.getProperty("eight")));
	eight.click();
	test.log(Status.INFO, "appium click the equal button");
	WebElement equal = d.findElement(By.xpath(property.getProperty("equal")));
	equal.click();
		}
	@Test(priority=1)
	private void tc2 () {
		test.log(Status.PASS, "appium write the test_case_2");
		
		System.out.println("test_case_2");
	}
	
	@Test(priority=2)
	private void tc3 () {
		test.log(Status.PASS, "appium write the test_case_3");
		System.out.println("test_case_2");
	}
	
	@Test(priority=4)
	private void tc4 () {
		test.log(Status.PASS, "appium quite the apk app");
		extent.flush();
		d.quit();

		
		
}
}
