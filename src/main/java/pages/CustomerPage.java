package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
