package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOpenPublicMessageContentModifyModel extends AlipayObject {

	private static final long serialVersionUID = 5282718964697325634L;


	@ApiField("benefit")
	private String benefit;

	@ApiField("content")
	private String content;

	@ApiField("content_id")
	private String contentId;

	@ApiField("could_comment")
	private String couldComment;

	@ApiField("cover")
	private String cover;

	@ApiField("ctype")
	private String ctype;

	@ApiField("ext_tags")
	private String extTags;

	@ApiField("login_ids")
	private String loginIds;

	@ApiField("title")
	private String title;

	public String getBenefit() {
		return this.benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getContentId() {
		return this.contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getCouldComment() {
		return this.couldComment;
	}
	public void setCouldComment(String couldComment) {
		this.couldComment = couldComment;
	}

	public String getCover() {
		return this.cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCtype() {
		return this.ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getExtTags() {
		return this.extTags;
	}
	public void setExtTags(String extTags) {
		this.extTags = extTags;
	}

	public String getLoginIds() {
		return this.loginIds;
	}
	public void setLoginIds(String loginIds) {
		this.loginIds = loginIds;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
