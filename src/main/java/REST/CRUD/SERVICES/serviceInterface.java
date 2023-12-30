package REST.CRUD.SERVICES;

import REST.CRUD.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface serviceInterface {

    List<Employee> findall();
    Employee readSpecific(int id);

    Employee save(Employee Emp);
    void  delete(int id);


}
