package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class KatalonFormTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    private void superWriter(WebElement element, String x2) {
        element.click();
        element.clear();
        element.sendKeys(x2);
    }

    @Test
    public void testSearchBoxPositive() {
        String DATE_FORMATTER= "yyyyMMdd-HHmmss";

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = localDateTime.format(formatter);

        WebElement firstName = driver.findElement(By.id("first-name"));
        superWriter(firstName, "Tymoteusza");

        WebElement lastName = driver.findElement(By.id("last-name"));
        superWriter(lastName, "Kowalski");

        WebElement email = driver.findElement(By.id("email"));
        superWriter(email, "mail+"+ formatDateTime + "@test.com");


        // tutaj genederList.get(0) - pobierze element pierwszy Male
        // tutaj genederList.get(1) - pobierze element drugi Female
        // tutaj genederList.get(2) - pobierze element trzeci In Between
        List<WebElement> genderList = driver.findElements(By.name("gender"));
        WebElement maleGender = genderList.get(2);
        maleGender.click();

        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");


        // .get(0) -> Read Books
        // .get(1) -> Take Online Courses
        List<WebElement> waysOfDevelopment = driver.findElements(By.xpath("//input[@type='checkbox']"));

        waysOfDevelopment.get(0).click();
        waysOfDevelopment.get(2).click();
        waysOfDevelopment.get(4).click();
    }


    @After
    public void tearDown() {
        //driver.quit();
    }
}
