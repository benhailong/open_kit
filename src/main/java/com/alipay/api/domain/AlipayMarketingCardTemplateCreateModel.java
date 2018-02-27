package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class AlipayMarketingCardTemplateCreateModel extends AlipayObject {

	private static final long serialVersionUID = 4887278942863152636L;

	@ApiField("biz_no_prefix")
	private String bizNoPrefix;

	@ApiField("biz_no_suffix_len")
	private String bizNoSuffixLen;

	@ApiListField("card_action_list")
	@ApiField("template_action_info_d_t_o")
	private List<TemplateActionInfoDTO> cardActionList;

	@ApiListField("card_level_conf")
	@ApiField("template_card_level_conf_d_t_o")
	private List<TemplateCardLevelConfDTO> cardLevelConf;

	@ApiField("card_spec_tag")
	private String cardSpecTag;

	@ApiField("card_type")
	private String cardType;

	@ApiListField("column_info_list")
	@ApiField("template_column_info_d_t_o")
	private List<TemplateColumnInfoDTO> columnInfoList;

	@ApiListField("field_rule_list")
	@ApiField("template_field_rule_d_t_o")
	private List<TemplateFieldRuleDTO> fieldRuleList;

	@ApiField("mdcode_notify_conf")
	private TemplateMdcodeNotifyConfDTO mdcodeNotifyConf;

	@ApiField("open_card_conf")
	private TemplateOpenCardConfDTO openCardConf;

	@ApiListField("pub_channels")
	@ApiField("pub_channel_d_t_o")
	private List<PubChannelDTO> pubChannels;

	@ApiField("request_id")
	private String requestId;

	@ApiListField("service_label_list")
	@ApiField("string")
	private List<String> serviceLabelList;

	@ApiListField("shop_ids")
	@ApiField("string")
	private List<String> shopIds;

	@ApiListField("template_benefit_info")
	@ApiField("template_benefit_info_d_t_o")
	private List<TemplateBenefitInfoDTO> templateBenefitInfo;

	@ApiField("template_style_info")
	private TemplateStyleInfoDTO templateStyleInfo;

	@ApiField("write_off_type")
	private String writeOffType;

	public String getBizNoPrefix() {
		return this.bizNoPrefix;
	}
	public void setBizNoPrefix(String bizNoPrefix) {
		this.bizNoPrefix = bizNoPrefix;
	}

	public String getBizNoSuffixLen() {
		return this.bizNoSuffixLen;
	}
	public void setBizNoSuffixLen(String bizNoSuffixLen) {
		this.bizNoSuffixLen = bizNoSuffixLen;
	}

	public List<TemplateActionInfoDTO> getCardActionList() {
		return this.cardActionList;
	}
	public void setCardActionList(List<TemplateActionInfoDTO> cardActionList) {
		this.cardActionList = cardActionList;
	}

	public List<TemplateCardLevelConfDTO> getCardLevelConf() {
		return this.cardLevelConf;
	}
	public void setCardLevelConf(List<TemplateCardLevelConfDTO> cardLevelConf) {
		this.cardLevelConf = cardLevelConf;
	}

	public String getCardSpecTag() {
		return this.cardSpecTag;
	}
	public void setCardSpecTag(String cardSpecTag) {
		this.cardSpecTag = cardSpecTag;
	}

	public String getCardType() {
		return this.cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public List<TemplateColumnInfoDTO> getColumnInfoList() {
		return this.columnInfoList;
	}
	public void setColumnInfoList(List<TemplateColumnInfoDTO> columnInfoList) {
		this.columnInfoList = columnInfoList;
	}

	public List<TemplateFieldRuleDTO> getFieldRuleList() {
		return this.fieldRuleList;
	}
	public void setFieldRuleList(List<TemplateFieldRuleDTO> fieldRuleList) {
		this.fieldRuleList = fieldRuleList;
	}

	public TemplateMdcodeNotifyConfDTO getMdcodeNotifyConf() {
		return this.mdcodeNotifyConf;
	}
	public void setMdcodeNotifyConf(TemplateMdcodeNotifyConfDTO mdcodeNotifyConf) {
		this.mdcodeNotifyConf = mdcodeNotifyConf;
	}

	public TemplateOpenCardConfDTO getOpenCardConf() {
		return this.openCardConf;
	}
	public void setOpenCardConf(TemplateOpenCardConfDTO openCardConf) {
		this.openCardConf = openCardConf;
	}

	public List<PubChannelDTO> getPubChannels() {
		return this.pubChannels;
	}
	public void setPubChannels(List<PubChannelDTO> pubChannels) {
		this.pubChannels = pubChannels;
	}

	public String getRequestId() {
		return this.requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<String> getServiceLabelList() {
		return this.serviceLabelList;
	}
	public void setServiceLabelList(List<String> serviceLabelList) {
		this.serviceLabelList = serviceLabelList;
	}

	public List<String> getShopIds() {
		return this.shopIds;
	}
	public void setShopIds(List<String> shopIds) {
		this.shopIds = shopIds;
	}

	public List<TemplateBenefitInfoDTO> getTemplateBenefitInfo() {
		return this.templateBenefitInfo;
	}
	public void setTemplateBenefitInfo(List<TemplateBenefitInfoDTO> templateBenefitInfo) {
		this.templateBenefitInfo = templateBenefitInfo;
	}

	public TemplateStyleInfoDTO getTemplateStyleInfo() {
		return this.templateStyleInfo;
	}
	public void setTemplateStyleInfo(TemplateStyleInfoDTO templateStyleInfo) {
		this.templateStyleInfo = templateStyleInfo;
	}

	public String getWriteOffType() {
		return this.writeOffType;
	}
	public void setWriteOffType(String writeOffType) {
		this.writeOffType = writeOffType;
	}

}
