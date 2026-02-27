import model.Group;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.openGroupsPage();
        if (!isGroupPresent()) {
            app.createGroup(new Group());
        }
        removeGroup();
    }
}
