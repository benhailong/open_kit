package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 人脸验证
 *
 * @author auto create
 * @since 1.0, 2018-01-11 11:56:01
 */
public class ZolozAuthenticationCustomerFaceverifyMatchModel extends AlipayObject {

	private static final long serialVersionUID = 8537194774858338692L;

	/**
	 * 活体照片的二进制内容，然后做base64编码
	 */
	@ApiField("auth_img")
	private String authImg;

	/**
	 * C0：手机端采集的人脸图片
C1：机具端采集的人脸图片
	 */
	@ApiField("auth_img_channel")
	private String authImgChannel;

	/**
	 * 商户请求的唯一标志，该标识作为对账的关键信息，商户要保证其唯一性
	 */
	@ApiField("biz_id")
	private String bizId;

	/**
	 * 业务方使用的账户唯一标示
	 */
	@ApiField("merchant_uid")
	private String merchantUid;

	/**
	 * 比对源照片的二进制内容，然后做base64编码
	 */
	@ApiField("ref_img")
	private String refImg;

	public String getAuthImg() {
		return this.authImg;
	}
	public void setAuthImg(String authImg) {
		this.authImg = authImg;
	}

	public String getAuthImgChannel() {
		return this.authImgChannel;
	}
	public void setAuthImgChannel(String authImgChannel) {
		this.authImgChannel = authImgChannel;
	}

	public String getBizId() {
		return this.bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getMerchantUid() {
		return this.merchantUid;
	}
	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getRefImg() {
		return this.refImg;
	}
	public void setRefImg(String refImg) {
		this.refImg = refImg;
	}

}
