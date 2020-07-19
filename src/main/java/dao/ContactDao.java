package dao;

import models.Contact;

import java.util.List;

public interface ContactDao {
    /**
     * Метод находит объект Contact по полю id
     * @param id в параметр передается id объекта Contact
     * @return возвращает объект Contact
     */
    Contact findById(int id);

    /**
     * Метод находит все объекты Contact
     * @return возвращает список объектов Contact
     */
    List<Contact> findAll();

    /**
     * Метод сохраняет объект Contact в базу данных
     * @param contact в параметры передается объект Contact
     */
    void save(Contact contact);

    /**
     * Метод изменяет объект Contact в базе данных
     * @param contact в параметры передается объект Contact
     */
    void update(Contact contact);

    /**
     * Метод удаляет объект Contact из базы данных
     * @param id в параметры передается поле id объекта Contact
     */
    void delete(int id);

}
