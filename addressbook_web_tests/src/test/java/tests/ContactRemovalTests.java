package tests;

import model.Contact;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests  extends TestBase {

        @Test
        public void canRemoveContact() {
            if (app.contacts().getCount() == 0) {
                app.contacts().createContact(new Contact());
            }
            int contactCount = app.contacts().getCount();
            app.contacts().removeContact();
            int newContactCount = app.contacts().getCount();
            Assertions.assertEquals(contactCount - 1, newContactCount);
        }

    @Test
    public void canRemoveAllContactsAtOnce() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new Contact());
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
