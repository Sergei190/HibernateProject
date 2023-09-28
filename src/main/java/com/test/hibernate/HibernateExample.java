package com.test.hibernate;

import com.test.employee.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {
        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Создание новой сессии
        Session session = sessionFactory.openSession();

        // Создание объекта Employee
        Employee employee = new Employee();
        employee.setName("Sergey");
        employee.setAge(22);
        employee.setFirstName("Kudryashov");

        // Сохранение объекта в базе данных
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

        // Закрытие сессии и фабрики сессий
        session.close();
        sessionFactory.close();
    }
}
