import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests  extends TestBase {

        @Test
        public void canRemoveContact() {
            openHomePage();
            if (!isContactPresent()) {
                openAddNewPage();
                createContact(new Contact());
            }
            removeContact();
        }
}
