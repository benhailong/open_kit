package com.alipay.api.domain;

import java.util.Date;
import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class ConsumeRecordAOPModel extends AlipayObject {

	private static final long serialVersionUID = 3786138714158664636L;

	@ApiField("access_channel")
	private String accessChannel;

	@ApiField("additional_status")
	private String additionalStatus;

	@ApiListField("biz_actions")
	@ApiField("string")
	private List<String> bizActions;

	@ApiField("biz_extra_no")
	private String bizExtraNo;

	@ApiField("biz_in_no")
	private String bizInNo;

	@ApiField("biz_memo")
	private String bizMemo;


	@ApiField("biz_orig")
	private String bizOrig;

	@ApiField("biz_out_no")
	private String bizOutNo;

	@ApiField("biz_state")
	private String bizState;

	@ApiField("biz_sub_type")
	private String bizSubType;


	@ApiField("biz_type")
	private String bizType;


	@ApiField("category_id")
	private String categoryId;

	@ApiField("consume_fee")
	private String consumeFee;

	@ApiField("consume_refund_status")
	private String consumeRefundStatus;

	@ApiField("consume_site")
	private String consumeSite;

	@ApiField("consume_status")
	private String consumeStatus;

	@ApiField("consume_title")
	private String consumeTitle;

	@ApiField("consume_type")
	private String consumeType;

	@ApiField("currency")
	private String currency;

	@ApiField("delete_over_time")
	private Date deleteOverTime;

	@ApiField("delete_time")
	private Date deleteTime;

	@ApiField("delete_type")
	private String deleteType;

	@ApiField("depositback_status")
	private String depositbackStatus;

	@ApiField("flag_locked")
	private String flagLocked;

	@ApiField("flag_refund")
	private String flagRefund;

	@ApiField("gmt_biz_create")
	private Date gmtBizCreate;

	@ApiField("gmt_biz_modified")
	private Date gmtBizModified;

	@ApiField("gmt_create")
	private Date gmtCreate;

	@ApiField("gmt_modified")
	private Date gmtModified;

	@ApiField("gmt_receive_pay")
	private Date gmtReceivePay;

	@ApiField("gmt_send_pay")
	private Date gmtSendPay;

	@ApiField("has_fund_item")
	private Boolean hasFundItem;

	@ApiField("has_new_fund_item")
	private Boolean hasNewFundItem;

	@ApiField("in_out")
	private String inOut;

	@ApiField("opposite_card_no")
	private String oppositeCardNo;

	@ApiField("opposite_login_id")
	private String oppositeLoginId;

	@ApiField("opposite_name")
	private String oppositeName;

	@ApiField("opposite_nick_name")
	private String oppositeNickName;

	@ApiField("orig_consume_title")
	private String origConsumeTitle;

	@ApiField("owner_card_no")
	private String ownerCardNo;

	@ApiField("owner_customer_id")
	private String ownerCustomerId;

	@ApiField("owner_login_id")
	private String ownerLoginId;

	@ApiField("owner_name")
	private String ownerName;

	@ApiField("owner_nick")
	private String ownerNick;

	@ApiField("partner_id")
	private String partnerId;

	@ApiField("pay_channel")
	private String payChannel;

	@ApiField("peerpayer_real_name")
	private String peerpayerRealName;

	@ApiField("product")
	private String product;

	@ApiField("refund_fee")
	private String refundFee;

	@ApiField("service_fee")
	private String serviceFee;

	@ApiField("total_refund_fee")
	private String totalRefundFee;

	@ApiField("trade_from")
	private String tradeFrom;

	public String getAccessChannel() {
		return this.accessChannel;
	}
	public void setAccessChannel(String accessChannel) {
		this.accessChannel = accessChannel;
	}

	public String getAdditionalStatus() {
		return this.additionalStatus;
	}
	public void setAdditionalStatus(String additionalStatus) {
		this.additionalStatus = additionalStatus;
	}

	public List<String> getBizActions() {
		return this.bizActions;
	}
	public void setBizActions(List<String> bizActions) {
		this.bizActions = bizActions;
	}

	public String getBizExtraNo() {
		return this.bizExtraNo;
	}
	public void setBizExtraNo(String bizExtraNo) {
		this.bizExtraNo = bizExtraNo;
	}

	public String getBizInNo() {
		return this.bizInNo;
	}
	public void setBizInNo(String bizInNo) {
		this.bizInNo = bizInNo;
	}

	public String getBizMemo() {
		return this.bizMemo;
	}
	public void setBizMemo(String bizMemo) {
		this.bizMemo = bizMemo;
	}

	public String getBizOrig() {
		return this.bizOrig;
	}
	public void setBizOrig(String bizOrig) {
		this.bizOrig = bizOrig;
	}

	public String getBizOutNo() {
		return this.bizOutNo;
	}
	public void setBizOutNo(String bizOutNo) {
		this.bizOutNo = bizOutNo;
	}

	public String getBizState() {
		return this.bizState;
	}
	public void setBizState(String bizState) {
		this.bizState = bizState;
	}

	public String getBizSubType() {
		return this.bizSubType;
	}
	public void setBizSubType(String bizSubType) {
		this.bizSubType = bizSubType;
	}

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getConsumeFee() {
		return this.consumeFee;
	}
	public void setConsumeFee(String consumeFee) {
		this.consumeFee = consumeFee;
	}

	public String getConsumeRefundStatus() {
		return this.consumeRefundStatus;
	}
	public void setConsumeRefundStatus(String consumeRefundStatus) {
		this.consumeRefundStatus = consumeRefundStatus;
	}

	public String getConsumeSite() {
		return this.consumeSite;
	}
	public void setConsumeSite(String consumeSite) {
		this.consumeSite = consumeSite;
	}

	public String getConsumeStatus() {
		return this.consumeStatus;
	}
	public void setConsumeStatus(String consumeStatus) {
		this.consumeStatus = consumeStatus;
	}

	public String getConsumeTitle() {
		return this.consumeTitle;
	}
	public void setConsumeTitle(String consumeTitle) {
		this.consumeTitle = consumeTitle;
	}

	public String getConsumeType() {
		return this.consumeType;
	}
	public void setConsumeType(String consumeType) {
		this.consumeType = consumeType;
	}

	public String getCurrency() {
		return this.currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDeleteOverTime() {
		return this.deleteOverTime;
	}
	public void setDeleteOverTime(Date deleteOverTime) {
		this.deleteOverTime = deleteOverTime;
	}

	public Date getDeleteTime() {
		return this.deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeleteType() {
		return this.deleteType;
	}
	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}

	public String getDepositbackStatus() {
		return this.depositbackStatus;
	}
	public void setDepositbackStatus(String depositbackStatus) {
		this.depositbackStatus = depositbackStatus;
	}

	public String getFlagLocked() {
		return this.flagLocked;
	}
	public void setFlagLocked(String flagLocked) {
		this.flagLocked = flagLocked;
	}

	public String getFlagRefund() {
		return this.flagRefund;
	}
	public void setFlagRefund(String flagRefund) {
		this.flagRefund = flagRefund;
	}

	public Date getGmtBizCreate() {
		return this.gmtBizCreate;
	}
	public void setGmtBizCreate(Date gmtBizCreate) {
		this.gmtBizCreate = gmtBizCreate;
	}

	public Date getGmtBizModified() {
		return this.gmtBizModified;
	}
	public void setGmtBizModified(Date gmtBizModified) {
		this.gmtBizModified = gmtBizModified;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return this.gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtReceivePay() {
		return this.gmtReceivePay;
	}
	public void setGmtReceivePay(Date gmtReceivePay) {
		this.gmtReceivePay = gmtReceivePay;
	}

	public Date getGmtSendPay() {
		return this.gmtSendPay;
	}
	public void setGmtSendPay(Date gmtSendPay) {
		this.gmtSendPay = gmtSendPay;
	}

	public Boolean getHasFundItem() {
		return this.hasFundItem;
	}
	public void setHasFundItem(Boolean hasFundItem) {
		this.hasFundItem = hasFundItem;
	}

	public Boolean getHasNewFundItem() {
		return this.hasNewFundItem;
	}
	public void setHasNewFundItem(Boolean hasNewFundItem) {
		this.hasNewFundItem = hasNewFundItem;
	}

	public String getInOut() {
		return this.inOut;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public String getOppositeCardNo() {
		return this.oppositeCardNo;
	}
	public void setOppositeCardNo(String oppositeCardNo) {
		this.oppositeCardNo = oppositeCardNo;
	}

	public String getOppositeLoginId() {
		return this.oppositeLoginId;
	}
	public void setOppositeLoginId(String oppositeLoginId) {
		this.oppositeLoginId = oppositeLoginId;
	}

	public String getOppositeName() {
		return this.oppositeName;
	}
	public void setOppositeName(String oppositeName) {
		this.oppositeName = oppositeName;
	}

	public String getOppositeNickName() {
		return this.oppositeNickName;
	}
	public void setOppositeNickName(String oppositeNickName) {
		this.oppositeNickName = oppositeNickName;
	}

	public String getOrigConsumeTitle() {
		return this.origConsumeTitle;
	}
	public void setOrigConsumeTitle(String origConsumeTitle) {
		this.origConsumeTitle = origConsumeTitle;
	}

	public String getOwnerCardNo() {
		return this.ownerCardNo;
	}
	public void setOwnerCardNo(String ownerCardNo) {
		this.ownerCardNo = ownerCardNo;
	}

	public String getOwnerCustomerId() {
		return this.ownerCustomerId;
	}
	public void setOwnerCustomerId(String ownerCustomerId) {
		this.ownerCustomerId = ownerCustomerId;
	}

	public String getOwnerLoginId() {
		return this.ownerLoginId;
	}
	public void setOwnerLoginId(String ownerLoginId) {
		this.ownerLoginId = ownerLoginId;
	}

	public String getOwnerName() {
		return this.ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerNick() {
		return this.ownerNick;
	}
	public void setOwnerNick(String ownerNick) {
		this.ownerNick = ownerNick;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPayChannel() {
		return this.payChannel;
	}
	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getPeerpayerRealName() {
		return this.peerpayerRealName;
	}
	public void setPeerpayerRealName(String peerpayerRealName) {
		this.peerpayerRealName = peerpayerRealName;
	}

	public String getProduct() {
		return this.product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public String getRefundFee() {
		return this.refundFee;
	}
	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}

	public String getServiceFee() {
		return this.serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getTotalRefundFee() {
		return this.totalRefundFee;
	}
	public void setTotalRefundFee(String totalRefundFee) {
		this.totalRefundFee = totalRefundFee;
	}

	public String getTradeFrom() {
		return this.tradeFrom;
	}
	public void setTradeFrom(String tradeFrom) {
		this.tradeFrom = tradeFrom;
	}

}
