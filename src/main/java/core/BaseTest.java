package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyReader;



public abstract class BaseTest {

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Selenide.open(PropertyReader.getProp("url"));
    }

    @AfterClass
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
