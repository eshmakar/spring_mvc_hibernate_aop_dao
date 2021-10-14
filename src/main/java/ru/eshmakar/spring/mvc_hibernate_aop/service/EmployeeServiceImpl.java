package ru.eshmakar.spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshmakar.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import ru.eshmakar.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

@Service // является посредником между Controller и DAO
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired//получаем бин
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional //для открытия и закрытия транзакции
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
