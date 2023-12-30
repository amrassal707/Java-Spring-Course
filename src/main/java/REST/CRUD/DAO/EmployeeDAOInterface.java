package REST.CRUD.DAO;



import REST.CRUD.Entity.Employee;

import java.util.List;

public interface EmployeeDAOInterface {

    public List <Employee> readAll();

    Employee readSpecific(int id);

    Employee save(Employee Emp);
    Employee delete(int id);

}
