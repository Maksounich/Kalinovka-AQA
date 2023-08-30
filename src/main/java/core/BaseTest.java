package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.PropertyReader;



public abstract class BaseTest {
    @BeforeMethod
    public void  openBrowser(){
        Selenide.open(PropertyReader.getProp("url"));
    }

    @BeforeSuite
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
