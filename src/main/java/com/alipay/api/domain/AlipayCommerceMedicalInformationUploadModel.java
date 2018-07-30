package com.alipay.api.domain;

import java.util.Date;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceMedicalInformationUploadModel extends AlipayObject {

	private static final long serialVersionUID = 7324795414124618948L;


	@ApiField("auth_code")
	private String authCode;


	@ApiField("auth_type")
	private String authType;

	@ApiField("body")
	private String body;

	@ApiField("buyer_id")
	private String buyerId;

	@ApiField("extend_params")
	private String extendParams;

	@ApiField("gmt_out_create")
	private Date gmtOutCreate;

	@ApiField("industry")
	private String industry;

	@ApiField("is_insurance")
	private String isInsurance;

	@ApiField("medical_card_inst_id")
	private String medicalCardInstId;

	@ApiField("org_name")
	private String orgName;

	@ApiField("org_no")
	private String orgNo;

	@ApiField("out_trade_no")
	private String outTradeNo;

	@ApiField("patient_card_no")
	private String patientCardNo;

	@ApiField("patient_card_type")
	private String patientCardType;

	@ApiField("patient_mobile")
	private String patientMobile;

	@ApiField("patient_name")
	private String patientName;

	@ApiField("request_content")
	private String requestContent;

	@ApiField("scene")
	private String scene;

	@ApiField("seller_id")
	private String sellerId;

	@ApiField("serial_no")
	private String serialNo;

	@ApiField("subject")
	private String subject;

	@ApiField("total_amount")
	private String totalAmount;

	public String getAuthCode() {
		return this.authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthType() {
		return this.authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getBuyerId() {
		return this.buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getExtendParams() {
		return this.extendParams;
	}
	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

	public Date getGmtOutCreate() {
		return this.gmtOutCreate;
	}
	public void setGmtOutCreate(Date gmtOutCreate) {
		this.gmtOutCreate = gmtOutCreate;
	}

	public String getIndustry() {
		return this.industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIsInsurance() {
		return this.isInsurance;
	}
	public void setIsInsurance(String isInsurance) {
		this.isInsurance = isInsurance;
	}

	public String getMedicalCardInstId() {
		return this.medicalCardInstId;
	}
	public void setMedicalCardInstId(String medicalCardInstId) {
		this.medicalCardInstId = medicalCardInstId;
	}

	public String getOrgName() {
		return this.orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgNo() {
		return this.orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getPatientCardNo() {
		return this.patientCardNo;
	}
	public void setPatientCardNo(String patientCardNo) {
		this.patientCardNo = patientCardNo;
	}

	public String getPatientCardType() {
		return this.patientCardType;
	}
	public void setPatientCardType(String patientCardType) {
		this.patientCardType = patientCardType;
	}

	public String getPatientMobile() {
		return this.patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getPatientName() {
		return this.patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRequestContent() {
		return this.requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getScene() {
		return this.scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getSellerId() {
		return this.sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSerialNo() {
		return this.serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

}
