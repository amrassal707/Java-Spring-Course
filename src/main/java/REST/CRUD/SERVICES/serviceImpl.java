package REST.CRUD.SERVICES;

import REST.CRUD.DAO.EmployeeDAOInterface;
import REST.CRUD.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceImpl implements serviceInterface{ // it is the service layer's responsibility to handle transations @Transcational not the DAO

    private EmployeeDAOInterface employeeDAOInterface;
    @Autowired // inject the DAO
    public serviceImpl(EmployeeDAOInterface empint) { // injecting DAO to service
        employeeDAOInterface= empint;

    }



    @Override
    public List<Employee> findall() {
        return employeeDAOInterface.findAll();
    }

    @Override
    public Employee readSpecific(int id) {
        // optional is a feature introduced in java 8 that works with null and data
         Optional<Employee> Emp = employeeDAOInterface.findById(id);
         if(Emp.isPresent()) {
             return Emp.get();
         }
         else throw new RuntimeException("data is not available"+ id);
    }

    @Override
    //@Transactional we don't need it since JPARepo provides that functionality
    public Employee save(Employee Emp) {
        employeeDAOInterface.save(Emp);
        return Emp;
    }

    @Override
    // @Transactional we don't need it since JPARepo provides that functionality
    public void delete(int id) {
         employeeDAOInterface.deleteById(id);


    }


}
