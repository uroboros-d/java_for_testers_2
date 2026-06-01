package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.model.Group;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<Contact> contactProvider() {
        var result = new ArrayList<Contact>();
//        for (var lastname : List.of("", "lastname")) {
//            for (var firstname : List.of("", "firstname")) {
//                for (var address : List.of("", "address")) {
//                    result.add(new Contact()
//                            .withLastname(lastname)
//                            .withFirstname(firstname)
//                            .withAddress(address)
//                            .withPhoto(randomFile("src/test/resources/images")));
//                }
//            }
//        }
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"),  new TypeReference<List<Contact>>(){});
        result.addAll(value);
        return result;
    }

    public static List<Contact> singleRandomContact() {
        return List.of(new Contact()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images")));
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateContacts(Contact contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<Contact> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id())
                .withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
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