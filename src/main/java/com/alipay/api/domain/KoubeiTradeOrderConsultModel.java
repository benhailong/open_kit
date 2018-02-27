package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class KoubeiTradeOrderConsultModel extends AlipayObject {

	private static final long serialVersionUID = 5871759816673821426L;

	@ApiField("apdid_token")
	private String apdidToken;

	@ApiListField("goods_info")
	@ApiField("goods_info")
	private List<GoodsInfo> goodsInfo;

	@ApiField("request_id")
	private String requestId;

	@ApiField("shop_id")
	private String shopId;

	@ApiField("total_amount")
	private String totalAmount;

	@ApiField("undiscountable_amount")
	private String undiscountableAmount;

	@ApiField("user_id")
	private String userId;

	public String getApdidToken() {
		return this.apdidToken;
	}
	public void setApdidToken(String apdidToken) {
		this.apdidToken = apdidToken;
	}

	public List<GoodsInfo> getGoodsInfo() {
		return this.goodsInfo;
	}
	public void setGoodsInfo(List<GoodsInfo> goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getRequestId() {
		return this.requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUndiscountableAmount() {
		return this.undiscountableAmount;
	}
	public void setUndiscountableAmount(String undiscountableAmount) {
		this.undiscountableAmount = undiscountableAmount;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
