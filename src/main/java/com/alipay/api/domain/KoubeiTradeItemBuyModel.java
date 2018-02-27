package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiTradeItemBuyModel extends AlipayObject {

	private static final long serialVersionUID = 8646724473375266282L;

	@ApiField("buyer_phone_number")
	private String buyerPhoneNumber;

	@ApiField("buyer_user_name")
	private String buyerUserName;

	@ApiField("craftsman_id")
	private String craftsmanId;

	@ApiField("current_price")
	private String currentPrice;

	@ApiField("ext_info")
	private String extInfo;

	@ApiField("item_id")
	private String itemId;

	@ApiField("original_price")
	private String originalPrice;

	@ApiField("out_biz_no")
	private String outBizNo;

	@ApiField("partner_id")
	private String partnerId;

	@ApiField("quantity")
	private Long quantity;

	@ApiField("reserve_end_time")
	private String reserveEndTime;

	@ApiField("reserve_start_time")
	private String reserveStartTime;

	@ApiField("shop_id")
	private String shopId;

	public String getBuyerPhoneNumber() {
		return this.buyerPhoneNumber;
	}
	public void setBuyerPhoneNumber(String buyerPhoneNumber) {
		this.buyerPhoneNumber = buyerPhoneNumber;
	}

	public String getBuyerUserName() {
		return this.buyerUserName;
	}
	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public String getCraftsmanId() {
		return this.craftsmanId;
	}
	public void setCraftsmanId(String craftsmanId) {
		this.craftsmanId = craftsmanId;
	}

	public String getCurrentPrice() {
		return this.currentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getExtInfo() {
		return this.extInfo;
	}
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

	public String getItemId() {
		return this.itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getOriginalPrice() {
		return this.originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public Long getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getReserveEndTime() {
		return this.reserveEndTime;
	}
	public void setReserveEndTime(String reserveEndTime) {
		this.reserveEndTime = reserveEndTime;
	}

	public String getReserveStartTime() {
		return this.reserveStartTime;
	}
	public void setReserveStartTime(String reserveStartTime) {
		this.reserveStartTime = reserveStartTime;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
