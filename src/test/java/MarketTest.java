import org.junit.Test;
import org.openqa.selenium.By;
import pageobject.ComparePage;
import pageobject.GoodiesPage;
import pageobject.GoodsPage;
import pageobject.MarketPage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MarketTest extends BaseTest {
    private final String PRICE1 = "50";
    private final String PRICE2 = "150";
    public final String BRAND1 ="Dreamies";
    public final String BRAND2 ="Мнямс";
    public final String EXPECTED_BRAND1 ="Лакомство для кошек Dreamies Подушечки с курицей";
    public final String EXPECTED_BRAND2 ="Мнямс палочки для кошек, говядина с печенью 13,5 см, 3 шт. х 5 гр.";

    @Test
    public void testYandexMarket() throws InterruptedException {
        MarketPage marketPage = new MarketPage(driver);
        GoodiesPage goodiesPage = new GoodiesPage(driver);
        GoodsPage goodsPage = new GoodsPage(driver);
        ComparePage comparePage = new ComparePage(driver);
        marketPage.openPage();
        marketPage.clickCatalog();
        marketPage.clickGoodies();
        goodiesPage.price(PRICE1, PRICE2);
        goodiesPage.deliverCourier();
        goodiesPage.showAll();
        goodiesPage.brand1(BRAND1);
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        goodsPage.compareClick();
        driver.close();
        driver.switchTo().window((String) tabs2.get(0));
        goodiesPage.brand1Checkbox();
        goodiesPage.brand2(BRAND2);
        ArrayList tabs3 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs3.get(1));
        goodsPage.compareClick();
        driver.close();
        driver.switchTo().window((String) tabs3.get(0));
        comparePage.openPage();
        assertEquals(EXPECTED_BRAND1, driver.findElement(comparePage.BRAND1).getText());
        assertEquals(EXPECTED_BRAND2, driver.findElement(comparePage.BRAND2).getText());
        comparePage.deleteGood1();
        assertFalse(comparePage.isElementPresent1(ComparePage.BRAND1));
        comparePage.deleteGood();
        assertEquals("Сравнивать пока нечего", driver.findElement(By.xpath(".//h2[text()='Сравнивать пока нечего']")).getText());
    }
}
