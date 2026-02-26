import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase{

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
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys("");
        driver.findElement(By.name("group_header")).sendKeys("");
        driver.findElement(By.name("group_footer")).sendKeys("");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

}
