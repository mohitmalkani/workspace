package getjar.qa.developer_zone;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OtherPagesTest {
    private FirefoxDriver driver;
    private static String host = "";

    public static void main(String args[]) {
        host = Utils.getHost(args);
        org.junit.runner.JUnitCore.main("getjar.qa.developer_zone.OtherPagesTest");
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        Utils.login(driver, host);
    }

    @After
    public void tearDown() {
        Utils.takeScreenShot(driver, this.getClass().getName());
        driver.close();
    }

    @Test
    public void testAboutPages() {
        driver.findElement(By.linkText("PUBLISHING")).click();
        driver.findElement(By.linkText("- Publishing")).click();
        new Utils().testPageLinks(driver);
    }

    @Test
    public void testUserFeedbackPages() {
        driver.findElement(By.linkText("TOOLS")).click();
        driver.findElement(By.linkText("- Reviews")).click();
        new Utils().testPageLinks(driver);
    }

    /*@Test
    public void testConversionsPage() {
        driver.findElement(By.linkText("TOOLS")).click();
        driver.findElement(By.linkText("Conversions")).click();
        new Utils().testPageLinks(driver);
    }*/

    /*@Test
    public void testPaymentsPage() {
        driver.findElement(By.linkText("TOOLS")).click();
        driver.findElement(By.linkText("Payments")).click();
        new Utils().testPageLinks(driver);
    }*/

}