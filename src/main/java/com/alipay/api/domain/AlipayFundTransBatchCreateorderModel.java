package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayFundTransBatchCreateorderModel extends AlipayObject {

	private static final long serialVersionUID = 4784862147138221347L;


	@ApiField("batch_no")
	private String batchNo;

	@ApiField("ext_param")
	private String extParam;

	@ApiField("pay_amount")
	private String payAmount;

	@ApiField("payee_id")
	private String payeeId;

	@ApiField("payer_id")
	private String payerId;

	@ApiField("token")
	private String token;

	public String getBatchNo() {
		return this.batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getExtParam() {
		return this.extParam;
	}
	public void setExtParam(String extParam) {
		this.extParam = extParam;
	}

	public String getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayeeId() {
		return this.payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayerId() {
		return this.payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
