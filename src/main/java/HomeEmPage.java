import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomeEmPage {

    public static String recharge = "android.widget.TextView[@text='Recharge or Pay for']";
    public static String flightText = "//android.widget.TextView[@text='Flights']";

    private static AndroidDriver driver;

    public HomeEmPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollDownTo(By byOfElementToBeFound) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(recharge)));
        int i = 0;
        while (i < 12) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;

            scrollDown();

            i++;
        }
        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    public void scrollDownAndTap(By byOfElementToBeFound) {
        scrollDownTo(byOfElementToBeFound);
        driver.findElement(byOfElementToBeFound).click();
    }


    public void scrollDown() {
        int height = driver.manage().window().getSize().getHeight();

        driver.swipe(5, height * 2 / 3, 5, height / 3, 1000);
    }


}

