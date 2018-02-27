package com.alipay.api.response;

import java.util.Date;
import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

public class AlipayFundAuthOrderFreezeResponse extends AlipayResponse {

	private static final long serialVersionUID = 1558283932413255757L;

	@ApiField("amount")
	private String amount;

	@ApiField("auth_no")
	private String authNo;

	@ApiField("gmt_trans")
	private Date gmtTrans;

	@ApiField("operation_id")
	private String operationId;

	@ApiField("out_order_no")
	private String outOrderNo;

	@ApiField("out_request_no")
	private String outRequestNo;

	@ApiField("payer_logon_id")
	private String payerLogonId;

	@ApiField("payer_user_id")
	private String payerUserId;

	@ApiField("pre_auth_type")
	private String preAuthType;

	@ApiField("status")
	private String status;

	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmount( ) {
		return this.amount;
	}

	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	public String getAuthNo( ) {
		return this.authNo;
	}

	public void setGmtTrans(Date gmtTrans) {
		this.gmtTrans = gmtTrans;
	}
	public Date getGmtTrans( ) {
		return this.gmtTrans;
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

	public void setPayerLogonId(String payerLogonId) {
		this.payerLogonId = payerLogonId;
	}
	public String getPayerLogonId( ) {
		return this.payerLogonId;
	}

	public void setPayerUserId(String payerUserId) {
		this.payerUserId = payerUserId;
	}
	public String getPayerUserId( ) {
		return this.payerUserId;
	}

	public void setPreAuthType(String preAuthType) {
		this.preAuthType = preAuthType;
	}
	public String getPreAuthType( ) {
		return this.preAuthType;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus( ) {
		return this.status;
	}

}
