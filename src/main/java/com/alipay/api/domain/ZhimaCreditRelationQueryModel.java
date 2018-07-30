package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ZhimaCreditRelationQueryModel extends AlipayObject {

	private static final long serialVersionUID = 8355267729922595112L;


	@ApiField("cert_no")
	private String certNo;

	@ApiField("linked_merchant_id")
	private String linkedMerchantId;

	@ApiField("name")
	private String name;

	@ApiField("product_code")
	private String productCode;

	@ApiField("relation")
	private String relation;

	@ApiField("relation_name")
	private String relationName;

	@ApiField("relation_phone")
	private String relationPhone;

	@ApiField("transaction_id")
	private String transactionId;

	public String getCertNo() {
		return this.certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getLinkedMerchantId() {
		return this.linkedMerchantId;
	}
	public void setLinkedMerchantId(String linkedMerchantId) {
		this.linkedMerchantId = linkedMerchantId;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getRelation() {
		return this.relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRelationName() {
		return this.relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationPhone() {
		return this.relationPhone;
	}
	public void setRelationPhone(String relationPhone) {
		this.relationPhone = relationPhone;
	}

	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
