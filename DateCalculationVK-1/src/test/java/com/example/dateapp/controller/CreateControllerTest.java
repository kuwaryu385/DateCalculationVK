package com.example.dateapp.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
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
public class CreateControllerTest {

	private MockMvc sut;

	@MockBean
	private CalculationService service;

	@Autowired
	private CreateController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 新規登録ページのリクエスト結果が正常となりViewとしてcreateが返る事() throws Exception {
		sut.perform(get("/create"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで登録処理を行うとサービスで処理されてホーム画面に遷移される事() throws Exception {
		sut.perform(post("/create").param("dateId", "TEST").param("dateName", "テスト日付名"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"));

		verify(service, times(1)).create(any());
	}

	@Test
	public void 新規登録ページで日付IDがNULLの状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateName", "テスト日付名"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付IDが空の状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", "").param("dateName", "テスト日付名"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付IDが空白の状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", " ").param("dateName", "テスト日付名"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付IDが6桁以上の状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", "1234567").param("dateName", "テスト日付名"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付名がNULLの状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", "TEST"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付名が空の状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", "TEST").param("dateName", ""))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付名が空白の状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", "TEST").param("dateName", " "))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

	@Test
	public void 新規登録ページで日付名が20桁以上の状態で登録処理を行うと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/create").param("dateId", "TEST").param("dateName", "010101010101010101010"))
				.andExpect(status().isOk())
				.andExpect(view().name("create"));
	}

}
