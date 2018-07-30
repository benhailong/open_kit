package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class KoubeiAdvertCommissionAdvertPurchaseModel extends AlipayObject {

	private static final long serialVersionUID = 3678123511722681951L;

	@ApiField("channel_id")
	private String channelId;

	@ApiField("out_unique_id")
	private String outUniqueId;

	@ApiField("security_code")
	private String securityCode;

	@ApiField("tag")
	private String tag;

	@ApiListField("trigger_identifies")
	@ApiField("string")
	private List<String> triggerIdentifies;

	@ApiField("trigger_identify_type")
	private String triggerIdentifyType;

	@ApiField("trigger_strategy")
	private String triggerStrategy;

	@ApiField("user_identify")
	private String userIdentify;

	@ApiField("user_identify_type")
	private String userIdentifyType;

	public String getChannelId() {
		return this.channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getOutUniqueId() {
		return this.outUniqueId;
	}
	public void setOutUniqueId(String outUniqueId) {
		this.outUniqueId = outUniqueId;
	}

	public String getSecurityCode() {
		return this.securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getTag() {
		return this.tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<String> getTriggerIdentifies() {
		return this.triggerIdentifies;
	}
	public void setTriggerIdentifies(List<String> triggerIdentifies) {
		this.triggerIdentifies = triggerIdentifies;
	}

	public String getTriggerIdentifyType() {
		return this.triggerIdentifyType;
	}
	public void setTriggerIdentifyType(String triggerIdentifyType) {
		this.triggerIdentifyType = triggerIdentifyType;
	}

	public String getTriggerStrategy() {
		return this.triggerStrategy;
	}
	public void setTriggerStrategy(String triggerStrategy) {
		this.triggerStrategy = triggerStrategy;
	}

	public String getUserIdentify() {
		return this.userIdentify;
	}
	public void setUserIdentify(String userIdentify) {
		this.userIdentify = userIdentify;
	}

	public String getUserIdentifyType() {
		return this.userIdentifyType;
	}
	public void setUserIdentifyType(String userIdentifyType) {
		this.userIdentifyType = userIdentifyType;
	}

}
