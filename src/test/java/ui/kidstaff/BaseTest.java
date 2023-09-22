package ui.kidstaff;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void beforeTest() {
        Configuration.baseUrl = "https://login.kidstaff.com.ua";
    }
}
