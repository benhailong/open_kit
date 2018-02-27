package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignRuleCrowdCountModel extends AlipayObject {

	private static final long serialVersionUID = 5821664974193122967L;

	@ApiField("mpid")
	private String mpid;

	@ApiField("ruleid")
	private String ruleid;

	@ApiField("scenetagjson")
	private String scenetagjson;

	public String getMpid() {
		return this.mpid;
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}

	public String getRuleid() {
		return this.ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getScenetagjson() {
		return this.scenetagjson;
	}
	public void setScenetagjson(String scenetagjson) {
		this.scenetagjson = scenetagjson;
	}

}
