package com.example.dateapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dateapp.domain.DateFormula;
import com.example.dateapp.service.CalculationService;

/**
 * 計算式一覧の表示画面に遷移するコントローラー
 * @author kuwamura
 *
 */
@Controller
@RequestMapping("/list")
public class ListController {

	@Autowired
	private CalculationService service;

	/**
	 * 計算一覧画面の表示
	 * @param dateId
	 * @param model
	 * @return 計算一覧表示画面
	 */

	@GetMapping
	public String index(DateFormula formula, Model model) {
		List<DateFormula> formulas = new ArrayList<DateFormula>(service.search());
		model.addAttribute("formulas", formulas);
		return "list";
	}

}
