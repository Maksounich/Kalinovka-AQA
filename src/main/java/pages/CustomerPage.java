package pages;

import core.BasePage;
import core.ContainerDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage {

    @FindBy(id = "userSelect")
    private WebElement userSelect;

    @FindBy(xpath = "//button[contains(text(),\"Login\")]")
    private WebElement loginBtn;


    public AccountPage selectUser(String userName) {
        selectByText(userSelect, userName);
        click(loginBtn);
        return new AccountPage();
    }
}
