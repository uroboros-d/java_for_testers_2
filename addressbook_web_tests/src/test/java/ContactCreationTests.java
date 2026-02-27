import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        openAddNewPage();
        createContact(new Contact()
                .withLastname("firstname")
                .withFirstname("lastname")
                .withAddress("address"));
    }

    @Test
    public void canCreateContactWithEmptyProperties() {
        openAddNewPage();
        createContact(new Contact());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        openAddNewPage();
        createContact(new Contact()
                .withLastname("firstname only"));
    }
}