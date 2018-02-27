package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayPassTemplateUpdateModel extends AlipayObject {

	private static final long serialVersionUID = 7419394978153474211L;

	@ApiField("tpl_content")
	private String tplContent;


	@ApiField("tpl_id")
	private String tplId;

	public String getTplContent() {
		return this.tplContent;
	}
	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	public String getTplId() {
		return this.tplId;
	}
	public void setTplId(String tplId) {
		this.tplId = tplId;
	}

}
