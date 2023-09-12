package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GoodiesPage {
    public static final By PRICE_FROM = By.xpath(".//div[@data-filter-id='glprice']//input[@class='_3qxDp _37_h4']");
    public static final By PRICE_TO = By.xpath(".//div[@data-filter-id='glprice']//input[@class='_3qxDp _1R_cW']");
    public static final By COURIER = By.xpath(".//span[text()='Курьером']");
    public static final By SHOW_ALL = By.xpath(".//span[text()='Показать всё']");
    public static final By BRAND = By.xpath(".//input[@class='_3qxDp']");
    public static final By BRAND1_CHECKBOX = By.xpath(".//span[text()='Dreamies']");
    public static final By BRAND2_CHECKBOX = By.xpath(".//span[text()='Мнямс']");
    private static final String PAGE_URL2 = "https://market.yandex.ru/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668";
    public static final By BRAND1_LOC = By.xpath(".//span[text()='Сухой корм для котов Dreamies Лакомые подушечки c курицей 30г']");
    public static final By BRAND2_LOC = By.xpath(".//span[text()='Мнямс палочки для кошек, говядина с печенью 13,5 см, 3 шт. х 5 гр.']");

    private WebDriver driver;

    public GoodiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL2);
    }

    public void priceFrom(String PRICE1) {
        WebElement price1 = driver.findElement(PRICE_FROM);
        price1.click();
        price1.sendKeys(PRICE1);
    }

    public void priceTo(String PRICE2) {
        WebElement price2 = driver.findElement(PRICE_TO);
        price2.click();
        price2.sendKeys(PRICE2);
    }

    public void price(String PRICE1, String PRICE2) {
        priceFrom(PRICE1);
        priceTo(PRICE2);
    }

    public void deliverCourier() throws InterruptedException {
        driver.findElement(COURIER).click();
        Thread.sleep(15000);
    }

    public void showAll() {
        driver.findElement(SHOW_ALL).click();
    }


    public void brand1(String BRAND_TEXT) throws InterruptedException {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(BRAND));
        WebElement brand = driver.findElement(BRAND);
        brand.click();
        brand.clear();
        brand.sendKeys(BRAND_TEXT);
        brand1Checkbox();
        brand1Loc();
    }

    public void brand2(String BRAND_TEXT) throws InterruptedException {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(BRAND));
        WebElement brand = driver.findElement(BRAND);
        brand.click();
        brand.clear();
        brand.sendKeys(BRAND_TEXT);
        brand2Checkbox();
        brand2Loc();
    }


    public void brand1Checkbox() throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(BRAND1_CHECKBOX));
        driver.findElement(BRAND1_CHECKBOX).click();
    }

    public void brand2Checkbox() throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(BRAND2_CHECKBOX));
        driver.findElement(BRAND2_CHECKBOX).click();
    }

    public void brand1Loc() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(BRAND1_LOC).click();
    }

    public void brand2Loc() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(BRAND2_LOC).click();
    }

    public void switchWindow() {
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
    }
}
