package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage {

    @FindBy(id = "userSelect")
    private WebElement userSelect;

    @FindBy(xpath = "//button[contains(text(),\"Login\")]")
    private WebElement loginBtn;

    public CustomerPage() {
        PageFactory.initElements(driver, this);
    }

    public AccountPage selectUser(String userValue){
        Select select = new Select(userSelect);
        select.selectByValue(userValue);
        loginBtn.click();
        return new AccountPage();
    }
}
