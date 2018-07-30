package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaMerchantOrderRentCancelModel extends AlipayObject {

	private static final long serialVersionUID = 4883249425621515267L;


	@ApiField("order_no")
	private String orderNo;

	@ApiField("product_code")
	private String productCode;

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
