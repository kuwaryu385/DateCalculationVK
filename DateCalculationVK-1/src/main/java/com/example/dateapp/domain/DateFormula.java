package com.example.dateapp.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 日付計算式を表現するクラス
 * @author kuwamura
 *
 */

public class DateFormula {
	/**日付ID*/
	@NotBlank
	@Size(min = 1, max = 8)
	private String dateId;
	/**日付名*/
	@NotBlank
	@Size(min = 1, max = 20)
	private String dateName;
	/**加減値（年）*/

	private int adjustmentYear;
	/**加減値（月）*/

	private int adjustmentMonth;
	/**加減値 (日）*/

	private int adjustmentDay;

	//実は以上の年・月・日の入力へのValidationを試みたが、＠NotEnptyや＠NotBlankはint型は受け付けない模様
	//他の方法を色々試したが、空文字の対応するメッセージを表示することができずとりあえず保留。
	//HTML側でフォームに空白時に検証をかけるrequiredを実装して一時対応

	//getter setterメソッドを配置し、以上の要素の取得と設定をする

	/**
	 * 日付IDの取得
	 * @return 日付ID
	 */

	public String getDateId() {
		return dateId;
	}

	/**
	 * 日付IDを設定
	 * @param dateId 日付ID
	 */

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	/**
	 * 日付名を取得。
	 * @return 日付名
	 */

	public String getDateName() {
		return dateName;
	}

	/**
	 * 日付名を設定
	 * @param dateName 日付名
	 */

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	/**
	 * 加減値（年）を取得
	 * @return 加減値（年）
	 */

	public int getAdjustmentYear() {
		return adjustmentYear;
	}

	/**
	 * 加減値(年)を設定
	 * @param adjustmentYear
	 */
	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}

	/**
	 * 加減値(月）を取得
	 * @return 加減値（月）
	 */

	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}

	/**
	 * 加減値(月）を設定します。
	 * @param adjustmentMonth
	 */

	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}

	/**
	 * 加減値(日）を設定します
	 * @return 加減値(日）
	 */

	public int getAdjustmentDay() {
		return adjustmentDay;
	}

	/**
	 * 加減値(日）を設定します。
	 * @param adjustmentDay
	 */

	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}

}
