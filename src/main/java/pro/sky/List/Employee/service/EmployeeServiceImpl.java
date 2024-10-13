package pro.sky.List.Employee.service;

import org.springframework.stereotype.Service;
import pro.sky.List.Employee.Employee;
import pro.sky.List.Employee.EmployeeAlreadyAddedException;
import pro.sky.List.Employee.EmployeeNotFoundException;
import pro.sky.List.Employee.EmployeeStorageIsFullException;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private static List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Пётр", "Петров"),
            new Employee("Сергей", "Новиков"),
            new Employee("Татьяна", "Тихонова"),
            new Employee("Наталья", "Семёнова"),
            new Employee("Николай", "Шевцов"),
            new Employee("Анна", "Зайцева")

    ));
    private final int STORAGE_SIZE = 15;


    @Override
    public Employee add(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, lastName);
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Список заполнен!");
        }
        if (employees.contains(employee)) {

            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в списке");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого  сотрудника нет в списке");
        }
        employees.remove(employee);
        return null;
    }

    @Override
    public Employee find(String name, String lastName) throws EmployeeNotFoundException {

        Employee employee = new Employee(name, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Такого  сотрудника нет в списке");
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}

