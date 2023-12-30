package REST.CRUD;

import REST.CRUD.Controllers.EmpController;
import REST.CRUD.DAO.EmployeeDAOImpl;
import REST.CRUD.SERVICES.serviceInterface;
import REST.CRUD.DAO.EmployeeDAOInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpController.class) // auto injects controllers and also enables webMVCtest configurations only
class CrudApplicationTests {
	@Autowired
	private MockMvc mvc;



	@Test
	public void getAllEmployeesAPI() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders
						.get("/readall")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
	}

}



//	@Test
//	void checkDAOsdataforSpecific() {
//		assertNotNull(employeeDAOInterface.readSpecific(1));
//	}