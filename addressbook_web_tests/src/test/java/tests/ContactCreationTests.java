package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new Contact()
                .withLastname("firstname")
                .withFirstname("lastname")
                .withAddress("address"));
    }

    @Test
    public void canCreateContactWithEmptyProperties() {
        app.contacts().createContact(new Contact());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new Contact()
                .withLastname("firstname only"));
    }
}