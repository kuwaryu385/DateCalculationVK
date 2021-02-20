package com.example.dateapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.dateapp.service.CalculationService;

@RunWith(SpringRunner.class)
@SpringBootTest

@TestPropertySource(locations = "classpath:test.properties")
public class ListControllerTest {

	private MockMvc sut;

	@MockBean
	private CalculationService service;

	@Autowired
	private ListController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 計算式一覧ページのリクエスト結果が正常となりViewとしてlistが返る事() throws Exception {
		sut.perform(get("/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("list"));
	}

}
