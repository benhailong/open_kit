package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaMerchantOrderRentModifyModel extends AlipayObject {

	private static final long serialVersionUID = 4793927194764253387L;

	@ApiField("borrow_time")
	private String borrowTime;


	@ApiField("expiry_time")
	private String expiryTime;

	@ApiField("order_no")
	private String orderNo;

	@ApiField("product_code")
	private String productCode;

	public String getBorrowTime() {
		return this.borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public String getExpiryTime() {
		return this.expiryTime;
	}
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
