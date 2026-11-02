package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController 
public class Controller {

    private List<Employee> employees = new ArrayList<>();
    
    @GetMapping ("/message")
    public String getMessage() {
        return "Hello from Controller!";
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employees;
    }

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody Employee employee) {
        // Logic to save the employee to a database or perform other operations
        employees.add(employee);
        
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        // Logic to delete the employee from a database or perform other operations
        employees.removeIf(employee -> employee.getId().equals(id));
    }

    @PutMapping("/employee/{id}")
    public void Updateemployee(@PathVariable String id, @RequestBody Employee employee) {
        if (id != null) {
            for (Employee emp : employees) {
                if (emp.getId().equals(Long.parseLong(id))) {
                    emp.setName(employee.getName());
                    emp.setId(employee.getId());
                    break;
                }
            }
        }
        
        
    }
}
