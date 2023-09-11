package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsPage {
    public static final By COMPARE = By.xpath(".//span[text()='Сравнить']");
    private WebDriver driver;

    public GoodsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void compareClick() throws InterruptedException {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(COMPARE));
        driver.findElement(COMPARE).click();
        Thread.sleep(5000);
    }
}
