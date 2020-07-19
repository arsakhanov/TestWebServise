package utils;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import models.*;

/**
 * Утилитный класс для SessionFactory
 * Необходимо инициализировать SessionFactory всего один раз.
 * Экземпляр SessionFactory используется для получения объектов Session,
 * которые используются для операций с базами данных.
 */

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(ContactType.class);
                configuration.addAnnotatedClass(Contact.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                System.out.println("Исключение! " + e);
            }
        }
        return sessionFactory;
    }
}
