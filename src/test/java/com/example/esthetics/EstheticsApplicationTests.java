package com.example.esthetics;

import com.example.esthetics.model.UserDTO;
import com.example.esthetics.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@Transactional
//@DataJpaTest
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
class EstheticsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepo userRepository;

	@Test
	public void testSaveUser() throws Exception {
		// Create a user object with test data
		UserDTO user = new UserDTO();
		user.setName("John");
		user.setSurName("Doe");
		user.setEmail("john.doe@example.com");
		user.setPassword("password123");

		// Perform a POST request to your user creation endpoint
		mockMvc.perform(post("/users/save_user")
				.contentType("application/json")
				.content("{"
						+ "\"name\":\"John\","
						+ "\"surName\":\"Doe\","
						+ "\"email\":\"john.doe@example.com\","
						+ "\"password\":\"password123\""
						+ "}"))
				.andExpect(status().isOk());

		//If user already exists
		mockMvc.perform(post("/users/save_user")
				.contentType("application/json")
				.content("{"
						+ "\"name\":\"John\","
						+ "\"surName\":\"Doe\","
						+ "\"email\":\"john.doe@example.com\","
						+ "\"password\":\"password123\""
						+ "}"))
				.andExpect(status().isConflict());

		// Retrieve the user from the database and assert its values
		/*UserDTO savedUser = userRepository.findByEmail("john.doe@example.com").orElse(null);
		assert savedUser != null;
		assert savedUser.getName().equals("John");
		assert savedUser.getSurName().equals("Doe");
		assert savedUser.getEmail().equals("john.doe@example.com");
		assert savedUser.getPassword().equals("password123");*/
	}

}
