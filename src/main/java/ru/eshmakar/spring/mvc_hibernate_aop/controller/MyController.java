package ru.eshmakar.spring.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eshmakar.spring.mvc_hibernate_aop.entity.Employee;
import ru.eshmakar.spring.mvc_hibernate_aop.service.EmployeeService;

import java.util.List;

@Controller
public class MyController {

    @Autowired //получаем бин
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);//на модель добавляем список работников для их отображения в view
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")//сохраняем работника
    public String saveEmployee(@ModelAttribute("employee") Employee employee ){ //при вызове этого метода получаем через модель сохраненный объект Employee
        employeeService.saveEmployee(employee);//идет сохранение или обновление в базу
        return "redirect:/";//после этого переходим обратно на главную страницу (all-employees)
    }

    @RequestMapping("updateInfo")//обновление существующего работника
    public String updateEmployee(@RequestParam("empId") int id, Model model){//получаем данные работника по id и вызываем employee-info через геттеры
        Employee employee = employeeService.getEmployee(id);//идет получение объекта Employee из базы
        model.addAttribute("employee", employee);//добавляем обратно в модель
        return "employee-info";
    }
}
