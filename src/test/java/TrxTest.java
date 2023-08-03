import Asserts.Assertion;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CustomerPage;
import pages.LoginPage;

public class TrxTest extends BaseTest {


    private final String userValue = "Harry Potter";
    private final String accountValue = "1006";
    private final String deposit = "100";
    private final String withdrawl = "100";

    @Test
    public void transactions(){
        LoginPage loginPage = new LoginPage();
        CustomerPage customerPage = new CustomerPage();
        AccountPage accountPage = new AccountPage();
        Assertion assertion = new Assertion();

        loginPage.clickCustomerLogin()
                .selectUser(userValue)
                .selectAccount(accountValue)
                .depositeAmount(deposit);
        assertion.assertText(accountPage.getTrxInfo(),"Deposit Successful");
        accountPage.withdrawlAmount(withdrawl);
        assertion.assertText(accountPage.getTrxInfo(), "Transaction successful");
    }
}
