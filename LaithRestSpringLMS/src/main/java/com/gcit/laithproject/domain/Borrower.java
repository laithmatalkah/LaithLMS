package com.gcit.laithproject.domain;

import java.io.Serializable;

public class Borrower implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cardNo;
	private String borroName;
	private String borroAddress;
	private String borroPhone;
	/**
	 * @return the cardNo
	 */
	public Integer getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the borroName
	 */
	public String getBorroName() {
		return borroName;
	}
	/**
	 * @param borroName the borroName to set
	 */
	public void setBorroName(String borroName) {
		this.borroName = borroName;
	}
	/**
	 * @return the borroAddress
	 */
	public String getBorroAddress() {
		return borroAddress;
	}
	/**
	 * @param borroAddress the borroAddress to set
	 */
	public void setBorroAddress(String borroAddress) {
		this.borroAddress = borroAddress;
	}
	/**
	 * @return the borroPhone
	 */
	public String getBorroPhone() {
		return borroPhone;
	}
	/**
	 * @param borroPhone the borroPhone to set
	 */
	public void setBorroPhone(String borroPhone) {
		this.borroPhone = borroPhone;
	}
	
	

}
