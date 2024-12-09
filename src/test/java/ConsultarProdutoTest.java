import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
 
public class ConsultarProdutoTest {
 
  private AndroidDriver driver;

  private URL getUrl() {
    try {
      return new URL("https://InstrutorIterasys27:e41c8d26-0be8-4359-8ec1-39817f95b694@ondemand.us-west-1.saucelabs.com:443/wd/hub");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
        return null; // Intervalo: Voltaremos 21:00
  }
 
  @BeforeEach
  public void setUp() {
    var options = new BaseOptions()
      .amend("platformName", "Android")
      .amend("appium:platformVersion", "9.0")
      .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
      .amend("appium:deviceOrientation", "portrait")
      .amend("appium:app", "storage:filename=mda-2.2.0-25.apk")
      .amend("appium:appPackage", "com.saucelabs.mydemoapp.android")
      .amend("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
      .amend("appium:automationName", "UiAutomator2")
      .amend("browserName", "")
      .amend("appium:ensureWebviewsHavePages", true)
      .amend("appium:nativeWebScreenshot", true)
      .amend("appium:newCommandTimeout", 3600)
      .amend("appium:connectHardwareKeyboard", true);
 
    driver = new AndroidDriver(this.getUrl(), options);
  }
 
  @Test
  public void sampleTest() {
    var el1 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[2]"));
    el1.click();
    // driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187)));
    var el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.apps.nexuslauncher:id/snapshot\").instance(1)"));
    el2.click();
    var el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(1)"));
    el3.click();
    // driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187)));
    var el4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.apps.nexuslauncher:id/snapshot\").instance(1)"));
    el4.click();
    var el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)"));
    el5.click();
    var el6 = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV"));
    el6.click();
    var el7 = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV"));
    el7.click();
  }
 
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
