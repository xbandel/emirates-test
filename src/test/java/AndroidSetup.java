import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup {

    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("/home/xenia/Downloads/appium-propertyFinder-master/apps");
        File app = new File(appDir, "paytm.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        String DEVICE_NAME = "FPFDU17709000681";
        String DEVICE_ORIENTATION = "portrait";

        String PLATFORM_VERSION = "5.1.1";
        String PLATFORM_NAME = "Android";
        String HUB_URL = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.6.4");
        caps.setCapability("deviceName", DEVICE_NAME);
        caps.setCapability("deviceOrientation", DEVICE_ORIENTATION);
        caps.setCapability("platformVersion", PLATFORM_VERSION);
        caps.setCapability("platformName", PLATFORM_NAME);
        caps.setCapability("fullReset", "false");
        caps.setCapability("locationServicesAuthorized", true);
        caps.setCapability("appActivity", "net.one97.paytm.AJRJarvisSplash");
        caps.setCapability("appPackage", "net.one97.paytm");
        caps.setCapability("autoAcceptAlerts", true);

    }
}
