package cc.openkit.kitPay.alipay.config;


/**
 * 配置支付宝的参数
 */

public class AliPayConfig {

    /**
     * APPId
     */
    public String appId;

    /**
     * 密钥
     */
    public String privateKey;
    /**
     * 公钥
     */
    public String publicKey;
    /**
     * 支付宝开放安全地址
     */
    public String serverUrl;
    /**
     * 支付宝返回回调地址前缀
     */
    public String doMain;
    /**
     * 设置字符集编码
     */
    public String charset;
    /**
     * 仅支持JSON
     */
    public String format;
    /**
     * 设置符号类型
     */
    public String signType;

    public AliPayConfig(){}
    public AliPayConfig(String appId,
                        String privateKey,
                        String publicKey,
                        String serverUrl,
                        String doMain,
                        String charset,
                        String format,
                        String signType){
        this.appId = appId;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.serverUrl = serverUrl;
        this.doMain = doMain;
        this.charset = charset;
        this.format = format;
        this.signType = signType;

    }



    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getDoMain() {
        return doMain;
    }

    public void setDoMain(String doMain) {
        this.doMain = doMain;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
