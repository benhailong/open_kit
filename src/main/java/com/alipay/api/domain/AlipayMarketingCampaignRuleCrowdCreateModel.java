package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignRuleCrowdCreateModel extends AlipayObject {

	private static final long serialVersionUID = 7373725325537593369L;

	@ApiField("mdatacrowdsource")
	private String mdatacrowdsource;

	@ApiField("mpid")
	private String mpid;

	@ApiField("ruledesc")
	private String ruledesc;

	public String getMdatacrowdsource() {
		return this.mdatacrowdsource;
	}
	public void setMdatacrowdsource(String mdatacrowdsource) {
		this.mdatacrowdsource = mdatacrowdsource;
	}

	public String getMpid() {
		return this.mpid;
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}

	public String getRuledesc() {
		return this.ruledesc;
	}
	public void setRuledesc(String ruledesc) {
		this.ruledesc = ruledesc;
	}

}
