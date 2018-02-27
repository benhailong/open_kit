package com.alipay.api.domain;

import java.util.Date;
import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class AlipayMarketingCardUpdateModel extends AlipayObject {

	private static final long serialVersionUID = 8344445886333475813L;


	@ApiField("card_info")
	private MerchantCard cardInfo;

	@ApiField("ext_info")
	private String extInfo;

	@ApiField("mcard_style_info")
	private McardStylInfo mcardStyleInfo;


	@ApiListField("notify_messages")
	@ApiField("mcard_notify_message")
	private List<McardNotifyMessage> notifyMessages;

	@ApiField("occur_time")
	private Date occurTime;

	@ApiField("target_card_no")
	private String targetCardNo;

	@ApiField("target_card_no_type")
	private String targetCardNoType;

	public MerchantCard getCardInfo() {
		return this.cardInfo;
	}
	public void setCardInfo(MerchantCard cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String getExtInfo() {
		return this.extInfo;
	}
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

	public McardStylInfo getMcardStyleInfo() {
		return this.mcardStyleInfo;
	}
	public void setMcardStyleInfo(McardStylInfo mcardStyleInfo) {
		this.mcardStyleInfo = mcardStyleInfo;
	}

	public List<McardNotifyMessage> getNotifyMessages() {
		return this.notifyMessages;
	}
	public void setNotifyMessages(List<McardNotifyMessage> notifyMessages) {
		this.notifyMessages = notifyMessages;
	}

	public Date getOccurTime() {
		return this.occurTime;
	}
	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getTargetCardNo() {
		return this.targetCardNo;
	}
	public void setTargetCardNo(String targetCardNo) {
		this.targetCardNo = targetCardNo;
	}

	public String getTargetCardNoType() {
		return this.targetCardNoType;
	}
	public void setTargetCardNoType(String targetCardNoType) {
		this.targetCardNoType = targetCardNoType;
	}

}
