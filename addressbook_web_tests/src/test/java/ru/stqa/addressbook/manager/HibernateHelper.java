package ru.stqa.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.manager.hbm.ContactRecord;
import ru.stqa.addressbook.manager.hbm.GroupRecord;
import ru.stqa.addressbook.model.Contact;
import ru.stqa.addressbook.model.Group;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    //конструктор, в котором передается ссылка на manager,
    //чтобы класс получил доступ к своему начальнику
    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        //создание фабрики сессий
        sessionFactory = new Configuration()
                        .addAnnotatedClass(ContactRecord.class)
                        .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL,
                        "jdbc:mysql://localhost/addressbook")
                // Credentials
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<Group> convertList(List<GroupRecord> records) {
        List<Group> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    private static Group convert(GroupRecord record) {
        return new Group("" + record.id, record.name, record.header, record.footer);
    }

    public List<Group> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }


//    static List<Contact> convertList(List<ContactRecord> records) {
//        List<Contact> result = new ArrayList<>();
//        for (var record : records) {
//            result.add(convert(record));
//        }
//        return result;
//    }
//
//    private static Contact convert(ContactRecord record) {
//        return new Contact("" + record.id, record.firstname, record.lastname, record.address);
//    }
//
//    public List<Contact> getContactList() {
//        return sessionFactory.fromSession(session -> {
//            return session.createQuery("from ContactRecord", ContactRecord.class).list();
//        });
//    }
}
