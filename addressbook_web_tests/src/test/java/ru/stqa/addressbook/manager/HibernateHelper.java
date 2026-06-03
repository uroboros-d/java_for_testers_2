package ru.stqa.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.model.Group;

import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    //конструктор, в котором передается ссылка на manager,
    //чтобы класс получил доступ к своему начальнику
    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        //создание фабрики сессий
        sessionFactory = new Configuration()
//                        .addAnnotatedClass(Book.class)
//                        .addAnnotatedClass(Author.class)
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL,
                        "jdbc:mysql://localhost/addressbook")
                // Credentials
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "")
                .buildSessionFactory();
    }

    public List<Group> getGroupList() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("from Group", Group.class).list();
        });

    }
}
