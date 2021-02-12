package com.example.dateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dateapp.domain.DateFormula;
import com.example.dateapp.domain.SimulationForm;
import com.example.dateapp.service.CalculationService;

/**
 * 日付計算式の新規登録画面に紐づくコントローラー
 * @author kuwamura
 *
 */
@Controller
@RequestMapping("/create")
public class CreateController {

	@Autowired
	private CalculationService service;

	/**
	 * 新規登録画面へ移動
	 * @param form 画面フォーム
	 * @return 表示するテンプレート
	 */

	@GetMapping
	public String index(@ModelAttribute DateFormula form) {
		return "create";
	}

	/**
	 * 日付計算式を新規登録
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return 初期画面へ
	 */
	@PostMapping
	public String create(@ModelAttribute @Validated DateFormula form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		service.create(form);

		model.addAttribute("simulationForm", new SimulationForm());
		return "home";

	}

}
