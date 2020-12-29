package com.example.dateapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dateapp.domain.DateFormula;

/**
 * 日付計算式の新規登録画面に紐づくコントローラー
 * @author kuwamura
 *
 */
@Controller
@RequestMapping("/create")
public class CreateController {
	/**
	 * 新規登録画面へ移動
	 * @param form 画面フォーム
	 * @return 表示するテンプレート
	 */

	@GetMapping
	public String index(@ModelAttribute DateFormula form) {
		return "create";
	}

}
