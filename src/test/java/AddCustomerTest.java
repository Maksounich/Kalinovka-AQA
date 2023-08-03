import Asserts.Assertion;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;

public class AddCustomerTest extends BaseTest {
    private final String firstName = "Dobby";
    private final String lastName = "Gnome";
    private final String postCode = "007";
    private final String currency = "Dollar";

    @Test
    public void addcCustomerTest(){
        LoginPage loginPage = new LoginPage();
        CustomerPage customerPage = new CustomerPage();
        AccountPage accountPage = new AccountPage();
        Assertion assertion = new Assertion();

        loginPage.clickManagerLogin()
                .addCustomer(firstName,lastName,postCode)
                .clickOpenAccount()
                .selectUser(firstName + " " + lastName)
                .selectCurrency(currency)
                .clickProcess();
    }

    @Test
    public void cust(){
        LoginPage loginPage = new LoginPage();
        CustomerPage customerPage = new CustomerPage();
        AccountPage accountPage = new AccountPage();
        Assertion assertion = new Assertion();

        loginPage.goHome()
                .clickCustomerLogin()
                .selectUser(firstName + " " + lastName)
                .selectAccount("1016")
                .depositeAmount("100");
        assertion.assertText(accountPage.getTrxInfo(),"Deposit Successful");
        accountPage.withdrawlAmount("100");
        assertion.assertText(accountPage.getTrxInfo(), "Transaction successful");
    }
}
