package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class KoubeiServindustryPortfolioDataModifyModel extends AlipayObject {

	private static final long serialVersionUID = 6277985475875917345L;

	@ApiField("cover_media_id")
	private String coverMediaId;

	@ApiField("cover_media_type")
	private String coverMediaType;

	@ApiField("portfolio_id")
	private String portfolioId;

	@ApiField("portfolio_operator_info")
	private PortfolioOperatorInfo portfolioOperatorInfo;

	@ApiListField("portfolio_shops")
	@ApiField("portfolio_shop")
	private List<PortfolioShop> portfolioShops;

	@ApiField("title")
	private String title;

	public String getCoverMediaId() {
		return this.coverMediaId;
	}
	public void setCoverMediaId(String coverMediaId) {
		this.coverMediaId = coverMediaId;
	}

	public String getCoverMediaType() {
		return this.coverMediaType;
	}
	public void setCoverMediaType(String coverMediaType) {
		this.coverMediaType = coverMediaType;
	}

	public String getPortfolioId() {
		return this.portfolioId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	public PortfolioOperatorInfo getPortfolioOperatorInfo() {
		return this.portfolioOperatorInfo;
	}
	public void setPortfolioOperatorInfo(PortfolioOperatorInfo portfolioOperatorInfo) {
		this.portfolioOperatorInfo = portfolioOperatorInfo;
	}

	public List<PortfolioShop> getPortfolioShops() {
		return this.portfolioShops;
	}
	public void setPortfolioShops(List<PortfolioShop> portfolioShops) {
		this.portfolioShops = portfolioShops;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
