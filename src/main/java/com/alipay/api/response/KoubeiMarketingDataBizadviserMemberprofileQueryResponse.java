package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

public class KoubeiMarketingDataBizadviserMemberprofileQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7365143675653699913L;

	@ApiField("result")
	private String result;

	public void setResult(String result) {
		this.result = result;
	}
	public String getResult( ) {
		return this.result;
	}

}
