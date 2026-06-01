package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.model.Contact;
import ru.stqa.addressbook.model.Group;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {

    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<Group> getGroupList() {
        var groups = new ArrayList<Group>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery(
                     "SELECT group_id, group_name, group_header, group_footer FROM group_list")) {
            while (result.next()) {
                groups.add(new Group()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<Contact> getContactList() {
        var contacts = new ArrayList<Contact>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery(
                     "SELECT id, firstname, lastname, address FROM addressbook")) {
            while (result.next()) {
                contacts.add(new Contact()
                        .withId(result.getString("id"))
                        .withFirstname(result.getString("firstname"))
                        .withLastname(result.getString("lastname"))
                        .withAddress(result.getString("address")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}
