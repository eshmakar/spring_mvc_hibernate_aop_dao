package ru.eshmakar.spring.mvc_hibernate_aop.service;

import ru.eshmakar.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
}
