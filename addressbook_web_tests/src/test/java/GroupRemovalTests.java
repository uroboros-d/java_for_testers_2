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
}
