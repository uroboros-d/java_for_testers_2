import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        openAddNewPage();
        app.createContact(new Contact()
                .withLastname("firstname")
                .withFirstname("lastname")
                .withAddress("address"));
    }

    @Test
    public void canCreateContactWithEmptyProperties() {
        openAddNewPage();
        app.createContact(new Contact());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        openAddNewPage();
        app.createContact(new Contact()
                .withLastname("firstname only"));
    }
}