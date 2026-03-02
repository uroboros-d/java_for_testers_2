package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests  extends TestBase {

        @Test
        public void canRemoveContact() {
            app.contacts().openHomePage();
            if (!app.contacts().isContactPresent()) {
                app.contacts().openAddNewPage();
                app.contacts().createContact(new Contact());
            }
            app.contacts().removeContact();
        }
}
