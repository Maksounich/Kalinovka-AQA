package tests;

import driver.Browser;
import driver.DriverFactory;
import driver.DriverPoll;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utiles.Config;
import utiles.PropertiesUtil;

public abstract class TestInit {

    @BeforeMethod
    public void setUpDriver() {
        WebDriver driver = DriverFactory.getDriver(Browser.CHROME);
        DriverPoll.setWebDriver(driver);
        Config.setBaseUrl(PropertiesUtil.getProperty("url"));
    }

    @AfterMethod
    public void quiteDriver() {
        DriverPoll.quitDriver();
    }
}
