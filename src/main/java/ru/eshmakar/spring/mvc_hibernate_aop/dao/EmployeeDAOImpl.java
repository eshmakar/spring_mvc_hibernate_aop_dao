package ru.eshmakar.spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.eshmakar.spring.mvc_hibernate_aop.entity.Employee;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory; //автоматический создается и SessionFactory

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();//открываем сессию
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();//получаем список работников
        return allEmployees;
    }
}
