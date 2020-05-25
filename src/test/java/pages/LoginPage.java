package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name="email")
    private WebElement loginInput;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(id="submit-login")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void loginAs(String user, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(user);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();
    }

    public String getLoggedUserName() {
        WebElement loggedUserName = driver.findElement(By.xpath("//a[@class='account']"));
        return loggedUserName.getText();
    }
}
