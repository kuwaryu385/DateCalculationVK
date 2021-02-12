package com.example.dateapp.view.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ListPage {

	@FindBy(id = "backButton")
	private SelenideElement backButton;

	public String title() {
		return Selenide.title();
	}

	public HomePage ホームへ戻る() {
		backButton.click();
		return page(HomePage.class);
	}
}
