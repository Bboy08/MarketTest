package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage {
    private static final String PAGE_URL = "https://market.yandex.ru/";

    private static final By CATALOG = By.id("hamburger");
    private static final By ZOO = By.xpath(".//span[text()='Зоотовары']");
    private static final By GOODIES = By.xpath(".//a[@href='/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668']");
    private WebDriver driver;

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void clickCatalog() {
        driver.findElement(CATALOG).click();
    }

    public void waitZoo()  {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(ZOO));

    }


    public void clickGoodies() throws InterruptedException {
        waitZoo();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(ZOO);
        Thread.sleep(3000);
        action.moveToElement(element).perform();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(GOODIES));
        WebElement element2 = driver.findElement(GOODIES);
        action.moveToElement(element2).perform();
        action.click(element2).perform();

    }
}
