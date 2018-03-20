package com.atguigu.thread1018;

/**
 * 秦齐楚燕赵魏韩
 * 
 * @author Wp
 *
 */
public enum CountryEnums {

	ONE(1, "韩"), TWO(2, "赵"), THREE(3, "魏"), FOUR(4, "燕"), FIVE(5, "楚"), SIX(6, "齐");

	private Integer retCode;
	private String retMsg;

	private CountryEnums(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public static CountryEnums forEachCountryEnums(Integer index) {
		for (CountryEnums element : values()) {
			if (element.getRetCode() == index) {
				return element;
			}
		}

		return null;
	}
}
