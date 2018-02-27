package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;


public class KoubeiMarketingDataBizadviserMyddsreportQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6598558937752921137L;


	@ApiField("result")
	private String result;

	public void setResult(String result) {
		this.result = result;
	}
	public String getResult( ) {
		return this.result;
	}

}
