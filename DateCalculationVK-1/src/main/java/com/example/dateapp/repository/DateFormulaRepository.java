package com.example.dateapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Select("SELECT * FROM dateformula ORDER BY dateId ASC")
	List<DateFormula> select();

	/**
	 * 日付計算式を取得する
	 * @param dateId
	 * @return 日付計算式
	 */
	@Select("SELECT * FROM dateformula WHERE dateId = #{dateId}")
	DateFormula selectId(String dateId);

	/**
	 * 	日付計算式を新規登録する
	 * @param formula
	 */
	@Insert("INSERT INTO dateformula VALUES(#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay})")
	void insert(DateFormula formula);

	/**
	 * 日付計算式を更新します。
	 * @param formula
	 */
	@Update("UPDATE dateformula SET dateName = #{dateName},  adjustmentYear = #{adjustmentYear}, adjustmentMonth = #{adjustmentMonth}, adjustmentDay = #{adjustmentDay} WHERE dateId = #{dateId}")
	void update(DateFormula formula);

	/**
	 *  日付計算式を削除します。
	 * @param dateId
	 */
	@Delete("DELETE FROM dateformula WHERE dateId = #{dateId}")
	void delete(String dateId);

}
