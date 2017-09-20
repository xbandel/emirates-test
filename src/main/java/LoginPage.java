import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public static String doItLaterBtn = "//android.widget.TextView[1]";
    public static String helpOverlay = "net.one97.paytm:id/help_overlay";

    private static AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public static void clickDoItLater() {
        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath(doItLaterBtn)));
        AndroidElement laterButton = (AndroidElement) driver.findElement(By.xpath(doItLaterBtn));
        laterButton.tap(1, 1);
    }

    public static void helpWindow() {
        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath(helpOverlay)));
        AndroidElement helpOver = (AndroidElement) driver.findElement(By.id(helpOverlay));
        helpOver.click();
    }


}


