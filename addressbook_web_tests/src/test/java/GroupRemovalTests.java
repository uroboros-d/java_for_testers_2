import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupRemovalTests extends TestBase{

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup( "", "", "");
        }
        removeGroup();
        driver.findElement(By.linkText("Logout")).click();
    }

    private boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    private static void removeGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
