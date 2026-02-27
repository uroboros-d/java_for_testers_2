import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.openAddNewPage();
        app.createContact(new Contact()
                .withLastname("firstname")
                .withFirstname("lastname")
                .withAddress("address"));
    }

    @Test
    public void canCreateContactWithEmptyProperties() {
        app.openAddNewPage();
        app.createContact(new Contact());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.openAddNewPage();
        app.createContact(new Contact()
                .withLastname("firstname only"));
    }
}