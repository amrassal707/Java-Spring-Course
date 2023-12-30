package REST.CRUD.DAO;



import REST.CRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// JPARepository has all the basic CRUD operations that we need, if anymore that would be added can be simply added to the interface and implemented
public interface EmployeeDAOInterface extends JpaRepository<Employee, Integer> {


}
