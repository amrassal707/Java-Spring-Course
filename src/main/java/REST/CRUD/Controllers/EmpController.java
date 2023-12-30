package REST.CRUD.Controllers;

import REST.CRUD.DAO.EmployeeDAOImpl;
import REST.CRUD.DAO.EmployeeDAOInterface;
import REST.CRUD.Entity.Employee;
import REST.CRUD.SERVICES.serviceImpl;
import REST.CRUD.SERVICES.serviceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/") //used to map web requests onto specific handler classes and/or handler methods.
public class EmpController {

    private serviceInterface serviceInterface;

    // inject service into the controller using constructor injection
    public EmpController(serviceInterface serv) {
        serviceInterface= serv;
    }
    @GetMapping("/readall")
    public List<Employee> getAllEmp() {
        return serviceInterface.findall();
    }

    @GetMapping("/readspecific/{id}")
    public Employee getspecific(@PathVariable int id) {
        if (serviceInterface.readSpecific(id) == null) {
            throw new RuntimeException("not found with id " + id);
        }
        return serviceInterface.readSpecific(id);



    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp) // using @request body to bind the JSON to the emp object
    {
        emp.setId(0); // to perfom an insert not an update to the DB
        Employee emp1 = serviceInterface.save(emp);

        return emp1;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee emp)
    {
        Employee emp1= serviceInterface.save(emp);
        return emp1;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee emp= serviceInterface.delete(id);

        if (emp == null) {
            throw new RuntimeException("not found "+ id);

        }
    }






}


