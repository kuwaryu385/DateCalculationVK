package com.example.dateapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dateapp.domain.DateFormula;
import com.example.dateapp.repository.DateFormulaRepository;

@Service
public class CalculationService {

	//日付計算式リポジトリ
	@Autowired
	private DateFormulaRepository repository;

	//日付計算式の一覧を全件検索して取得する

	public List<DateFormula> search() {
		return repository.select();
	}

	// 日付計算式を取得します。

	//	public DateFormula search(String dateId) {
	//		return repository.selectID(dateId);
	//	}

	//日付計算式を登録します。

	//	public void register(DateFormula formula) {
	//		repository.insert(formula);
	//	}

	//日付計算式を更新します。

	//	public void update(DateFormula formula) {
	//		repository.update(formula);
	//	}

	//日付計算式を削除します。

	//	public void delete(String dateId) {
	//		repository.delete(dateId);
	//	}

}
