package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayFundTransBatchCreatesinglebatchModel extends AlipayObject {

	private static final long serialVersionUID = 7755323937836371416L;


	@ApiField("batch_memo")
	private String batchMemo;

	@ApiField("biz_type")
	private String bizType;

	@ApiField("create_user_id")
	private String createUserId;

	@ApiField("ext_param")
	private String extParam;

	@ApiField("pay_amount_single")
	private String payAmountSingle;

	@ApiField("pay_amount_total")
	private String payAmountTotal;

	@ApiField("real_items_total")
	private String realItemsTotal;

	@ApiField("show_items_total")
	private String showItemsTotal;

	public String getBatchMemo() {
		return this.batchMemo;
	}
	public void setBatchMemo(String batchMemo) {
		this.batchMemo = batchMemo;
	}

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getExtParam() {
		return this.extParam;
	}
	public void setExtParam(String extParam) {
		this.extParam = extParam;
	}

	public String getPayAmountSingle() {
		return this.payAmountSingle;
	}
	public void setPayAmountSingle(String payAmountSingle) {
		this.payAmountSingle = payAmountSingle;
	}

	public String getPayAmountTotal() {
		return this.payAmountTotal;
	}
	public void setPayAmountTotal(String payAmountTotal) {
		this.payAmountTotal = payAmountTotal;
	}

	public String getRealItemsTotal() {
		return this.realItemsTotal;
	}
	public void setRealItemsTotal(String realItemsTotal) {
		this.realItemsTotal = realItemsTotal;
	}

	public String getShowItemsTotal() {
		return this.showItemsTotal;
	}
	public void setShowItemsTotal(String showItemsTotal) {
		this.showItemsTotal = showItemsTotal;
	}

}
