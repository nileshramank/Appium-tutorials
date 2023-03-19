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

public class ch5_mynra_properties {
	 public static	AndroidDriver d;
	 ExtentHtmlReporter htmlreporter;
	 ExtentReports extent;
	 ExtentTest test;
	 
		@Test
	private void tc1() throws IOException,AWTException, InterruptedException{
				
			htmlreporter = new ExtentHtmlReporter("myntrareport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlreporter);
			test = extent.createTest("Android","myntra application");
				DesiredCapabilities cap =new DesiredCapabilities();
				Properties property = new Properties();
				FileInputStream fis =new FileInputStream("E:\\Appiummain\\Appium\\File\\myntra.properties");
				property.load(fis);
				cap.setCapability("platformName", property.getProperty("platformName"));
				cap.setCapability("platformVersion",property.getProperty("Version"));
				cap.setCapability("deviceName",property.getProperty("name"));
				cap.setCapability("udid",property.getProperty("udid"));
				cap.setCapability("appPackage",property.getProperty("appPackage"));
				cap.setCapability("appActivity",property.getProperty("appActivity"));
				URL url =new URL("http://0.0.0.0:4723/wd/hub");
			d = new AndroidDriver(url,cap);
			Thread.sleep(5000);
			test.log(Status.INFO, "appium click the profile button");
			WebElement profile = d.findElement(By.xpath(property.getProperty("profile")));
			profile.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "appium click the login button");
			WebElement login = d.findElement(By.xpath(property.getProperty("login")));
			login.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "appium send the mobile button");
			WebElement mobile = d.findElement(By.xpath(property.getProperty("mobile")));
			mobile.sendKeys(property.getProperty("mob"));
			Thread.sleep(2000);
			test.log(Status.PASS, "appium click the continue button");
			WebElement conti = d.findElement(By.xpath(property.getProperty("conti")));
			conti.click();
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
