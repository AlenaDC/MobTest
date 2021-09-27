package tests;

import io.appium.java_client.remote.MobileCapabilityType;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DemoTest {
    public static String xml= "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<manifest\n" +
            "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    android:versionCode=\"21\"\n" +
            "    android:versionName=\"3.3.1\"\n" +
            "    android:compileSdkVersion=\"29\"\n" +
            "    android:compileSdkVersionCodename=\"10\"\n" +
            "    package=\"io.appium.android.apis\"\n" +
            "    platformBuildVersionCode=\"29\"\n" +
            "    platformBuildVersionName=\"10\">\n" +
            "\n" +
            "    <uses-sdk\n" +
            "        android:minSdkVersion=\"17\"\n" +
            "        android:targetSdkVersion=\"29\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.READ_CONTACTS\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.WRITE_CONTACTS\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.VIBRATE\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.ACCESS_COARSE_LOCATION\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.INTERNET\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.SET_WALLPAPER\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.SEND_SMS\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.RECEIVE_SMS\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.NFC\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.RECORD_AUDIO\" />\n" +
            "\n" +
            "    <uses-permission\n" +
            "        android:name=\"android.permission.CAMERA\" />\n" +
            "\n" +
            "    <uses-feature\n" +
            "        android:name=\"android.hardware.camera\" />\n" +
            "\n" +
            "    <uses-feature\n" +
            "        android:name=\"android.hardware.camera.autofocus\"\n" +
            "        android:required=\"false\" />\n</manifest>";

    public static void main(String[] args) {
// TODO Auto-generated method stub
        try {
            JSONObject json = XML.toJSONObject(xml);
            String jsonString = json.toString(4);
            System.out.println(jsonString);

        } catch (JSONException e) {
// TODO: handle exception
            System.out.println(e.toString());
        }
    }

        WebDriver driver;

    @Before
    public void setup() throws Exception {


        //desiredCapabilities.setCapability("platformName", "Android");
        //to specify test settings and required info about device and app under the test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new RemoteWebDriver(url, desiredCapabilities);
    }


    @Test
    public void mobileChromeTest() throws InterruptedException {
        driver.get("http://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER );
        Thread.sleep(3000);
    }

    @Test
    public void mobileChromeTest1() throws InterruptedException {
        driver.get("http://schemas.android.com/apk/res/android");

        Thread.sleep(3000);
    }
    public void tearDown(){
        driver.quit();
    }



}
