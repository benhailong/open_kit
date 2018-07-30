package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

public class AlipayFundAuthOperationCancelResponse extends AlipayResponse {

	private static final long serialVersionUID = 7473476949794629931L;

	@ApiField("action")
	private String action;

	@ApiField("auth_no")
	private String authNo;

	@ApiField("operation_id")
	private String operationId;

	@ApiField("out_order_no")
	private String outOrderNo;

	@ApiField("out_request_no")
	private String outRequestNo;

	public void setAction(String action) {
		this.action = action;
	}
	public String getAction( ) {
		return this.action;
	}

	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	public String getAuthNo( ) {
		return this.authNo;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getOperationId( ) {
		return this.operationId;
	}

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	public String getOutOrderNo( ) {
		return this.outOrderNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}
	public String getOutRequestNo( ) {
		return this.outRequestNo;
	}

}
