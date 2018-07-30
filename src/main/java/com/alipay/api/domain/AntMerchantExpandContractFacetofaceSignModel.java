package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AntMerchantExpandContractFacetofaceSignModel extends AlipayObject {

	private static final long serialVersionUID = 2363768324925366324L;

	@ApiField("business_license_auth_pic")
	private String businessLicenseAuthPic;

	@ApiField("business_license_no")
	private String businessLicenseNo;

	@ApiField("business_license_pic")
	private String businessLicensePic;

	@ApiField("contact_email")
	private String contactEmail;

	@ApiField("contact_mobile")
	private String contactMobile;

	@ApiField("contact_name")
	private String contactName;

	@ApiField("mcc_code")
	private String mccCode;

	@ApiField("out_biz_no")
	private String outBizNo;

	@ApiField("shop_scene_pic")
	private String shopScenePic;

	@ApiField("shop_sign_board_pic")
	private String shopSignBoardPic;

	@ApiField("special_license_pic")
	private String specialLicensePic;

	public String getBusinessLicenseAuthPic() {
		return this.businessLicenseAuthPic;
	}
	public void setBusinessLicenseAuthPic(String businessLicenseAuthPic) {
		this.businessLicenseAuthPic = businessLicenseAuthPic;
	}

	public String getBusinessLicenseNo() {
		return this.businessLicenseNo;
	}
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}

	public String getBusinessLicensePic() {
		return this.businessLicensePic;
	}
	public void setBusinessLicensePic(String businessLicensePic) {
		this.businessLicensePic = businessLicensePic;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMccCode() {
		return this.mccCode;
	}
	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getShopScenePic() {
		return this.shopScenePic;
	}
	public void setShopScenePic(String shopScenePic) {
		this.shopScenePic = shopScenePic;
	}

	public String getShopSignBoardPic() {
		return this.shopSignBoardPic;
	}
	public void setShopSignBoardPic(String shopSignBoardPic) {
		this.shopSignBoardPic = shopSignBoardPic;
	}

	public String getSpecialLicensePic() {
		return this.specialLicensePic;
	}
	public void setSpecialLicensePic(String specialLicensePic) {
		this.specialLicensePic = specialLicensePic;
	}

}
