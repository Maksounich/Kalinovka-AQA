import core.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CustomerPage;
import pages.LoginPage;

public class TrxTest extends BaseTest {

    LoginPage loginPage;
    CustomerPage customerPage;
    AccountPage accountPage;
    @Test
    public void transactions(){
        loginPage = new LoginPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();

        loginPage.getCustomerLogin()
                .selectUser("2")
                .selectAccount("1006")
                .depositeAmount("100")
                .assertDepositTrx()
                .withdrawlAmount("100")
                .assertWithdrawlTrx();
    }
}
