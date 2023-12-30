package REST.CRUD;

import REST.CRUD.Controllers.EmpController;
import REST.CRUD.DAO.EmployeeDAOInterface;
import REST.CRUD.Entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import REST.CRUD.SERVICES.serviceInterface;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class) //tells JUnit to run using Spring's testing support. SpringRunner is the new name for SpringJUnit4ClassRunner
// it's useful because it tells JUnit to run using Spring's testing support.
@SpringBootTest
class CrudApplicationTests {

	@Autowired
	EmpController empController;

	@MockBean
	EmployeeDAOInterface daoInterface;



	@Test
	void readAllData() {
		// when function is called , then it mocks the DB by returning the data in "thenReturn"
		when(daoInterface.findAll()).thenReturn(
				Stream.of((new Employee(1,"amr","Ayman","@gmail")), new Employee(2,"ahmed","Ayman","@gmail")).collect(Collectors.toList())); // mocking the DB and creating a list of Employees to read back
		// here we are expecting the number of employees to be 2 as it's the stream of data that we have above, so we expect our service to also return 2
		assertEquals(2,empController.getAllEmp().size());
	}
	@Test
	void saveEmployee() {
		Employee em= new Employee(3,"Hendi", "Shaw2y", "@gmail.com");
		when(daoInterface.save(em)).thenReturn(em); // when the dao is called to save a specific it's expected to return the user that it saved into the DB
		assertEquals(em,empController.addEmployee(em));// we compare what we saved using THE REPO to our service if it's implementing the REPO correctly

	}


}
