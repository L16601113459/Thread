package com.atguigu.thread1018;

public enum SeasonEnums {

	ONE(1, "Spring"), TWO(2, "Summer"), THREE(3, "Autumn"), FOUR(4, "Winter");

	private Integer retCode;
	private String retMessage;

	private SeasonEnums(Integer retCode, String retMessage) {
		this.retCode = retCode;
		this.retMessage = retMessage;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}

	public static SeasonEnums forEatchSeason(Integer index) {
		for (SeasonEnums seasons : values()) {
			if (seasons.getRetCode() == index) {
				return seasons;
			}
		}
		return null;
	}
}
