package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 初始化认证信息
 *
 * @author auto create
 * @since 1.0, 2017-11-23 13:49:17
 */
public class AlipayUserCertifyActionApplyModel extends AlipayObject {

	private static final long serialVersionUID = 7193374341792574498L;

	/**
	 * 表示申请认证信息的业务类型
	 */
	@ApiField("biz_type")
	private String bizType;

	/**
	 * 商户和支付宝交互时，用于代表申请认证信息的商户ID
	 */
	@ApiField("partner_id")
	private String partnerId;

	public String getBizType() {
		return this.bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

}
