package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.BustaPaga;
import com.example.demo.repository.BustaPagaRepository;

@SpringBootTest
class GestionaleApplicationTests {
	
	@Test
	public void shouldGetAllUsers() throws Exception {
		
	}
}