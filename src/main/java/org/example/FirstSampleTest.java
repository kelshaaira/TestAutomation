package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstSampleTest{
    //Positive Case
    @Test
    public void loginManual() throws MalformedURLException {
        AndroidDriver driver = getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login(driver);
        driver.findElement(AppiumBy.id("btn_login")).click();
        driver.findElement(AppiumBy.id("btn_logout")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Test
    public void loginBiometrics() throws MalformedURLException {
        AndroidDriver driver = getAndroidDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().className(\"\t\n" +
                        "btn_biometrics\"))"));

        driver.findElement(AppiumBy.id("btn_biometrics")).click();
        driver.findElement(AppiumBy.id("com.example.alfaresto_customersapp:id/et_email")). sendKeys("ariana@gmail.com");

        driver.findElement(AppiumBy.id("btn_login")).click();
        driver.findElement(AppiumBy.id("btn_logout")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Test
    public void addMenu() throws MalformedURLException {
        AndroidDriver driver = getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login(driver);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector().className(\"rv_menu\"))"));
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsHorizontalList().flingBackward()" +
                        ".scrollIntoView(new UiSelector().className(\"rv_menu\"))"));

        driver.findElement(AppiumBy.id("btn_all_menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().className(\"rv_list_all_menu\"))"));
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList().flingBackward()" +
                        ".scrollIntoView(new UiSelector().className(\"rv_list_all_menu\"))"));

        driver.findElement(AppiumBy.id("search_bar")).click();
        driver.findElement(AppiumBy.id("search_src_text")).sendKeys("Burger");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("btn_menu_add")).click();
        driver.findElement(AppiumBy.id("btn_add_order")).click();
        driver.findElement(AppiumBy.id("btn_cart")).click();
        driver.findElement(AppiumBy.id("iv_proceed")).click();
        driver.findElement(AppiumBy.id("btn_add_address")).click();
        driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
        driver.findElement(AppiumBy.accessibilityId("My Location")).click();
        driver.findElement(AppiumBy.id("et_address_label")).sendKeys("Alfa Tower");
        driver.findElement(AppiumBy.id("et_address_detail")).sendKeys("29th Floor");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().className(\"\t\n" +
                        "btn_save_address\"))"));
        driver.findElement(AppiumBy.id("btn_save_address")).click();
        driver.findElement(AppiumBy.id("cv_address")).click();
        driver.findElement(AppiumBy.id("btn_choose_address")).click();
        driver.findElement(AppiumBy.id("iv_icon_action")).click();
        driver.findElement(AppiumBy.id("rb_cod")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().className(\"\t\n" +
                        "btn_checkout_order\"))"));
        driver.findElement(AppiumBy.id("btn_checkout_order")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.id("btn_proceed")).click();
        driver.findElement(AppiumBy.accessibilityId("Order History")).click();
    }

    //Negative Case
    @Test
    public void loginManualFailed() throws MalformedURLException {
        AndroidDriver driver = getAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginFailed(driver);
        driver.findElement(AppiumBy.id("btn_login")).click();
        driver.findElement(AppiumBy.id("btn_logout")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    private void loginFailed(AndroidDriver driver) {
        driver.findElement(AppiumBy.id("et_email")).sendKeys("ariana@gmail.com");
        driver.findElement(AppiumBy.id("et_password")).sendKeys("Ariana123");
        driver.hideKeyboard();

    }

    private void login(AndroidDriver driver) {
        driver.findElement(AppiumBy.id("et_email")).sendKeys("ariana@gmail.com");
        driver.findElement(AppiumBy.id("et_password")).sendKeys("Ariana123!");
        driver.hideKeyboard();
    }

    private static AndroidDriver getAndroidDriver() throws MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName","UiAutomator2");
        capabilities.setCapability("appium:deviceName","5200802feeb735cf");
        capabilities.setCapability("appPackage", "com.example.alfaresto_customersapp");
        capabilities.setCapability("appActivity", "com.example.alfaresto_customersapp.ui.components.loginPage.LoginActivity");

        driver = new AndroidDriver(new URL("http://10.4.76.230:4723"), capabilities);
        return driver;
    }
}