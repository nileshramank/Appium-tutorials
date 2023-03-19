import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class myntra {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
AndroidDriver d;
		
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("deviceName", "Redmi Note 9");
		cap.setCapability("udid", "21776e250410");
		cap.setCapability("appPackage", "com.myntra.android");
		cap.setCapability("appActivity", "com.myntra.android.SplashActivity");
		URL url =new URL("http://0.0.0.0:4723/wd/hub");
	d = new AndroidDriver(url,cap);
	Thread.sleep(3000);
	WebElement profile = d.findElement(By.xpath("//android.widget.Button[@content-desc=\"tabButton_profile\"]/android.widget.TextView"));
	profile.click();
	Thread.sleep(5000);
	WebElement login = d.findElement(By.xpath("//*[@class='android.widget.TextView']"));
	login.click();
	Thread.sleep(5000);
	WebElement mobile = d.findElement(By.xpath("//android.widget.EditText[@content-desc=\"mobile\"]"));
	mobile.sendKeys("8122325789");
	Thread.sleep(5000);
	WebElement conti = d.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"form-button\"]/android.view.ViewGroup/android.widget.TextView"));
	conti.click();
	}

}
