import model.Group;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup(new Group("group", "header", "footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupsPage();
        createGroup(new Group().withName("name"));
    }
}
