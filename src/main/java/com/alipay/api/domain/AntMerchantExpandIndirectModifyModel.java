package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class AntMerchantExpandIndirectModifyModel extends AlipayObject {

	private static final long serialVersionUID = 5695272596111878499L;

	@ApiListField("address_info")
	@ApiField("address_info")
	private List<AddressInfo> addressInfo;


	@ApiField("alias_name")
	private String aliasName;

	@ApiListField("bankcard_info")
	@ApiField("bank_card_info")
	private List<BankCardInfo> bankcardInfo;

	@ApiField("business_license")
	private String businessLicense;

	@ApiField("business_license_type")
	private String businessLicenseType;

	@ApiField("category_id")
	private String categoryId;

	@ApiListField("contact_info")
	@ApiField("contact_info")
	private List<ContactInfo> contactInfo;

	@ApiField("external_id")
	private String externalId;

	@ApiListField("logon_id")
	@ApiField("string")
	private List<String> logonId;

	@ApiField("memo")
	private String memo;

	@ApiField("name")
	private String name;

	@ApiListField("pay_code_info")
	@ApiField("string")
	private List<String> payCodeInfo;

	@ApiField("service_phone")
	private String servicePhone;

	@ApiField("source")
	private String source;

	@ApiField("sub_merchant_id")
	private String subMerchantId;

	public List<AddressInfo> getAddressInfo() {
		return this.addressInfo;
	}
	public void setAddressInfo(List<AddressInfo> addressInfo) {
		this.addressInfo = addressInfo;
	}

	public String getAliasName() {
		return this.aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public List<BankCardInfo> getBankcardInfo() {
		return this.bankcardInfo;
	}
	public void setBankcardInfo(List<BankCardInfo> bankcardInfo) {
		this.bankcardInfo = bankcardInfo;
	}

	public String getBusinessLicense() {
		return this.businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getBusinessLicenseType() {
		return this.businessLicenseType;
	}
	public void setBusinessLicenseType(String businessLicenseType) {
		this.businessLicenseType = businessLicenseType;
	}

	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<ContactInfo> getContactInfo() {
		return this.contactInfo;
	}
	public void setContactInfo(List<ContactInfo> contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getExternalId() {
		return this.externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public List<String> getLogonId() {
		return this.logonId;
	}
	public void setLogonId(List<String> logonId) {
		this.logonId = logonId;
	}

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPayCodeInfo() {
		return this.payCodeInfo;
	}
	public void setPayCodeInfo(List<String> payCodeInfo) {
		this.payCodeInfo = payCodeInfo;
	}

	public String getServicePhone() {
		return this.servicePhone;
	}
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public String getSource() {
		return this.source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getSubMerchantId() {
		return this.subMerchantId;
	}
	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

}
