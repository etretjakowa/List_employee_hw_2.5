package pro.sky.List.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.List.Employee.Employee;
import pro.sky.List.Employee.service.EmployeeService;

import java.util.List;


@RestController

@RequestMapping("/employees")

public class EmployeeController {


    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")

    public Employee addEmployee(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName
    ) {

        return employeeService.add(name, lastName);

    }

    @GetMapping("/remove")

    public Employee removeEmployee(

            @RequestParam("name") String name,

            @RequestParam("lastName") String lastName

    ) {

        return employeeService.remove(name, lastName);

    }


    @GetMapping("/find")

    public Employee findEmployee(

            @RequestParam("name") String name,

            @RequestParam("lastName") String lastName

    ) {

        return employeeService.find(name, lastName);

    }


    @GetMapping("/allEmployees")


    public List<Employee> getAllEmployees() {


        return employeeService.getAll();

    }

}