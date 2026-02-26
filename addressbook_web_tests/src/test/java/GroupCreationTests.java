import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTests {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("https://localhost/addressbook/index.php");
            driver.manage().window().setSize(new Dimension(862, 688));
            driver.findElement(By.name("user")).click();
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).click();
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    @Test
    public void canCreateGroup() {
        if (! isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys("group");
        driver.findElement(By.name("group_header")).sendKeys("header");
        driver.findElement(By.name("group_footer")).sendKeys("footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        if (! isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys("");
        driver.findElement(By.name("group_header")).sendKeys("");
        driver.findElement(By.name("group_footer")).sendKeys("");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
