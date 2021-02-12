package com.example.dateapp.view.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CreatePage {

	@FindBy(id = "createButton")
	private SelenideElement createButton;

	@FindBy(id = "backButton")
	private SelenideElement backButton;

	@FindBy(id = "dateId")
	private SelenideElement dateId;

	@FindBy(id = "dateName")
	private SelenideElement dateName;

	@FindBy(id = "adjustmentYear")
	private SelenideElement adjustmentYear;

	@FindBy(id = "adjustmentMonth")
	private SelenideElement adjustmentMonth;

	@FindBy(id = "adjustmentDay")
	private SelenideElement adjustmentDay;

	public String title() {
		return Selenide.title();
	}

	public HomePage ホームへ戻る() {
		backButton.click();
		return page(HomePage.class);
	}

	public CreatePage 日付IDは(String 日付ID) {
		dateId.setValue(日付ID);
		return page(CreatePage.class);
	}

	public CreatePage 日付名は(String 日付名) {
		dateName.setValue(日付名);
		return page(CreatePage.class);
	}

	public CreatePage 加減年は(String 加減年) {
		adjustmentYear.setValue(加減年);
		return page(CreatePage.class);
	}

	public CreatePage 加減月は(String 加減月) {
		adjustmentMonth.setValue(加減月);
		return page(CreatePage.class);
	}

	public CreatePage 加減日は(String 加減日) {
		adjustmentDay.setValue(加減日);
		return page(CreatePage.class);
	}

	public HomePage で新規登録する() {
		createButton.click();
		return page(HomePage.class);
	}

}
