package com.example.dateapp.domain;

/**
 * 日付計算式を表現するクラス
 * @author kuwamura
 *
 */

public class DateFormula {
	/**日付ID*/
	private String dateId;
	/**日付名*/
	private String dateName;
	/**加減値（年）*/
	private int adjustmentYear;
	/**加減値（月）*/
	private int adjustmentMonth;
	/**加減値 (日）*/
	private int adjustmentDay;

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
