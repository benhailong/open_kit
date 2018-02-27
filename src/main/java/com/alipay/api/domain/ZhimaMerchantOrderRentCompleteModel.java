package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaMerchantOrderRentCompleteModel extends AlipayObject {

	private static final long serialVersionUID = 1523823782896636152L;

	@ApiField("extend_info")
	private String extendInfo;

	@ApiField("order_no")
	private String orderNo;

	@ApiField("pay_amount")
	private String payAmount;

	@ApiField("pay_amount_type")
	private String payAmountType;

	@ApiField("product_code")
	private String productCode;

	@ApiField("restore_shop_name")
	private String restoreShopName;

	@ApiField("restore_time")
	private String restoreTime;

	public String getExtendInfo() {
		return this.extendInfo;
	}
	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayAmountType() {
		return this.payAmountType;
	}
	public void setPayAmountType(String payAmountType) {
		this.payAmountType = payAmountType;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getRestoreShopName() {
		return this.restoreShopName;
	}
	public void setRestoreShopName(String restoreShopName) {
		this.restoreShopName = restoreShopName;
	}

	public String getRestoreTime() {
		return this.restoreTime;
	}
	public void setRestoreTime(String restoreTime) {
		this.restoreTime = restoreTime;
	}

}
