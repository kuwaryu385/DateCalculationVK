package com.example.dateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dateapp.domain.DateFormula;
import com.example.dateapp.domain.SimulationForm;
import com.example.dateapp.service.CalculationService;

/**
 * 日付計算式を更新する画面に紐づくコントローラー
 * @author kuwamura
 *
 */

@Controller
@RequestMapping("/update/{dateId}")
public class UpdateController {

	@Autowired
	private CalculationService service;

	/**
	 * 更新画面の表示処理
	 * @param dateIdと紐づくフォーム
	 * @param model
	 * @return 更新画面
	 */

	@GetMapping
	public String index(@PathVariable String dateId, Model model) {
		model.addAttribute("dateFormula", service.search(dateId));
		return "update";
	}

	/**
	 * 日付計算式を更新します。
	 * @param form
	 * @param model
	 * @return 表示するテンプレート
	 */

	@PostMapping
	public String update(@ModelAttribute @Validated DateFormula form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "update";
		}
		service.update(form);
		model.addAttribute("simulationForm", new SimulationForm());
		return "home";

	}

}
