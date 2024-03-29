package getjar.qa.developer_zone;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddNewPPDPromotionTest {
    private FirefoxDriver driver;
    private static String host = "";
    private String testImagePath = Config.PATH_TEST_IMAGES;

    public static void main(String args[]) {
        host = Utils.getHost(args);
        org.junit.runner.JUnitCore.main("getjar.qa.developer_zone.AddNewPPDPromotionTest");
    }

    private String generateTestName() {
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return "Test " + year + " " + (month + 1) + " " + day + "  " + hour + " " + minute + " " + second;
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        Utils.login(driver, host);
        driver.findElement(By.linkText("PROMOTIONS")).click();
        driver.findElement(By.linkText("Pay per Download")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
    }

    @After
    public void tearDown() {
        Utils.takeScreenShot(driver, this.getClass().getName());
        driver.close();
    }

    @Test
    public void testSuccess() {
        driver.findElement(By.linkText("New PPD Promotion")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
        WebElement selectList = driver.findElement(By.id("list_softId"));
        selectList.findElement(By.tagName("a")).click();
        selectList.findElements(By.className("item")).get(1).click();
        
        driver.findElement(By.name("campaignName")).sendKeys(generateTestName());
        driver.findElement(By.name("mobileAdText")).sendKeys("mobile ad text");
        driver.findElement(By.name("mobileAdGraphic")).sendKeys(testImagePath + "test_50.png");
        driver.findElement(By.name("mobileHeaderGraphic")).sendKeys(testImagePath + "test_225x118.png");
        driver.findElement(By.name("mediumRectangularIMU")).sendKeys(testImagePath + "test_300x250.png");
        driver.findElement(By.id("start_campaign")).click();

        String[] urlParts = driver.getCurrentUrl().split("\\?");
        String baseUrl = urlParts[0];
        assertEquals("After new PPD Promotion submit URL is incorrect", baseUrl, host + "/publishing/target/");
    }
    
}