package com.nrdtech.controller;




import com.nrdtech.model.Employee;
import com.nrdtech.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService empServ;

    @PostMapping("/save")
   public ResponseEntity<String> saveEmployeeDetails(@RequestBody Employee emp){
       Employee saveEmployee= empServ.saveEmployeeDetails(emp);

       return new ResponseEntity<String>("Saved Employee Data Successfully for Id:"+saveEmployee.getId(),HttpStatus.CREATED);
   }

    @GetMapping("/all")
   public ResponseEntity<List<Employee>> getEmployees(){
        logger.info("**inside****EmployeeController******getEmployees*****start****");

        List<Employee> employeesList=empServ.getEmployees();

        System.out.println("*************"+employeesList);

        return new ResponseEntity<List<Employee>> (employeesList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable int id) {

        Employee employees=empServ.getEmployeesById(id);

        return new ResponseEntity<Employee>(employees,HttpStatus.OK);
    }
}
