package com.nrdtech.service.impl;

import com.nrdtech.entity.EmployeeEntity;
import com.nrdtech.model.Address;
import com.nrdtech.model.Employee;
import com.nrdtech.repository.EmployeeRepository;
import com.nrdtech.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

   // instead of declaring here we can directly inject with constructor so that at the time of initiation i will we created.

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WebClient getWebClient;

    private RestTemplate restTemplate;




  //  RestTemplateBuilder is resposible to bult templates with rootURI so that we can use with more than one method (like post, get and update).
    /*public EmplyeeServiceImpl(@Value("${addressService.base.url}") String addressBaseUrl, RestTemplateBuilder builder){
        this.restTemplate=builder
                .rootUri(addressBaseUrl)
                .build();
    }*/

    @Override
    public Employee saveEmployeeDetails(Employee emp) {

        EmployeeEntity entity=new EmployeeEntity();

        //if you are not using ModelMapper object then you have to directly have to get object from model object(Employee) and set to entity object(EmployeeEntity)

        /*entity.setId(emp.getId());
        entity.setName(emp.getName());
        entity.setEmail(emp.getEmail());
        entity.setBloodGroup(emp.getBloodGroup());*/

        //for understanding purpose we can wright like this
       // entity=modelMapper.map(emp,EmployeeEntity.class);
        // entity= empRepo.save(entity);

       // modelMapper.map(emp,EmployeeEntity.class);
         entity=empRepo.save(modelMapper.map(emp,EmployeeEntity.class));

        //converting data from Entity object to model object

       /* emp.setEmail(entity.getEmail());
        emp.setId(entity.getId());
        emp.setName(entity.getName());
        emp.setBloodGroup(entity.getBloodGroup());*/

        //for understanding purpose we can wright like this
       //emp=modelMapper.map(entity,Employee.class);

        //modelMapper.map(entity,Employee.class);

        //instead of doing all above code we have to use ModelMapper object to resolve the issue
        //the same above code doing by a

        emp= modelMapper.map(entity,Employee.class);
        return emp;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> resultEmpEntityList=empRepo.findAll();
        Employee employees=new Employee();
        List<Employee> modelEmpList=new ArrayList<>();

       for(EmployeeEntity entity:resultEmpEntityList){

            //using ModelMapper we can avoid the below lines of code

          employees=modelMapper.map(entity,Employee.class);
           modelEmpList.add(employees);

       }
        return modelEmpList;
    }
    @Override
    public Employee getEmployeesById(int id) {
        Employee emp=new Employee();
        Optional<EmployeeEntity> entity=empRepo.findById(id);
        if(entity.isPresent()){
            EmployeeEntity resultEntity=entity.get();
            // emp= modelMapper.map(resultEntity,Employee.class);
            emp=modelMapper.map(resultEntity,Employee.class);
        }
        Address address=getWebClient
                                .get()
                                .uri("/add/101")
                                        .retrieve()
                                                .bodyToMono(Address.class)
                                                        .block();

       // Address address=restTemplate.getForObject("/add/101",Address.class);
        emp.setAddress(address);

        return emp;
    }





    //the below code is responsible when we are using RestTemplate
    /*@Override
    public Employee getEmployeesById(int id) {
        Employee emp=new Employee();
        Optional<EmployeeEntity> entity=empRepo.findById(id);
        if(entity.isPresent()){
            EmployeeEntity resultEntity=entity.get();
            // emp= modelMapper.map(resultEntity,Employee.class);
            modelMapper.map(resultEntity,Employee.class);
        }
        Address address=restTemplate.getForObject("/add/101",Address.class);
        emp.setAddress(address);

        return emp;
    }*/
}
