package com.example.dateapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dateapp.domain.DateFormula;

@Mapper
public interface DateFormulaRepository {

	//	日付計算式の一覧を取得する

	List<DateFormula> select();

	//	 日付計算式を取得する

	DateFormula selectID(String dateId);

	//	日付計算式を新規登録する

	void insert(DateFormula formula);

	//	 日付計算式を更新します。

	void update(DateFormula formula);

	//	 日付計算式を削除します。

	void delete(String dateId);

}
