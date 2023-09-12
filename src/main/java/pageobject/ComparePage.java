package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class ComparePage {
    private static final String COMPARE_URL = "https://market.yandex.ru/compare/";
    public static final By BRAND1 = By.xpath(".//a[text()='Лакомство для кошек Dreamies Подушечки с курицей']");
    public static final By BRAND2 = By.xpath(".//a[text()='Мнямс палочки для кошек, говядина с печенью 13,5 см, 3 шт. х 5 гр.']");
    public static final By DELETE1 = By.xpath(".//div[@class='_3_z1Z']");
    public static final By DELETE = By.xpath(".//button[text()='Удалить список']");
    private WebDriver driver;
    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(COMPARE_URL);
    }

    public void deleteGood1() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(BRAND1);
        action.moveToElement(element).perform();
        Thread.sleep(5000);
        List<WebElement> list1 = driver.findElements(DELETE1);;
        WebElement e = list1.get(1);
        e.click();
        Thread.sleep(5000);
    }


    public boolean isElementPresent1(By DREAMIES) {
        try {
            return driver.findElement(DREAMIES).isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }
    public void deleteGood() throws InterruptedException {
        driver.findElement(DELETE).click();
        Thread.sleep(5000);
    }
}
