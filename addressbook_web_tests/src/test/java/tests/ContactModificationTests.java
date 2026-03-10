package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase{

    @Test
    void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new Contact());
        }
        app.contacts().modifyContact();
    }
}
