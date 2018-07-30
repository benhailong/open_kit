package com.alipay.api.domain;

import java.util.Date;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCashlessvoucherTemplateCreateModel extends AlipayObject {

	private static final long serialVersionUID = 3216645949826735242L;

	@ApiField("amount")
	private String amount;

	@ApiField("brand_name")
	private String brandName;

	@ApiField("extension_info")
	private String extensionInfo;

	@ApiField("floor_amount")
	private String floorAmount;

	@ApiField("notify_uri")
	private String notifyUri;

	@ApiField("out_biz_no")
	private String outBizNo;

	@ApiField("publish_end_time")
	private Date publishEndTime;

	@ApiField("publish_start_time")
	private Date publishStartTime;

	@ApiField("rule_conf")
	private String ruleConf;

	@ApiField("voucher_available_time")
	private String voucherAvailableTime;

	@ApiField("voucher_description")
	private String voucherDescription;

	@ApiField("voucher_quantity")
	private Long voucherQuantity;

	@ApiField("voucher_type")
	private String voucherType;

	@ApiField("voucher_valid_period")
	private String voucherValidPeriod;

	public String getAmount() {
		return this.amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBrandName() {
		return this.brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getExtensionInfo() {
		return this.extensionInfo;
	}
	public void setExtensionInfo(String extensionInfo) {
		this.extensionInfo = extensionInfo;
	}

	public String getFloorAmount() {
		return this.floorAmount;
	}
	public void setFloorAmount(String floorAmount) {
		this.floorAmount = floorAmount;
	}

	public String getNotifyUri() {
		return this.notifyUri;
	}
	public void setNotifyUri(String notifyUri) {
		this.notifyUri = notifyUri;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public Date getPublishEndTime() {
		return this.publishEndTime;
	}
	public void setPublishEndTime(Date publishEndTime) {
		this.publishEndTime = publishEndTime;
	}

	public Date getPublishStartTime() {
		return this.publishStartTime;
	}
	public void setPublishStartTime(Date publishStartTime) {
		this.publishStartTime = publishStartTime;
	}

	public String getRuleConf() {
		return this.ruleConf;
	}
	public void setRuleConf(String ruleConf) {
		this.ruleConf = ruleConf;
	}

	public String getVoucherAvailableTime() {
		return this.voucherAvailableTime;
	}
	public void setVoucherAvailableTime(String voucherAvailableTime) {
		this.voucherAvailableTime = voucherAvailableTime;
	}

	public String getVoucherDescription() {
		return this.voucherDescription;
	}
	public void setVoucherDescription(String voucherDescription) {
		this.voucherDescription = voucherDescription;
	}

	public Long getVoucherQuantity() {
		return this.voucherQuantity;
	}
	public void setVoucherQuantity(Long voucherQuantity) {
		this.voucherQuantity = voucherQuantity;
	}

	public String getVoucherType() {
		return this.voucherType;
	}
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherValidPeriod() {
		return this.voucherValidPeriod;
	}
	public void setVoucherValidPeriod(String voucherValidPeriod) {
		this.voucherValidPeriod = voucherValidPeriod;
	}

}
