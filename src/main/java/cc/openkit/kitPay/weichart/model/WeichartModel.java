package cc.openkit.kitPay.weichart.model;

public class WeichartModel {
    /**
     * 微信开发平台应用ID
     */
    private String appId;
    /**
     * 应用对应的凭证
     */
    private String appSecret;
    /**
     * 应用对应的密钥
     */
    private String appKey;
    /**
     * 微信支付商户号
     */
    private String mchId;
    /**
     * 商品描述
     */
    private String body;
    /**
     * 商户号对应的密钥
     */
    private String partnerKey;

    /**
     * 商户id
     */
    private String partnerId;
    /**
     * 常量固定值
     */
    private String grantType;
    /**
     * 获取预支付id的接口url
     */
    private String gateUrl;
    /**
     * 微信服务器回调通知url
     */
    private String notifyUrl;
    /**
     * 请求的 IP 地址，其实就是服务器的IP地址
     */
    private String spbillCreateIp;


    public WeichartModel(){}
    public WeichartModel(String appId,
                         String appSecret,
                         String appKey,
                         String mchId,
                         String body,
                         String partnerKey,
                         String partnerId,
                         String grantType,
                         String gateUrl,
                         String notifyUrl,
                         String spbillCreateIp){
        this.appId=appId;
        this.appSecret=appSecret;
        this.appKey=appKey;
        this.mchId=mchId;
        this.body=body;
        this.partnerKey=partnerKey;
        this.partnerId=partnerId;
        this.grantType=grantType;
        this.gateUrl=gateUrl;
        this.notifyUrl=notifyUrl;
        this.spbillCreateIp=spbillCreateIp;

    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getGateUrl() {
        return gateUrl;
    }

    public void setGateUrl(String gateUrl) {
        this.gateUrl = gateUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
}
