package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.com.example.demo.DemoApplication;

@SpringBootTest(classes=DemoApplication.class)
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void shouldDisplayHelloWorld() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World!")));
	}
	
	@Test
	public void shouldDisplayName() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello?name=Athens"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello Athens!")));
	}

}
