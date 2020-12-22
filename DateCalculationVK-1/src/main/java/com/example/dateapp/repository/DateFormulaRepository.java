package com.example.dateapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dateapp.domain.DateFormula;

@Mapper
public interface DateFormulaRepository {

	//	日付計算式の一覧を取得する

	List<DateFormula> select();

}
