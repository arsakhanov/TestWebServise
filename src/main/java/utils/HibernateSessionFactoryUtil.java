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
                Configuration configuration = new Configuration().configure(); //чтение файла конфигурации hibernate.cfg.xml
                configuration.addAnnotatedClass(Person.class); //добавление класса-сущности Person
                configuration.addAnnotatedClass(ContactType.class); // добавление класса-сущности ContactType
                configuration.addAnnotatedClass(Contact.class); // добавление класса-сущности Contact
                //считывание параметров для работы hibernate указанные в файле конфигурации
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                System.out.println("Исключение! " + e);
            }
        }
        return sessionFactory;
    }
}
