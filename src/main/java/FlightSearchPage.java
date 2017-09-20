import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FlightSearchPage {
    public static String depField = "//android.widget.RelativeLayout[@resource-id='net.one97.paytm:id/source_city']";
    public static String cityField = "//android.widget.EditText[@resource-id='net.one97.paytm:id/city_search']";
    public static String searchResult = "//android.widget.LinearLayout[1]";
    public static String dateTitle = "//android.widget.TextView[@text='Select Depart Date']";
    public static String date = "//android.widget.TextView[@text='23\n' + '\n' + '₹14,545']";
    public static String searchBtn = "//android.widget.Button[@resouce-id='net.one97.paytm:id/proceed_btn']";
    public static String searchResult2 = "//android.widget.TextView[@resource-id='net.one97.paytm:id/id_flight_price']";

    private static AndroidDriver driver;

    public FlightSearchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, 20);

    public void enterCityAndDate(String sourceCity, String destinationCity) {
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(depField)));
        AndroidElement dep = (AndroidElement) driver.findElement(By.xpath(depField));
        dep.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityField)));
        AndroidElement city = (AndroidElement) driver.findElement(By.xpath(cityField));
        city.sendKeys(sourceCity);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResult)));
        AndroidElement citySelect = (AndroidElement) driver.findElement(By.xpath(searchResult));
        citySelect.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityField)));
        AndroidElement city2 = (AndroidElement) driver.findElement(By.xpath(cityField));
        city2.sendKeys(destinationCity);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResult)));
        AndroidElement citySelect2 = (AndroidElement) driver.findElement(By.xpath(searchResult));
        citySelect2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dateTitle)));
        AndroidElement dateSelect = (AndroidElement) driver.findElement(By.xpath(date));
        dateSelect.click();

    }


    public void clickSearchFlights() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchBtn)));
        AndroidElement search = (AndroidElement) driver.findElement(By.xpath(searchBtn));
        search.click();
    }

    public void viewSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResult2)));

        List<AndroidElement> prices = driver.findElements(By.xpath(searchResult2));
        Double prev = null;
        for (AndroidElement ae : prices) {
            String s = ae.getText();
            Assert.assertNotNull(s);
            String sPrice = s.split(" ")[1];
            Assert.assertNotNull(sPrice);
            Double dPrice = Double.valueOf(sPrice);
            Assert.assertTrue(prev == null || prev < dPrice);
            prev = dPrice;
        }
    }

}
