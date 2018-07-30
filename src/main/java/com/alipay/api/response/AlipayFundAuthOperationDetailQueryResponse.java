package com.alipay.api.response;

import java.util.Date;
import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;


public class AlipayFundAuthOperationDetailQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7143851816732549715L;


	@ApiField("amount")
	private String amount;

	@ApiField("auth_no")
	private String authNo;


	@ApiField("extra_param")
	private String extraParam;

	@ApiField("gmt_create")
	private Date gmtCreate;

	@ApiField("gmt_trans")
	private Date gmtTrans;


	@ApiField("operation_id")
	private String operationId;

	@ApiField("operation_type")
	private String operationType;

	@ApiField("order_title")
	private String orderTitle;

	@ApiField("out_order_no")
	private String outOrderNo;

	@ApiField("out_request_no")
	private String outRequestNo;

	@ApiField("payer_logon_id")
	private String payerLogonId;

	@ApiField("payer_user_id")
	private String payerUserId;

	@ApiField("remark")
	private String remark;

	@ApiField("rest_amount")
	private String restAmount;

	@ApiField("status")
	private String status;

	@ApiField("total_freeze_amount")
	private String totalFreezeAmount;

	@ApiField("total_pay_amount")
	private String totalPayAmount;

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

	public void setExtraParam(String extraParam) {
		this.extraParam = extraParam;
	}
	public String getExtraParam( ) {
		return this.extraParam;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtCreate( ) {
		return this.gmtCreate;
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

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getOperationType( ) {
		return this.operationType;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}
	public String getOrderTitle( ) {
		return this.orderTitle;
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

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark( ) {
		return this.remark;
	}

	public void setRestAmount(String restAmount) {
		this.restAmount = restAmount;
	}
	public String getRestAmount( ) {
		return this.restAmount;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus( ) {
		return this.status;
	}

	public void setTotalFreezeAmount(String totalFreezeAmount) {
		this.totalFreezeAmount = totalFreezeAmount;
	}
	public String getTotalFreezeAmount( ) {
		return this.totalFreezeAmount;
	}

	public void setTotalPayAmount(String totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}
	public String getTotalPayAmount( ) {
		return this.totalPayAmount;
	}

}
