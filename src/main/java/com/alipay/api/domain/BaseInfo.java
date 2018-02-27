package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class BaseInfo extends AlipayObject {

	private static final long serialVersionUID = 4275538593897634943L;

	@ApiField("alipay_fuwu_name")
	private String alipayFuwuName;


	@ApiField("app_name")
	private String appName;

	@ApiListField("contact_info")
	@ApiField("contact_person_info")
	private List<ContactPersonInfo> contactInfo;

	@ApiField("logo_pic")
	private String logoPic;

	@ApiField("mcc_code")
	private String mccCode;

	@ApiField("short_name")
	private String shortName;

	@ApiListField("special_license_pic")
	@ApiField("string")
	private List<String> specialLicensePic;

	@ApiField("usage_scenario")
	private String usageScenario;


	@ApiListField("web_address")
	@ApiField("string")
	private List<String> webAddress;

	@ApiField("web_auth_pic")
	private String webAuthPic;

	@ApiField("weixin_public_name")
	private String weixinPublicName;

	public String getAlipayFuwuName() {
		return this.alipayFuwuName;
	}
	public void setAlipayFuwuName(String alipayFuwuName) {
		this.alipayFuwuName = alipayFuwuName;
	}

	public String getAppName() {
		return this.appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}

	public List<ContactPersonInfo> getContactInfo() {
		return this.contactInfo;
	}
	public void setContactInfo(List<ContactPersonInfo> contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getLogoPic() {
		return this.logoPic;
	}
	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public String getMccCode() {
		return this.mccCode;
	}
	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}

	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<String> getSpecialLicensePic() {
		return this.specialLicensePic;
	}
	public void setSpecialLicensePic(List<String> specialLicensePic) {
		this.specialLicensePic = specialLicensePic;
	}

	public String getUsageScenario() {
		return this.usageScenario;
	}
	public void setUsageScenario(String usageScenario) {
		this.usageScenario = usageScenario;
	}

	public List<String> getWebAddress() {
		return this.webAddress;
	}
	public void setWebAddress(List<String> webAddress) {
		this.webAddress = webAddress;
	}

	public String getWebAuthPic() {
		return this.webAuthPic;
	}
	public void setWebAuthPic(String webAuthPic) {
		this.webAuthPic = webAuthPic;
	}

	public String getWeixinPublicName() {
		return this.weixinPublicName;
	}
	public void setWeixinPublicName(String weixinPublicName) {
		this.weixinPublicName = weixinPublicName;
	}

}
