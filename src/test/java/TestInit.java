import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class TestInit {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().get("https://www.book-ye.com.ua/");
        Thread.sleep(1000);
    }

   /* @AfterMethod
    public void finish()
    {
        driver.get().quit();
    }*/

    public WebDriver getDriver()
    {
       return driver.get();
    }
}
