package com.example.dateapp.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.dateapp.service.CalculationService;
/**
 * 日付計算処理をシュミレートするHOME画面に紐づくコントローラー
 * @author kuwamura
 *
 */

@Controller
@RequestMapping
public class SimulationHomeController {

	//	@Autowired
	//	private CalculationService.service;

	//Home画面の表示
	@GetMapping
	public String Home(Model model) {
		return "home";
	}

	//		//本のIDにて、本の内容を取得
	//		@GetMapping("{id}")
	//		public String show(@PathVariable Integer id, Model model) {
	//			model.addAttribute("mybook", myBooksService.selectOne(id));
	//			return "show";
	//		}

	//	新規作成画面の表示
	@GetMapping("create")
	public String Create(Model model) {
		//		MyBooksModel mybooks = new MyBooksModel();
		//		model.addAttribute("myBook", mybooks);
		return "create";
	}

	//変更画面の表示
	//		@GetMapping("{id}/edit")
	//		public String edit(@PathVariable Integer id, @ModelAttribute("mybook") MyBooksModel myBooksModel, Model model) {
	//			model.addAttribute("mybook", myBooksService.selectOne(id));
	//			return "edit";
	//		}

	//新規作成画面の挿入処理　エラーで戻り、成功したら一覧へ画面遷移
	//		@PostMapping
	//		public String postBooksCreate(@ModelAttribute("mybook") @Validated MyBooksModel myBooksModel,
	//				BindingResult bindingResult) {
	//			if (bindingResult.hasErrors()) {
	//				return "new";
	//			}
	//			myBooksService.insert(myBooksModel);
	//			return "redirect:/";
	//		}

	//登録情報を更新画面へ　入力なければ、エラー出て戻り、更新したら一覧画面へ値が更新されて戻る
	//		@PutMapping("{id}") //POSTでもいけるかもです
	//		public String updateBooks(@PathVariable Integer id, @ModelAttribute("mybook") @Validated MyBooksModel myBooksModel,
	//				BindingResult bindingResult, Model model) {
	//			if (bindingResult.hasErrors()) {
	//				model.addAttribute("mybook", myBooksModel);
	//				return "edit";
	//			} else {
	//				myBooksModel.setId(id);
	//				myBooksService.update(myBooksModel);
	//				return "redirect:/";
	//			}
	//		}

	//登録された計算式を削除します
	//		@DeleteMapping("{id}")
	//		public String delete(@PathVariable Integer id) {
	//			myBooksService.delete(id);
	//			return "redirect:/";
	//		}

}
