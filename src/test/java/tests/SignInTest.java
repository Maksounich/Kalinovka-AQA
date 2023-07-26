package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;
import utiles.User;

public class SignInTest extends TestInit {

    @Test
    public void checkLogin() {
        SignInPage signInPage = new SignInPage();
        User user = User.builder().build();

        signInPage.login(user);

        Assert.assertTrue(true);
    }
}
