package cc.openkit.kitPay.alipay.model;

import java.util.List;

public class AlipayRefundModel {
    // 是否必选     最大长度    描述  示例
    // 特殊可选     64   订单支付时传入的商户订单号,不能和 trade_no同时为空。  20150320010101001
    private String outTradeNo;
    // 特殊可选     64   支付宝交易号，和商户订单号不能同时为空  20150320010101001
    private String tradeNo;
    // 必选	       9	需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数	 200.12
    private String refundAmount;
    // 可选	       8	订单退款币种信息，非外币交易，不能传入退款币种信息       	USD
    private String refundCurrency;
    // 可选	      256	退款的原因说明	                                  正常退款
    private String refundReason;
    // 可选        64	 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。	HZ01RF001
    private String outRequestNo;
    // 可选	       30  	商户的操作员编号     	OP001
    private String operatorId;
    // 可选     	32	商户的门店编号	NJ_S_001
    private String storeId;
    // 可选	    32	商户的终端编号	NJ_T_001
    private String terminalId;
    // GoodsDetail[]
    // 可选		退款包含的商品列表信息，Json格式。
    // 其它说明详见：“商品明细说明”
    private List<GoodsDetail> goodsDetail;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public List<GoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
}
