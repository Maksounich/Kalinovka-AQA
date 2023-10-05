package ui.aliexpress;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeTest() {
        Configuration.baseUrl = "https://login.aliexpress.com/";
    }

}
