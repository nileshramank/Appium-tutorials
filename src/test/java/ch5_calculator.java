import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ch5_calculator {
	 public static	AndroidDriver d;
		@Test
	private void tc1() throws IOException,AWTException, InterruptedException{
			DesiredCapabilities cap =new DesiredCapabilities();
			Properties property = new Properties();
			FileInputStream fis =new FileInputStream("E:\\Appiummain\\Appium\\File\\congif.properties");
			property.load(fis);
	
	cap.setCapability("platformName", property.getProperty("platformName"));
	cap.setCapability("platformVersion",property.getProperty("Version"));
	cap.setCapability("deviceName", property.getProperty("name"));
	cap.setCapability("udid", property.getProperty("udid"));
	cap.setCapability("appPackage", property.getProperty("appPackage"));
	cap.setCapability("appActivity", property.getProperty("appActivity"));
	URL url = new URL("http://0.0.0.0:8200/wd/hub");
	d = new AndroidDriver(url, cap);
		Thread.sleep(5000);
		WebElement three = d.findElement(By.xpath(property.getProperty("three")));
		three.click();
		WebElement six = d.findElement(By.xpath(property.getProperty("six")));
		six.click();
		WebElement add = d.findElement(By.xpath(property.getProperty("add")));
	add.click();
	WebElement eight = d.findElement(By.xpath(property.getProperty("eight")));
	eight.click();
	WebElement equal = d.findElement(By.xpath(property.getProperty("equal")));
	equal.click();

		
		
}
}