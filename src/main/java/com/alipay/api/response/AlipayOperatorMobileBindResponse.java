package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;


public class AlipayOperatorMobileBindResponse extends AlipayResponse {

	private static final long serialVersionUID = 6899321118527335561L;

	@ApiField("alipay_user_id")
	private String alipayUserId;

	@ApiField("certificate")
	private String certificate;

	@ApiField("mobile_no")
	private String mobileNo;

	@ApiField("status")
	private String status;

	@ApiField("user_name")
	private String userName;

	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}
	public String getAlipayUserId( ) {
		return this.alipayUserId;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getCertificate( ) {
		return this.certificate;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMobileNo( ) {
		return this.mobileNo;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus( ) {
		return this.status;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName( ) {
		return this.userName;
	}

}
