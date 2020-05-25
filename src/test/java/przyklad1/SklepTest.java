package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class SklepTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void testSearchBoxPositive() throws InterruptedException {
        String[] products = {"white", "mug", "cushion", "notebook", "graphics"};
        Random random = new Random();

        for (int i=0; i<3; i++) {
            int randomInteger = random.nextInt(50);
            int productNum = randomInteger % products.length;

            System.out.println("Wylosowałem element numer: " + productNum);

            WebElement wyszukiwarka = driver.findElement(By.name("s"));
            wyszukiwarka.clear();
            wyszukiwarka.sendKeys(products[productNum]);
            wyszukiwarka.submit();

            Thread.sleep(2000);
        }
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
