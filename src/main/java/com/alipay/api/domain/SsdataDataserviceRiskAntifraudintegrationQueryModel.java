package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class SsdataDataserviceRiskAntifraudintegrationQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4629432412878865716L;


	@ApiField("address")
	private String address;

	@ApiField("bank_card")
	private String bankCard;


	@ApiField("cert_no")
	private String certNo;

	@ApiField("cert_type")
	private String certType;

	@ApiField("email")
	private String email;

	@ApiField("imei")
	private String imei;

	@ApiField("ip")
	private String ip;

	@ApiField("mac")
	private String mac;

	@ApiField("mobile")
	private String mobile;

	@ApiField("name")
	private String name;

	@ApiField("partner_id")
	private String partnerId;

	@ApiField("wifimac")
	private String wifimac;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankCard() {
		return this.bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getCertNo() {
		return this.certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertType() {
		return this.certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getImei() {
		return this.imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return this.mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getWifimac() {
		return this.wifimac;
	}
	public void setWifimac(String wifimac) {
		this.wifimac = wifimac;
	}

}
