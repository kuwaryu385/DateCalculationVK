package com.example.dateapp.domain;

public class DateFormula {
	//	日付ID
	private String dateId;
	//日付名
	private String dateName;
	//加減値（年）
	private int adjustmentYear;
	//加減値（月）
	private int adjustmentMonth;
	//加減値 (日）
	private int adjustmentDay;

	//getter setterメソッドを配置し、以上の要素の取得と設定をする

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public int getAdjustmentYear() {
		return adjustmentYear;
	}

	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}

	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}

	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}

	public int getAdjustmentDay() {
		return adjustmentDay;
	}

	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}

}
