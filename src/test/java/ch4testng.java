import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ch4testng {

	public static AndroidDriver d;

	@BeforeClass
	private void launchBrowser() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "Redmi Note 9");
		cap.setCapability("udid", "21776e250410");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		d = new AndroidDriver(url, cap);
	}

	@Test
	private void tc1() {
		WebElement three = d.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]"));
		three.click();
		WebElement six = d.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"6\"]"));
		six.click();
	}

	@Test
	private void tc2() {
		WebElement add = d.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
		add.click();

	}

	@Test
	private void tc3() {
		WebElement six = d.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"6\"]"));
		six.click();
		WebElement eight = d.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"8\"]"));
		eight.click();
	}

	@Test
	private void tc4() throws IOException {
		WebElement equal = d.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]"));
		equal.click();
		TakesScreenshot ts = (TakesScreenshot) d;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("./screenshot\\calculator.png");
		FileUtils.copyFile(image, f);
	}

	@BeforeMethod
	private void startDate() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod
	private void endDate() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	private void close() {
		d.quit();

	}
}
