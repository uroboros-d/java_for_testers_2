package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.groups().openGroupsPage();
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new Group());
        }
        app.groups().removeGroup();
    }
}
