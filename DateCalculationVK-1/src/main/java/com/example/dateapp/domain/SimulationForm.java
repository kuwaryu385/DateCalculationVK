package com.example.dateapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//日付計算処理をシュミレートする画面を表現する

public class SimulationForm {
	//計算基準日
	@NotBlank

	//正規表現 1900/01/01~9999/12/31 まで入力可能
	@Pattern(regexp = "((19|[2-9][0-9])[0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])")
	private String baseDate;

	//計算結果
	private List<Result> results;

	//デフォルトコンストラクタを定義する。なぜなら引数なしのオブジェクトを生成したいから
	public SimulationForm() {

	}

	//コンストラクタ インスタンス生成時に実行する。
	//	@param baseDate 計算基準日
	//	@param results 日付計算一覧

	public SimulationForm(String baseDate, List<DateFormula> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
	}

	//計算基準日を取得
	//@return 計算基準日

	public String getBaseDate() {
		return baseDate;
	}
	//計算基準日を設定
	//@pram baseDate 計算基準日

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	//計算結果の取得
	//@return 計算結果

	public List<Result> getResults() {
		return results;
	}

	//日付計算式の内容を画面用の計算結果オブジェクトに変換
	//@param formula 日付計算式
	//@return 画面計算結果オブジェクト

	public Result convertToResult(DateFormula formula) {
		return new Result(formula);
	}

}
