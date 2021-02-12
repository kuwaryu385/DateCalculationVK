package com.example.dateapp.view;

import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeborne.selenide.Configuration;
import com.example.dateapp.view.page.CreatePage;
import com.example.dateapp.view.page.HomePage;
import com.example.dateapp.view.page.ListPage;
import com.example.dateapp.view.page.UpdatePage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) //ポートはアプリケーションのプロパティで指定されたポートを使用
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) //テストを実効したあとDI破棄
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//注釈を使用し@FixMethodOrder方法ソーターでMethodSorters.NAME_ASCENDING 。
//これにより、クラス内のすべてのテストが決定的かつ予測可能な順序で実行されます。

public class HomeViewTest {

	private HomePage page;

	@BeforeClass
	public static void setUp() {
		// テストが終了後もブラウザを開いたままにしない
		Configuration.holdBrowserOpen = true;
	}

	@Before
	public void setUpTest() {
		page = HomePage.open();
	}

	@Test
	public void No1_ホーム画面で計算基準日に20181201を入れて結果が一覧で取得できる事() {
		HomePage actual = page.計算基準日は("20181201").でシミュレーションする();
		//要素が表示されているかどうかを確認します
		actual.検索結果().shouldBe(visible);
		assertThat(actual.検索結果の件数()).isEqualTo(2);
	}

	@Test
	public void No2_ホーム画面から計算式一覧画面へ遷移できる事() throws Exception {
		ListPage actual = page.計算式一覧画面へ遷移する();

		assertThat(actual.title()).isEqualTo("List 計算式一覧");
	}

	@Test
	public void No3_ホーム画面から新規登録画面へ遷移できる事() throws Exception {
		CreatePage actual = page.新規登録画面へ遷移する();

		assertThat(actual.title()).isEqualTo("新規登録 Create");
	}

	@Test
	public void No4_ホーム画面から更新画面へ遷移できる事() throws Exception {
		page.計算基準日は("20181201").でシミュレーションする();

		UpdatePage actual = page.更新画面へ遷移する(1);

		assertThat(actual.title()).isEqualTo("更新画面 Update");
	}

	@Test
	public void No5_ホーム画面から削除実行出来る事() throws Exception {
		page.計算基準日は("20181201").でシミュレーションする();

		page.削除を実行する(1);
		HomePage actual = page.計算基準日は("20181201").でシミュレーションする();

		actual.検索結果().shouldBe(visible);
		assertThat(actual.検索結果の件数()).isEqualTo(1);
	}

}
