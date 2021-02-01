package com.example.dateapp.view.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HomePage {

	private static final String URL = "http://localhost:8080/";

	@FindBy(id = "baseDate")
	private SelenideElement baseDate;

	@FindBy(id = "simulationButton")
	private SelenideElement simulationButton;

	@FindBy(id = "createButton")
	private SelenideElement createButton;

	@FindBy(id = "listButton")
	private SelenideElement listButton;

	public static HomePage open() {
		return Selenide.open(URL, HomePage.class);
	}

	public String title() {
		return Selenide.title();
	}

	public HomePage 計算基準日は(String 計算基準日) {
		baseDate.setValue(計算基準日);
		return page(HomePage.class);
	}

	public HomePage でシミュレーションする() {
		simulationButton.click();
		return page(HomePage.class);
	}

	public ListPage 計算式一覧画面へ遷移する() {
		listButton.click();
		return page(ListPage.class);
	}

	public CreatePage 新規登録画面へ遷移する() {
		createButton.click();
		return page(CreatePage.class);
	}

	public UpdatePage 更新画面へ遷移する(int 行) {
		$(By.id(行 + "_" + "updateButton")).click();
		return page(UpdatePage.class);
	}

	public HomePage 削除を実行する(int 行) {
		$(By.id(行 + "_" + "deleteButton")).click();
		return page(HomePage.class);
	}

	public SelenideElement 検索結果() {
		return $(By.cssSelector(".table tbody"));
	}

	public int 検索結果の件数() {
		return $(By.cssSelector(".table")).findElements(By.tagName("tbody")).size();
	}

}
