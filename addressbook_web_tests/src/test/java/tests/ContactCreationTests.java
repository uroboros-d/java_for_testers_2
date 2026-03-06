package tests;

import model.Contact;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<Contact> contactProvider() {
        var result = new ArrayList<Contact>();
        for (var lastname : List.of("", "lastname")) {
            for (var firstname : List.of("", "firstname")) {
                for (var address : List.of("", "address")) {
                    result.add(new Contact()
                            .withLastname(lastname)
                            .withFirstname(firstname)
                            .withAddress(address));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new Contact()
                    .withLastname(randomString(i * 10))
                    .withFirstname(randomString(i * 10))
                    .withAddress(randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateContacts(Contact contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

//    @Test
//    public void canCreateContactWithEmptyProperties() {
//        app.contacts().createContact(new Contact());
//    }

//    @Test
//    public void canCreateContactWithNameOnly() {
//        app.contacts().createContact(new Contact()
//                .withLastname("firstname only"));
//    }
}