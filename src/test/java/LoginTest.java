import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static constants.Const.BASE_URL;

public class LoginTest extends TestInit {
    @Test
    public void loginUserTest()
    {
        Selenide.open(BASE_URL);

        mainBarPage.clickUserBtn();
        loginRegPage.login("deneek202@gmail.com", "B60zz%NGBy(q");
    }
}
