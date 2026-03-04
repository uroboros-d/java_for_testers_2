package tests;

import model.Contact;
import model.Group;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group());
        }
        app.groups().modifyGroup(new Group()
                .withName("modified name")
                .withHeader("modified header")
                .withFooter("modified footer"));
    }
}
