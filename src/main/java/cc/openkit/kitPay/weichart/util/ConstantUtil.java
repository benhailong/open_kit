package cc.openkit.kitPay.weichart.util;

/**
 * Created by benhailong on 2017/11/1.
 */
public class ConstantUtil {
    /**
     * 微信开发平台应用ID
     */
    public static final String APP_ID="wx92919d8a0efc26b9";
    /**
     * 应用对应的凭证
     */
    public static final String APP_SECRET="7f61f87579af638a66ec19a9dac0030d";
    /**
     * 应用对应的密钥
     */
    public static final String APP_KEY="e10adc3949ba59abbe56e057f20f883e";
    /**
     * 微信支付商户号
     */
    public static final String MCH_ID="1490777982";
    /**
     * 商品描述
     */
    public static final String BODY="书籍";
    /**
     * 商户号对应的密钥
     */
    public static final String PARTNER_key="e10adc3949ba59abbe56e057f20f883e";

    /**
     * 商户id
     */
    public static final String PARTNER_ID="1490777982";
    /**
     * 常量固定值
     */
    public static final String GRANT_TYPE="client_credential";
    /**
     * 获取预支付id的接口url
     */
    public static String GATEURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 微信服务器回调通知url
     */
    public static String NOTIFY_URL="http://www.bairuoheng.cn/app/notify";
    /**
     * 请求的 IP 地址，其实就是服务器的IP地址
     */
    public static String SPBILL_CREATE_IP = "49.77.217.34";
}
