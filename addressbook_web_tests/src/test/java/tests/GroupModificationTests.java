package tests;

import model.Contact;
import model.Group;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    public void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group());
        }
        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().modifyGroup(oldGroups.get(index), new Group()
                .withName("modified name")
                .withHeader("modified header")
                .withFooter("modified footer"));
    }
}
