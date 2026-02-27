import model.Group;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        if (!isElementPresent(By.name("firstname"))) {
            driver.findElement(By.linkText("add new")).click();
        }
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("firstname");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("lastname");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("address");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    @Test
    public void canCreateContactWithEmptyProperties() {
        if (!isElementPresent(By.name("firstname"))) {
            driver.findElement(By.linkText("add new")).click();
        }
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    @Test
    public void canCreateContactWithNameOnly() {
        if (!isElementPresent(By.name("firstname"))) {
            driver.findElement(By.linkText("add new")).click();
        }
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("firstname only");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("home page")).click();
    }
}