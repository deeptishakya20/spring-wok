package com.capgemini.jpasimplemapping;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.jpasimplemapping.person.Person;
import com.capgemini.jpasimplemapping.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JpasimplemappingApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	PersonService service;
	
//	@Test
//	public void contextLoads() {
//	}
	
	


	@Test
	public void testAddOne() throws Exception {
		
		this.mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk())
		//.andExpect(content().string(containsString("Added new one")));
		.andExpect(content().string(containsString("Hello")));
	}
	
	@Test
	public void testGetPerson() throws Exception {
		Person person = new Person(101 ,"Deepti");
		when(service.getPerson(101)).thenReturn(person);
		mockMvc.perform(get("/get"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.personId").value(101))
		.andExpect(jsonPath("$.personName").value("Deepti"));
	}


	@Test
	public void testDeletePerson() throws Exception {
		
		mockMvc.perform(delete("/delete"))
		.andExpect(status().isOk());
	}
}