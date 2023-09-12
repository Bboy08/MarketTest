import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }
}
