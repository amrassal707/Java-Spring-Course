package REST.CRUD.SERVICES;

import REST.CRUD.DAO.EmployeeDAOInterface;
import REST.CRUD.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImpl implements serviceInterface{ // it is the service layer's responsibility to handle transations @Transcational not the DAO

    private EmployeeDAOInterface employeeDAOInterface;
    @Autowired // inject the DAO
    public serviceImpl(EmployeeDAOInterface empint) { // injecting DAO to service
        employeeDAOInterface= empint;

    }



    @Override
    public List<Employee> findall() {
        return employeeDAOInterface.readAll();
    }

    @Override
    public Employee readSpecific(int id) {
        return employeeDAOInterface.readSpecific(id);
    }

    @Override
    @Transactional
    public Employee save(Employee Emp) {
        employeeDAOInterface.save(Emp);
        return Emp;
    }

    @Override
    @Transactional
    public Employee delete(int id) {
        return employeeDAOInterface.delete(id);

    }


}
