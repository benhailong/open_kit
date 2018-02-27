package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ChargeInstMode extends AlipayObject {

	private static final long serialVersionUID = 5858259977579664169L;


	@ApiField("charge_inst")
	private String chargeInst;


	@ApiField("charge_inst_name")
	private String chargeInstName;


	@ApiField("city")
	private String city;

	@ApiField("province")
	private String province;

	public String getChargeInst() {
		return this.chargeInst;
	}
	public void setChargeInst(String chargeInst) {
		this.chargeInst = chargeInst;
	}

	public String getChargeInstName() {
		return this.chargeInstName;
	}
	public void setChargeInstName(String chargeInstName) {
		this.chargeInstName = chargeInstName;
	}

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

}
