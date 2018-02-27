package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;


public class AlipayFundAuthOrderVoucherCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 2398921235185511887L;


	@ApiField("code_type")
	private String codeType;

	@ApiField("code_url")
	private String codeUrl;


	@ApiField("code_value")
	private String codeValue;

	@ApiField("out_order_no")
	private String outOrderNo;


	@ApiField("out_request_no")
	private String outRequestNo;

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCodeType( ) {
		return this.codeType;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	public String getCodeUrl( ) {
		return this.codeUrl;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeValue( ) {
		return this.codeValue;
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
