package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaMerchantOrderCreditPayModel extends AlipayObject {

	private static final long serialVersionUID = 7269456356662955637L;


	@ApiField("order_operate_type")
	private String orderOperateType;

	@ApiField("out_order_no")
	private String outOrderNo;

	@ApiField("out_trans_no")
	private String outTransNo;

	@ApiField("pay_amount")
	private String payAmount;

	@ApiField("remark")
	private String remark;

	@ApiField("zm_order_no")
	private String zmOrderNo;

	public String getOrderOperateType() {
		return this.orderOperateType;
	}
	public void setOrderOperateType(String orderOperateType) {
		this.orderOperateType = orderOperateType;
	}

	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getOutTransNo() {
		return this.outTransNo;
	}
	public void setOutTransNo(String outTransNo) {
		this.outTransNo = outTransNo;
	}

	public String getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getZmOrderNo() {
		return this.zmOrderNo;
	}
	public void setZmOrderNo(String zmOrderNo) {
		this.zmOrderNo = zmOrderNo;
	}

}
