package pro.sky.List.Employee.service;

import pro.sky.List.Employee.Employee;
import pro.sky.List.Employee.EmployeeAlreadyAddedException;
import pro.sky.List.Employee.EmployeeNotFoundException;
import pro.sky.List.Employee.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeService {


    Employee add(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(String name, String lastName) throws EmployeeNotFoundException;

    Employee find(String name, String lastName) throws EmployeeNotFoundException;

    List<Employee> getAll();


}

