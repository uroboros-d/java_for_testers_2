package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void canCreateGroup() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new Group()
                .withName("name/header/footer")
                .withHeader("header")
                .withFooter("footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new Group().withName("nameOnly"));
    }
}
