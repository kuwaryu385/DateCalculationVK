package com.example.dateapp.controller;

import java.util.List;

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

import com.example.dateapp.domain.Result;
import com.example.dateapp.domain.SimulationForm;
import com.example.dateapp.service.CalculationService;

/**
 * 日付計算処理をシュミレートするHOME画面に紐づくコントローラー
 * @author kuwamura
 *
 */

@Controller
@RequestMapping
public class SimulationHomeController {

	@Autowired
	private CalculationService service;

	/**
	 * 初期表示処理を行います。
	 * @param form 画面フォーム
	 * @return 表示するテンプレート
	 */

	@GetMapping
	public String Home(@ModelAttribute SimulationForm form) {
		return "home";
	}

	/**
	 * 日付計算をもとに計算結果の一覧表示
	 * @param form 画面フォーム
	 * @param bindingResult 入力値検証の結果
	 * @param model モデル
	 * @return 表示するテンプレート
	 */

	@PostMapping
	public String simulation(@ModelAttribute @Validated SimulationForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "home";
		}

		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getFormula())));

		model.addAttribute("results", results);
		return "home";
	}

	/**
	 * 指定した計算式の削除
	 * @param 画面フォーム
	 * @param model
	 * @return 初期画面へ
	 */

	@PostMapping(value = "/{dateId}")
	public String delete(@PathVariable String dateId, Model model) {
		service.delete(dateId);
		model.addAttribute("simulationForm", new SimulationForm());
		return "home";
	}

}
