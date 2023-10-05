package ui.aliexpress;

import org.myProject.ui.aliexpress.LoginPage;
import org.myProject.ui.kidstaff.SignInPage;
import org.testng.annotations.Test;

public class LoginTest  {


//    @Test
//    public void loginTest() {
//        new SignInPage()
//                .open()
//                .setEmail("lili.korgik@gmail.com")
//                .setPassword("Korgik123")
//                .clickSignInBtn()
//                .isPresent();
//    }

    @Test
    public void loginTest() {
        new LoginPage()
                .open()
                .setEmail("lili.korgik@gmail.com")
                .setPassword("1_1C@r@Mel1_1")
                .clickLoginBtn()
                .isPresent();
    }


}
