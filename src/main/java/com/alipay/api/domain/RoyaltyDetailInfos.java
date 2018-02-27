package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class RoyaltyDetailInfos extends AlipayObject {

	private static final long serialVersionUID = 1596266226884331899L;

	@ApiField("amount")
	private Long amount;

	@ApiField("amount_percentage")
	private String amountPercentage;

	@ApiField("batch_no")
	private String batchNo;

	@ApiField("desc")
	private String desc;

	@ApiField("out_relation_id")
	private String outRelationId;

	@ApiField("serial_no")
	private Long serialNo;

	@ApiField("trans_in")
	private String transIn;

	@ApiField("trans_in_type")
	private String transInType;

	@ApiField("trans_out")
	private String transOut;

	@ApiField("trans_out_type")
	private String transOutType;

	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getAmountPercentage() {
		return this.amountPercentage;
	}
	public void setAmountPercentage(String amountPercentage) {
		this.amountPercentage = amountPercentage;
	}

	public String getBatchNo() {
		return this.batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getDesc() {
		return this.desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getOutRelationId() {
		return this.outRelationId;
	}
	public void setOutRelationId(String outRelationId) {
		this.outRelationId = outRelationId;
	}

	public Long getSerialNo() {
		return this.serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public String getTransIn() {
		return this.transIn;
	}
	public void setTransIn(String transIn) {
		this.transIn = transIn;
	}

	public String getTransInType() {
		return this.transInType;
	}
	public void setTransInType(String transInType) {
		this.transInType = transInType;
	}

	public String getTransOut() {
		return this.transOut;
	}
	public void setTransOut(String transOut) {
		this.transOut = transOut;
	}

	public String getTransOutType() {
		return this.transOutType;
	}
	public void setTransOutType(String transOutType) {
		this.transOutType = transOutType;
	}

}
