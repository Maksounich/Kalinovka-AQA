import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;
import utilities.Assertions;
import utilities.PropertyReader;

public class Test1 extends BaseTest {
    private LoginPage loginPage;
    private CustomerPage customerPage;
    private AccountPage accountPage;
    private ManagerPage managerPage;
    private Assertions assertions;
    private final String firstName = PropertyReader.getProp("FirstName");
    private final String lastName = PropertyReader.getProp("LastName");
    private final String postCode = PropertyReader.getProp("PostCode");
    private final String currency = PropertyReader.getProp("Currency");

    @BeforeMethod
    public void openBrowser(){
        loginPage = new LoginPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();
        managerPage = new ManagerPage();
        assertions = new Assertions();
    }

    @Test
    public void addcCustomerTest() {
        loginPage.clickManagerLogin()
                .addCustomer(firstName, lastName, postCode)
                .clickOpenAccount()
                .selectUser(firstName + " " + lastName)
                .selectCurrency(currency)
                .clickProcess()
                .clickCustomers()
                .searchCustomer(firstName);
        assertions.assertBtn(managerPage.getDeleteBtn());
        loginPage.goHome()
                .clickCustomerLogin()
                .selectUser(firstName + " " + lastName)
                .selectAccount("1016")
                .depositeAmount("100");
        assertions.assertText(accountPage.getTrxInfo(), "Deposit Successful");
        accountPage.withdrawlAmount("100");
        assertions.assertText(accountPage.getTrxInfo(), "Transaction successful");
    }

    @Test
    public void checkCustomerLoginBtn(){
        assertions.assertText(loginPage.getCustomerLoginBtn(), "Customer Login");
        loginPage.clickCustomerLogin();
        assertions.urlContains("customer");
    }
}
