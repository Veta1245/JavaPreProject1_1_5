package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;

    public static SessionFactory getConnect() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/testschema");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Liza22017!");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");


                configuration.setProperties(settings).addAnnotatedClass(User.class);


                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

