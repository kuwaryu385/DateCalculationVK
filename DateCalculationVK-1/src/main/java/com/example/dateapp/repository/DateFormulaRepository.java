package com.example.dateapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dateapp.domain.DateFormula;

/**
 * 日付計算式を扱うリポジトリ
 * ORMクラス。
 * @author kuwamura
 *
 */

@Mapper
public interface DateFormulaRepository {

	/**
	 * 日付計算式の一覧を取得する。
	 * @return 日付計算式の一覧
	 */

	List<DateFormula> select();

	/**
	 * 日付計算式を取得する
	 * @param dateId
	 * @return 日付計算式
	 */

	DateFormula selectId(String dateId);

	/**
	 * 	日付計算式を新規登録する
	 * @param formula
	 */

	void insert(DateFormula formula);

	/**
	 * 日付計算式を更新します。
	 * @param formula
	 */

	void update(DateFormula formula);

	/**
	 *  日付計算式を削除します。
	 * @param dateId
	 */

	void delete(String dateId);

}
