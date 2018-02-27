package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ChargeItems extends AlipayObject {

	private static final long serialVersionUID = 7448855438389358624L;

	@ApiField("item_mandatory")
	private String itemMandatory;

	@ApiField("item_max_num")
	private Long itemMaxNum;

	@ApiField("item_name")
	private String itemName;

	@ApiField("item_price")
	private String itemPrice;

	@ApiField("item_serial_number")
	private Long itemSerialNumber;

	public String getItemMandatory() {
		return this.itemMandatory;
	}
	public void setItemMandatory(String itemMandatory) {
		this.itemMandatory = itemMandatory;
	}

	public Long getItemMaxNum() {
		return this.itemMaxNum;
	}
	public void setItemMaxNum(Long itemMaxNum) {
		this.itemMaxNum = itemMaxNum;
	}

	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return this.itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Long getItemSerialNumber() {
		return this.itemSerialNumber;
	}
	public void setItemSerialNumber(Long itemSerialNumber) {
		this.itemSerialNumber = itemSerialNumber;
	}

}
