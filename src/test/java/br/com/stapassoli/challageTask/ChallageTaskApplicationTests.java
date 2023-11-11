package br.com.stapassoli.challageTask;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ChallageTaskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	// Add @InjectMocks for IncidentService to mock the service and its methods

	// Test GET by ID endpoint
	@Test
	public void testGetIncidentById() throws Exception {
		mockMvc.perform(get("/incidents/1001"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		// Add more assertions based on expected response content
		// Use mockMvc.perform() to test different scenarios for GET by ID
	}

	// Test GET all incidents endpoint
	/*@Test
	public void testGetAllIncidents() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/incidents/list"))
			.andExpect(status().isOk());
			//.andExpect(jsonPath("$.size", is("20")));
		// Add more assertions based on expected response content
	}*/

	// Test DELETE by ID endpoint
	@Test
	public void testDeleteById() throws Exception {
		mockMvc.perform(delete("/incidents/1"))
			.andExpect(status().isNoContent());
		// Add more assertions or validations if the service returns a response
	}

	// Test PUT by ID endpoint
	@Test
	public void testUpdate() throws Exception {
		mockMvc.perform(put("/incidents/1001")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Incident Hugo\", \"description\": \"Description for Incident Hugo\",\"closedAt\": \"2023-11-11\"}"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		// Add more assertions based on expected response content
	}

	// Test POST to create incident endpoint
	@Test
	public void testCreate() throws Exception {
		mockMvc.perform(post("/incidents")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Incident Hugo\", \"description\": \"Description for Incident Hugo\"}"))
			.andExpect(status().isCreated())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		// Add more assertions based on expected response content
	}

}
