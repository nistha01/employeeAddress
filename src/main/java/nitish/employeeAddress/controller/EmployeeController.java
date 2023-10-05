package nitish.employeeAddress.controller;

import nitish.employeeAddress.EmployeeAddressApplication;
import nitish.employeeAddress.model.Employee;
import nitish.employeeAddress.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("employee")
    public String postEmployee( @RequestBody Employee employee){
        return employeeService.postEmploye(employee);
    }
    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("employee/id/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("employee/{id}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable Long id){
        return employeeService.updateEmployee(employee,id);
    }
    @DeleteMapping("employee/id/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }




}
