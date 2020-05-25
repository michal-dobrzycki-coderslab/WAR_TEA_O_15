package junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @Test
    public void loginTests(){
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");

        Assert.assertEquals("Automated Tester", loginPage.getLoggedUserName());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
