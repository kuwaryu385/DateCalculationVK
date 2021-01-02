package com.example.dateapp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dateapp.domain.DateFormula;
import com.example.dateapp.repository.DateFormulaRepository;

@Service
public class CalculationService {

	//日付計算式リポジトリ
	@Autowired
	private DateFormulaRepository repository;

	//日付計算式一覧を取得する
	//@return 日付計算式の全件

	public List<DateFormula> search() {
		return repository.select();
	}

	// 日付計算式を取得します。
	//@return 日付計算式

	public DateFormula search(String dateId) {
		return repository.selectId(dateId);
	}

	//日付計算式を登録します。

	//	public void register(DateFormula formula) {
	//		repository.insert(formula);
	//	}

	//日付計算式を更新します。

	//	public void update(DateFormula formula) {
	//		repository.update(formula);
	//	}

	/**
	 * 日付計算式を削除します。
	 * @param dateId 削除対象の日付ID
	 */

	@Transactional
	public void delete(String dateId) {
		repository.delete(dateId);
	}

	/**
	 * 日付計算を実行するクラス
	 * 計算基準日をベースに、日付計算式の加減値に基づいて計算を行う。
	 * 計算語の書式は「yyyyMMdd」の文字列となります。
	 * @param baseDate 計算基準日
	 * @param formula 日付計算式
	 * @return 計算結果
	 */

	public String calculate(String baseDate, DateFormula formula) {
		LocalDate dete = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calulatedDate = dete.plusYears(formula.getAdjustmentYear())
				.plusMonths(formula.getAdjustmentMonth())
				.plusDays(formula.getAdjustmentDay());
		return calulatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

	}

}
