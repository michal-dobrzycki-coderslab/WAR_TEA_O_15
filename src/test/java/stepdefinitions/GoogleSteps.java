package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {
    private WebDriver driver;

    @Given("I open website (.*)")
    public void openWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Then("Google website is loaded")
    public void checkIfElement() {
        System.out.println("I got here.");
    }
}
