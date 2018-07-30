package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ZhimaMerchantOrderRentCreateModel extends AlipayObject {

	private static final long serialVersionUID = 7262465638275137989L;


	@ApiField("address")
	private String address;


	@ApiField("borrow_cycle")
	private String borrowCycle;


	@ApiField("borrow_cycle_unit")
	private String borrowCycleUnit;


	@ApiField("borrow_shop_name")
	private String borrowShopName;

	@ApiField("borrow_time")
	private String borrowTime;

	@ApiField("cert_no")
	private String certNo;

	@ApiField("credit_biz")
	private String creditBiz;

	@ApiField("deposit_amount")
	private String depositAmount;

	@ApiField("deposit_state")
	private String depositState;

	@ApiField("expiry_time")
	private String expiryTime;

	@ApiField("goods_name")
	private String goodsName;

	@ApiField("invoke_return_url")
	private String invokeReturnUrl;

	@ApiField("invoke_state")
	private String invokeState;

	@ApiField("invoke_type")
	private String invokeType;

	@ApiField("mobile_no")
	private String mobileNo;

	@ApiField("name")
	private String name;

	@ApiField("notify_url")
	private String notifyUrl;

	@ApiField("out_order_no")
	private String outOrderNo;

	@ApiField("product_code")
	private String productCode;

	@ApiField("rent_amount")
	private String rentAmount;

	@ApiField("rent_info")
	private String rentInfo;

	@ApiField("rent_settle_type")
	private String rentSettleType;

	@ApiField("rent_unit")
	private String rentUnit;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getBorrowCycle() {
		return this.borrowCycle;
	}
	public void setBorrowCycle(String borrowCycle) {
		this.borrowCycle = borrowCycle;
	}

	public String getBorrowCycleUnit() {
		return this.borrowCycleUnit;
	}
	public void setBorrowCycleUnit(String borrowCycleUnit) {
		this.borrowCycleUnit = borrowCycleUnit;
	}

	public String getBorrowShopName() {
		return this.borrowShopName;
	}
	public void setBorrowShopName(String borrowShopName) {
		this.borrowShopName = borrowShopName;
	}

	public String getBorrowTime() {
		return this.borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public String getCertNo() {
		return this.certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCreditBiz() {
		return this.creditBiz;
	}
	public void setCreditBiz(String creditBiz) {
		this.creditBiz = creditBiz;
	}

	public String getDepositAmount() {
		return this.depositAmount;
	}
	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getDepositState() {
		return this.depositState;
	}
	public void setDepositState(String depositState) {
		this.depositState = depositState;
	}

	public String getExpiryTime() {
		return this.expiryTime;
	}
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getGoodsName() {
		return this.goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getInvokeReturnUrl() {
		return this.invokeReturnUrl;
	}
	public void setInvokeReturnUrl(String invokeReturnUrl) {
		this.invokeReturnUrl = invokeReturnUrl;
	}

	public String getInvokeState() {
		return this.invokeState;
	}
	public void setInvokeState(String invokeState) {
		this.invokeState = invokeState;
	}

	public String getInvokeType() {
		return this.invokeType;
	}
	public void setInvokeType(String invokeType) {
		this.invokeType = invokeType;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNotifyUrl() {
		return this.notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getRentAmount() {
		return this.rentAmount;
	}
	public void setRentAmount(String rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getRentInfo() {
		return this.rentInfo;
	}
	public void setRentInfo(String rentInfo) {
		this.rentInfo = rentInfo;
	}

	public String getRentSettleType() {
		return this.rentSettleType;
	}
	public void setRentSettleType(String rentSettleType) {
		this.rentSettleType = rentSettleType;
	}

	public String getRentUnit() {
		return this.rentUnit;
	}
	public void setRentUnit(String rentUnit) {
		this.rentUnit = rentUnit;
	}

}
