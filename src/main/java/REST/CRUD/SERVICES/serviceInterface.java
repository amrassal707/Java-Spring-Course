package REST.CRUD.SERVICES;

import REST.CRUD.Entity.Employee;

import java.util.List;

public interface serviceInterface {

    List<Employee> findall();
    Employee readSpecific(int id);

    Employee save(Employee Emp);
    Employee delete(int id);


}
