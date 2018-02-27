package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaMerchantOrderConfirmModel extends AlipayObject {

	private static final long serialVersionUID = 1675877186136847575L;


	@ApiField("order_no")
	private String orderNo;

	@ApiField("transaction_id")
	private String transactionId;

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
