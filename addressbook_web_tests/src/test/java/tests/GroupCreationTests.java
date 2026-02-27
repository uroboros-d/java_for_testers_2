package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void canCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new Group()
                .withName("name/header/footer")
                .withHeader("header")
                .withFooter("footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.openGroupsPage();
        app.createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.openGroupsPage();
        app.createGroup(new Group().withName("nameOnly"));
    }
}
