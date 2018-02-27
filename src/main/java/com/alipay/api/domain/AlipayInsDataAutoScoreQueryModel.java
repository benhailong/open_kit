package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayInsDataAutoScoreQueryModel extends AlipayObject {

	private static final long serialVersionUID = 2839358725167693582L;


	@ApiField("area_id")
	private String areaId;

	@ApiField("biz_no")
	private String bizNo;

	@ApiField("biz_type")
	private String bizType;


	@ApiField("car_frame_no")
	private String carFrameNo;

	@ApiField("car_no")
	private String carNo;

	@ApiField("cert_name")
	private String certName;

	@ApiField("cert_no")
	private String certNo;

	@ApiField("cert_type")
	private String certType;

	@ApiField("ext_info")
	private String extInfo;

	@ApiField("role_type")
	private String roleType;

	@ApiField("score_type")
	private String scoreType;

	@ApiField("uuid")
	private String uuid;

	public String getAreaId() {
		return this.areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getBizNo() {
		return this.bizNo;
	}
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getCarFrameNo() {
		return this.carFrameNo;
	}
	public void setCarFrameNo(String carFrameNo) {
		this.carFrameNo = carFrameNo;
	}

	public String getCarNo() {
		return this.carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCertName() {
		return this.certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
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

	public String getExtInfo() {
		return this.extInfo;
	}
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

	public String getRoleType() {
		return this.roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getScoreType() {
		return this.scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getUuid() {
		return this.uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
