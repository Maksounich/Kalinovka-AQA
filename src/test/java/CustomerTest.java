import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagerPage;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    ManagerPage managerPage;

    @Test
    public void customerTest(){
        loginPage = new LoginPage();
        managerPage = new ManagerPage();

        String firstName = "Dobby";
        String lastName = "Gnome";
        String postCode = "007";
        String currency = "Dollar";

        loginPage.getManagerLogin()
                .addCustomer(firstName,lastName,postCode)
                .clickOpenAccount()
                .selectUser(firstName + " " + lastName)
                .selectCurrency(currency)
                .clickProcess();
    }
}
