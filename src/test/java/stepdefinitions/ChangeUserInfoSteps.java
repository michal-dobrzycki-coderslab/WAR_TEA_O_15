package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.UserInfoPage;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {
    UserInfoPage userInfoPage;
    WebDriver driver;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=identity");
        this.userInfoPage = new UserInfoPage(driver);
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
    }
}