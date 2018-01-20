package cc.openkit.kitPay.alipay.model;

public class AlipayToIndividual {

    private String outBizNo; // 商户编号
    private String payeeAccount;  // 支付宝账号
    private String amount; // 金额
    private String payeeRealName;// 用户名
    private String payerShowName;// 对方账户
    private String remark;// 转账理由
    private String payeeType;// 支付方式

    /**
     * 默认了 支付方式
     */
    public AlipayToIndividual(String outBizNo, String payeeAccount,String amount,String payeeRealName,String payerShowName,String remark) {

        this.outBizNo = outBizNo;
        this.payeeAccount = payeeAccount;
        this.amount = amount;
        this.payeeRealName = payeeRealName;
        this.payerShowName = payerShowName;
        this.remark = remark;
        this.payeeType = "ALIPAY_LOGONID";

    }


    public AlipayToIndividual(String outBizNo, String payeeAccount,String amount,String payeeRealName,String payerShowName,String remark,String payeeType) {

        this.outBizNo = outBizNo;
        this.payeeAccount = payeeAccount;
        this.amount = amount;
        this.payeeRealName = payeeRealName;
        this.payerShowName = payerShowName;
        this.remark = remark;
        this.payeeType = payeeType;

    }

    public AlipayToIndividual(){}



    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayeeRealName() {
        return payeeRealName;
    }

    public void setPayeeRealName(String payeeRealName) {
        this.payeeRealName = payeeRealName;
    }

    public String getPayerShowName() {
        return payerShowName;
    }

    public void setPayerShowName(String payerShowName) {
        this.payerShowName = payerShowName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(String payeeType) {
        this.payeeType = payeeType;
    }
}
