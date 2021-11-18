import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1280, 800));

        driver.navigate().to("https://fakestore.testelka.pl/");
        driver.findElement(By.xpath(".//p/a")).click();
    }

    @AfterEach
    public void quitWebDriver(){
        driver.quit();
    }
}
