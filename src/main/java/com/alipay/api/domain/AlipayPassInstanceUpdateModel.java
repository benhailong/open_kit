package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayPassInstanceUpdateModel extends AlipayObject {

	private static final long serialVersionUID = 4311487881648271588L;

	@ApiField("channel_id")
	private String channelId;


	@ApiField("serial_number")
	private String serialNumber;

	@ApiField("status")
	private String status;

	@ApiField("tpl_params")
	private String tplParams;

	@ApiField("verify_code")
	private String verifyCode;

	@ApiField("verify_type")
	private String verifyType;

	public String getChannelId() {
		return this.channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTplParams() {
		return this.tplParams;
	}
	public void setTplParams(String tplParams) {
		this.tplParams = tplParams;
	}

	public String getVerifyCode() {
		return this.verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getVerifyType() {
		return this.verifyType;
	}
	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

}
