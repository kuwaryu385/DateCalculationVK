package com.example.dateapp.controller;

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
public class SimulationHomeControllerTest {

	private MockMvc sut;

	// モック化するクラスのインスタンスを生成
	@MockBean
	private CalculationService service;

	// モックを注入するクラスのインスタンスを生成、DIコンテナに登録
	@Autowired
	private SimulationHomeController target;

	//ここで初期設定。Test用に設定。mockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行します。
	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void ホームのリクエスト結果が正常となりViewとしてhomeが返る事() throws Exception {
		//レスポンスのHTTPステータスコードは正しいか？
		sut.perform(get("/"))
				.andExpect(status().isOk())//ステータスコード200はstatus().isOkでテスト
				.andExpect(view().name("home"));//指定のviewで返すか（”/”でhome.htmlを返すか確認する）
	}

	@Test
	public void ホームで計算基準日を入力して計算実行を押すと計算サービスが呼ばれている事() throws Exception {
		sut.perform(post("/").param("baseDate", "20181201"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"));

		verify(service, times(1)).search();
		//verify((Mock化したオブジェクト名), times((呼出回数))).(呼出メソッド名(呼出メソッドの引数))」
		//という処理によって確認
	}

	@Test
	public void ホームで削除処理を行うとサービスで処理されて同一画面に遷移される事() throws Exception {
		sut.perform(post("/{dateId}", "Y01"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"));

		verify(service, times(1)).delete("Y01");
	}

	@Test
	public void ホームで計算基準日をNULLにして計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/"))
				.andExpect(status().isOk())
				.andExpect(model().hasErrors())
				.andExpect(view().name("home"));
	}

	@Test
	public void ホームで計算基準日を空にして計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/").param("baseDate", ""))
				.andExpect(status().isOk())
				.andExpect(model().hasErrors())
				.andExpect(view().name("home"));
	}

	@Test
	public void ホームで計算基準日を空白を入れて計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/").param("baseDate", " "))
				.andExpect(status().isOk())
				.andExpect(model().hasErrors())
				.andExpect(view().name("home"));
	}

	@Test
	public void ホームで計算基準日に不正な値を入れて計算実行を押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/").param("baseDate", "2018/12/01"))
				.andExpect(status().isOk())
				.andExpect(model().hasErrors())
				.andExpect(view().name("home"));
	}

}
