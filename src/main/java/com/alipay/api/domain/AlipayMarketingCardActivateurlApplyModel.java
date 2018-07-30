package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardActivateurlApplyModel extends AlipayObject {

	private static final long serialVersionUID = 3433979738134811487L;


	@ApiField("callback")
	private String callback;

	@ApiField("follow_app_id")
	private String followAppId;

	@ApiField("out_string")
	private String outString;

	@ApiField("template_id")
	private String templateId;

	public String getCallback() {
		return this.callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getFollowAppId() {
		return this.followAppId;
	}
	public void setFollowAppId(String followAppId) {
		this.followAppId = followAppId;
	}

	public String getOutString() {
		return this.outString;
	}
	public void setOutString(String outString) {
		this.outString = outString;
	}

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
