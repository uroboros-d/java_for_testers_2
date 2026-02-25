import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class GroupCreationTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://localhost/addressbook/index.php");
        driver.manage().window().setSize(new Dimension(862, 688));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }

    @AfterEach
    public void tearDown() {
        // логаут нет смысла выполнять - это случится автоматически при выполнении след команды
        // - закрытия браузера, поэтому пока его закомментируем
//        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test
    public void canCreateGroup() {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys("group");
        driver.findElement(By.name("group_header")).sendKeys("header");
        driver.findElement(By.name("group_footer")).sendKeys("footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
