package cc.openkit.kitPay.weichart.model;

/**
 * 微信退款实体对象
 */
public class WeichartRefundModel {
    // 字段名  是否必填  类型  示例值  描述
    // 随机字符串	  是  	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
    private String nonceStr;
    // 签名	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名
    private String sign;
    // 签名类型	否	String(32)	HMAC-SHA256	签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
    private String signType;

    // 下面的两个参数 二选一
    //微信订单号	String(32)	1217752501201407033233368018	微信生成的订单号，在支付通知中有返回
    //商户订单号 	String(32)	1217752501201407033233368018	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
    private String transactionId;
    private String outTradeNo;

    // 商户退款单号	是	String(64)	1217752501201407033233368018	商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
    private String outRefundNo;
    // 订单金额	是	Int	100	订单总金额，单位为分，只能为整数，详见支付金额
    private String totalFee;
    // 退款金额	是	Int	100	退款总金额，订单总金额，单位为分，只能为整数，详见支付金额
    private String refundFee;
    // 退款货币种类	否	String(8)	CNY	退款货币类型，需与支付一致，或者不填。符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private String refundFeeType;
    // 退款原因		否	String(80)	商品已售完	若商户传入，会在下发给用户的退款消息中体现退款原因
    private String refundDesc;
    // 退款资金来源	否	String(30)	REFUND_SOURCE_RECHARGE_FUNDS
    //仅针对老资金流商户使用
    //REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
    //REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
    private String refundAccount;
    // 退款结果通知url	否	String(256)	https://weixin.qq.com/notify/
    // 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数
    // 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
    private String notifyUrl;

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
