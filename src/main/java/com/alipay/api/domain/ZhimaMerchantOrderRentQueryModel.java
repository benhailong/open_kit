package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ZhimaMerchantOrderRentQueryModel extends AlipayObject {

	private static final long serialVersionUID = 1429223211317672666L;

	@ApiField("out_order_no")
	private String outOrderNo;

	@ApiField("product_code")
	private String productCode;

	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
