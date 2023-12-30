package REST.CRUD.DAO;

import REST.CRUD.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //  annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete
public class EmployeeDAOImpl implements EmployeeDAOInterface {

    private EntityManager entityManager;

    @Autowired // optional in case of only one constructor
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List <Employee>  readAll() {
        TypedQuery <Employee> theQuery= entityManager.createQuery("from Employee", Employee.class); // "from Employee" should be similar to the entity name not the DB table name
        if (theQuery.getResultList() == null) {
            System.out.println("can't find data");
        }

        //return theQuery.getResultList();

        List<Employee> employees= theQuery.getResultList();
        return  employees;
    }

    @Override
    public Employee readSpecific(int id) {

        Employee e= entityManager.find(Employee.class, id);
        return e;

    }

    @Override

    public Employee save(Employee emp) {
        // save or update the entity
        entityManager.merge(emp);
        return emp;
    }

    @Override

    public Employee delete(int id) {
        Employee e= entityManager.find(Employee.class, id);

        entityManager.remove(e);
        return e;

    }
}
