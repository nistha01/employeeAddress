package nitish.employeeAddress.repo;

import nitish.employeeAddress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo  extends JpaRepository<Employee,Long> {
}
