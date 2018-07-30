package cc.openkit.kitPay.alipay.model;

public class Alipay {

    private String body;     //  商品描述
    private String subject;  //  商品名称
    private String outTradeNo;  //  商户订单号  可以使用  StringUtils.getOutTradeNo()
    private String timeoutExpress; // 有效时间；正常设置  30m 30分钟
    private String totalAmount; // 价格
    private String productCode;  //  支付方式  QUICK_MSECURITY_PAY   即时到账
    private String notifyUrl;  //  回调地址

    public Alipay() {}

    /**
     * 默认了时间和支付方式
     * @param body
     * @param subject
     * @param outTradeNo
     * @param totalAmount
     * @param notifyUrl
     */
    public Alipay(String body, String subject,String outTradeNo,String totalAmount,String notifyUrl) {

        this.body = body;
        this.subject = subject;
        this.outTradeNo = outTradeNo;
        this.timeoutExpress = "30m";
        this.totalAmount = totalAmount;
        this.productCode = "QUICK_MSECURITY_PAY";
        this.notifyUrl = notifyUrl;

    }

    /**
     * 默认了支付方式
     * @param body
     * @param subject
     * @param outTradeNo
     * @param timeoutExpress
     * @param totalAmount
     * @param notifyUrl
     */
    public Alipay(String body, String subject,String outTradeNo,String timeoutExpress,String totalAmount,String notifyUrl) {

        this.body = body;
        this.subject = subject;
        this.outTradeNo = outTradeNo;
        this.timeoutExpress = timeoutExpress;
        this.totalAmount = totalAmount;
        this.productCode = "QUICK_MSECURITY_PAY";
        this.notifyUrl = notifyUrl;

    }

    /**
     * 全部自定义
     * @param body
     * @param subject
     * @param outTradeNo
     * @param timeoutExpress
     * @param totalAmount
     * @param productCode
     * @param notifyUrl
     */
    public Alipay(String body, String subject,String outTradeNo,String timeoutExpress,String totalAmount,String productCode,String notifyUrl) {

        this.body = body;
        this.subject = subject;
        this.outTradeNo = outTradeNo;
        this.timeoutExpress = timeoutExpress;
        this.totalAmount = totalAmount;
        this.productCode = productCode;
        this.notifyUrl = notifyUrl;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
