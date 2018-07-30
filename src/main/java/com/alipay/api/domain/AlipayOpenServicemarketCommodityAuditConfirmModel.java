package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 提交审核确认
 *
 * @author auto create
 * @since 1.0, 2018-01-15 11:06:34
 */
public class AlipayOpenServicemarketCommodityAuditConfirmModel extends AlipayObject {

	private static final long serialVersionUID = 3553194687922552658L;

	/**
	 * 服务插件ID
	 */
	@ApiField("commodity_id")
	private String commodityId;

	/**
	 * 用户ID
	 */
	@ApiField("user_id")
	private String userId;

	public String getCommodityId() {
		return this.commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
