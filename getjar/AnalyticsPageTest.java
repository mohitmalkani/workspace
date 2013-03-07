package getjar.qa.developer_zone;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AnalyticsPageTest {
    private FirefoxDriver driver;
    private static String host = "";

    public static void main(String args[]) {
        host = Utils.getHost(args);
        org.junit.runner.JUnitCore.main("getjar.qa.developer_zone.AnalyticsPageTest");
    }

    private void selectApp() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}

        WebElement selectList = driver.findElement(By.id("list_appSelectList"));
        selectList.findElement(By.tagName("a")).click();
        selectList.findElements(By.className("item")).get(1).click();
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        Utils.login(driver, host);
        driver.findElement(By.linkText("ANALYTICS")).click();
    }

    @After
    public void tearDown() {
        Utils.takeScreenShot(driver, this.getClass().getName());
        driver.close();
    }
    
    @Test
    public void testAppItServicePage() {
        driver.findElement(By.linkText("App It! Service")).click();
        selectApp();
        new Utils().testPageLinks(driver);
    }

   /*@Test
    public void testChannelStatsPage() {
        driver.findElement(By.linkText("Channel Stats")).click();
        new Utils().testPageLinks(driver);
    }*/

   /* @Test
    public void testConversionsPage() {
        driver.findElement(By.linkText("Conversions")).click();
        selectApp();
        new Utils().testPageLinks(driver);
    }*/
    
    //@Test
    public void testCoverageTrendsPage() {
        driver.findElement(By.linkText("Coverage Trends")).click();
        selectApp();
        new Utils().testPageLinks(driver);
    }

    //@Test
    public void testDownloadsPage() {
        driver.findElement(By.linkText("Downloads")).click();
        selectApp();
        new Utils().testPageLinks(driver);
    }

    //@Test
    public void testPromotionsPage() {
        driver.findElement(By.linkText("Promotions")).click();
        WebElement selectList = driver.findElement(By.id("list_campaignSelectList"));
        selectList.findElement(By.tagName("a")).click();
        selectList.findElements(By.className("item")).get(1).click();
        new Utils().testPageLinks(driver);
    }

   /*@Test
    public void testSalesPage() {
        driver.findElement(By.linkText("Sales")).click();
        new Utils().testPageLinks(driver);
    }*/

}