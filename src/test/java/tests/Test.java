package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Test {

    AppiumDriver<AndroidElement> driver;

    @Before
    public void setup() throws Exception {
        //desiredCapabilities.setCapability("platformName", "Android");
        //to specify test settings and required info about device and app under the test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
        //localhost means that appium server is running on your computer
        //if, appium server launched on some other computer
        //specify IP/DNS address instead of localhost
        //4723 - default port number of appium server. Can be changed
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
    }



    @org.junit.Test
    public void Test() throws Exception {

        AndroidElement btn2 = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Media\"]");

        String expected = "Media";
        String actual = btn2.getText();

        Assert.assertEquals(expected, actual);

        //to handle synchronization issues, same as in Selenium WebDriver
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(btn2));
        btn2.click(); // 2


    }

    // this annotation will close the app in our mobile
    @After
    public void tearDown(){
        driver.closeApp();
    }
}
