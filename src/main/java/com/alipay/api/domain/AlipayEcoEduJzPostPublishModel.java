package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

public class AlipayEcoEduJzPostPublishModel extends AlipayObject {

	private static final long serialVersionUID = 8425479795782992192L;

	@ApiField("age_demand")
	private EduAgeDemand ageDemand;

	@ApiField("commission")
	private String commission;

	@ApiField("company_contact")
	private String companyContact;

	@ApiField("company_logo")
	private String companyLogo;

	@ApiField("company_name")
	private String companyName;

	@ApiField("contact_phone")
	private String contactPhone;

	@ApiField("date_end")
	private String dateEnd;

	@ApiField("date_start")
	private String dateStart;

	@ApiField("deadline")
	private String deadline;

	@ApiField("gender")
	private String gender;

	@ApiField("hire_number")
	private String hireNumber;

	@ApiField("is_commission")
	private String isCommission;

	@ApiField("job_desc")
	private String jobDesc;

	@ApiField("job_type")
	private String jobType;

	@ApiField("part_time_type")
	private String partTimeType;

	@ApiField("payment")
	private String payment;

	@ApiField("payment_remark")
	private String paymentRemark;

	@ApiField("payment_type")
	private String paymentType;

	@ApiField("salary")
	private String salary;

	@ApiField("salary_unit")
	private String salaryUnit;

	@ApiField("service_post_id")
	private String servicePostId;

	@ApiField("source_info")
	private EduSourceInfo sourceInfo;

	@ApiListField("special_demand")
	@ApiField("string")
	private List<String> specialDemand;

	@ApiField("title")
	private String title;

	@ApiListField("welfare")
	@ApiField("string")
	private List<String> welfare;

	@ApiListField("work_address")
	@ApiField("edu_work_address")
	private List<EduWorkAddress> workAddress;

	@ApiField("work_time_remark")
	private String workTimeRemark;

	@ApiField("working_hours")
	private String workingHours;

	public EduAgeDemand getAgeDemand() {
		return this.ageDemand;
	}
	public void setAgeDemand(EduAgeDemand ageDemand) {
		this.ageDemand = ageDemand;
	}

	public String getCommission() {
		return this.commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getCompanyContact() {
		return this.companyContact;
	}
	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyLogo() {
		return this.companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getCompanyName() {
		return this.companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getDateEnd() {
		return this.dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDateStart() {
		return this.dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDeadline() {
		return this.deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHireNumber() {
		return this.hireNumber;
	}
	public void setHireNumber(String hireNumber) {
		this.hireNumber = hireNumber;
	}

	public String getIsCommission() {
		return this.isCommission;
	}
	public void setIsCommission(String isCommission) {
		this.isCommission = isCommission;
	}

	public String getJobDesc() {
		return this.jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobType() {
		return this.jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getPartTimeType() {
		return this.partTimeType;
	}
	public void setPartTimeType(String partTimeType) {
		this.partTimeType = partTimeType;
	}

	public String getPayment() {
		return this.payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPaymentRemark() {
		return this.paymentRemark;
	}
	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}

	public String getPaymentType() {
		return this.paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getSalary() {
		return this.salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSalaryUnit() {
		return this.salaryUnit;
	}
	public void setSalaryUnit(String salaryUnit) {
		this.salaryUnit = salaryUnit;
	}

	public String getServicePostId() {
		return this.servicePostId;
	}
	public void setServicePostId(String servicePostId) {
		this.servicePostId = servicePostId;
	}

	public EduSourceInfo getSourceInfo() {
		return this.sourceInfo;
	}
	public void setSourceInfo(EduSourceInfo sourceInfo) {
		this.sourceInfo = sourceInfo;
	}

	public List<String> getSpecialDemand() {
		return this.specialDemand;
	}
	public void setSpecialDemand(List<String> specialDemand) {
		this.specialDemand = specialDemand;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getWelfare() {
		return this.welfare;
	}
	public void setWelfare(List<String> welfare) {
		this.welfare = welfare;
	}

	public List<EduWorkAddress> getWorkAddress() {
		return this.workAddress;
	}
	public void setWorkAddress(List<EduWorkAddress> workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkTimeRemark() {
		return this.workTimeRemark;
	}
	public void setWorkTimeRemark(String workTimeRemark) {
		this.workTimeRemark = workTimeRemark;
	}

	public String getWorkingHours() {
		return this.workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

}
