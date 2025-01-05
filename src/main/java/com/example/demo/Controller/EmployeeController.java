package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public Map<Integer, Employee> employeeMap = new HashMap<>();


    @GetMapping("/greet")
    public String greetings(){
        return "Hello devs";
    }

    @PostMapping("/add")
    public void setEmployees(@RequestBody Employee employee){
        if (!employeeMap.containsValue(employee)) {
            employeeMap.put(employee.getId(), employee);
        } else {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            throw new RuntimeException("Duplicate Records");
        }
    }

    @GetMapping(value="/getbyid/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee e1 = employeeMap.get(id);
        if(e1 == null){
            System.out.println("Record not found");
            //log.info("Record not found");
            return null;
        }
        System.out.println(e1.toString());
       // log.info(e1.toString());
        return employeeMap.get(id);
    }

    @GetMapping(value="/getall")
    public Map<Integer, Employee> getAllEmployee(){
        return employeeMap;
    }

}
