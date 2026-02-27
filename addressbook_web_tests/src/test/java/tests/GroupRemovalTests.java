package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new Group());
        }
        app.removeGroup();
    }
}
