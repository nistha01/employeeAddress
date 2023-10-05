package nitish.employeeAddress.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nitish.employeeAddress.model.Employee;
import nitish.employeeAddress.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public String postEmploye(Employee employee) {
        iEmployeeRepo.save(employee);
        return "Employee Added";
    }

    public List<Employee> getEmployees() {
        return iEmployeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return iEmployeeRepo.findById(id).orElse(null);
    }

    public String updateEmployee(Employee employee,Long id) {
        Employee emp=iEmployeeRepo.findById(id).orElse(null);
        if(emp!=null){
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            return "Details updated";
        }
        return "Invalid id";
    }

    public String deleteEmployee(Long id) {
        Employee emp= iEmployeeRepo.findById(id).orElse(null);
        if(emp!=null){
            iEmployeeRepo.delete(emp);
        }
        return "No employee found";
    }
}
