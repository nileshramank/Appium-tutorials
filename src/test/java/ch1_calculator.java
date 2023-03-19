import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ch1_calculator {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver d;
		
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "Redmi Note 9");
		cap.setCapability("udid", "21776e250410");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		URL url =new URL("http://0.0.0.0:4723/wd/hub");
	d = new AndroidDriver(url,cap);

	WebElement eight = d.findElement(By.id("com.miui.calculator:id/btn_9_s"));
    eight.click();
	
	
	//WebElement seven = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
//seven.click();
WebElement add = d.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
add.click();
WebElement nine = d.findElement(By.id("com.miui.calculator:id/btn_9_s"));
nine.click();
WebElement equal = d.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
equal.click();

		
	}

}
