package getjar.qa.developer_zone;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllAppsPageTest {
    private FirefoxDriver driver;
    private static String host = "";

    public static void main(String args[]) {
        host = Utils.getHost(args);
        org.junit.runner.JUnitCore.main("getjar.qa.developer_zone.AllAppsPageTest");
    }
    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        Utils.login(driver, host);
        driver.findElement(By.linkText("PUBLISHING")).click();
        driver.findElement(By.linkText("Apps and Sites")).click();
    }
    
    @After
    public void tearDown() {
        Utils.takeScreenShot(driver, this.getClass().getName());
        driver.close();
    }

    @Test
    public void testLinks() {
        new Utils().testPageLinks(driver);
    }

    @Test
    public void testPaging() {
        Utils.testPaging(driver);
    }
    
}