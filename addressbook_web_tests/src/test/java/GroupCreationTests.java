import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase{

    @Test
    public void canCreateGroup() {
        if (! isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        createGroup("group", "header", "footer");
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        if (! isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        createGroup("", "", "");
    }

}
