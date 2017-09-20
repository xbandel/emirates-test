import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFlightTest extends AndroidSetup {
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void searchFlightTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickDoItLater();
        loginPage.helpWindow();
        HomeEmPage homePage = new HomeEmPage(driver);
        homePage.scrollDownAndTap(By.xpath(homePage.flightText));
        FlightSearchPage flightPage = new FlightSearchPage(driver);
        flightPage.enterCityAndDate("DXB", "LHR");
        flightPage.clickSearchFlights();
        flightPage.viewSearchResults();


    }
}
