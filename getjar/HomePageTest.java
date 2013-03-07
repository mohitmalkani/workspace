package getjar.qa.developer_zone;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
    private FirefoxDriver driver;
    private static String host = "";

    public static void main(String args[]) {
        host = Utils.getHost(args);
        org.junit.runner.JUnitCore.main("getjar.qa.developer_zone.HomePageTest");
    }
    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        Utils.takeScreenShot(driver, this.getClass().getName());
        driver.close();
    }
    
    @Test
    public void testLinkss() {
        driver.get(HomePageTest.host);
        assertTrue("URL " + host + " returns empty page", driver.getPageSource().length() > Config.MIN_PAGE_SRC_LENGTH);
        new Utils().testPageLinks(driver);
    }

    @Test
    public void testLinksLoggedIn() {
        Utils.login(driver, host);
        new Utils().testPageLinks(driver);
    }
    
}