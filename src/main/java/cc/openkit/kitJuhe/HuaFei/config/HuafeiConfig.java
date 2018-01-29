package cc.openkit.kitJuhe.HuaFei.config;

public class HuafeiConfig {
    private  String key;//申请的接口Appkey
    private  String openId;//在个人中心查询
    private  String telCheckUrl = "http://op.juhe.cn/ofpay/mobile/telcheck?cardnum=*&phoneno=!&key="+key;
    private  String telQueryUrl="http://op.juhe.cn/ofpay/mobile/telquery?cardnum=*&phoneno=!&key="+key;
    private  String onlineUrl="http://op.juhe.cn/ofpay/mobile/onlineorder?key="+key+"&phoneno=!&cardnum=*&orderid=@&sign=$";
    private  String yueUrl="http://op.juhe.cn/ofpay/mobile/yue?key="+key+"&"+"timestamp=%&sign=$";
    private  String orderstaUrl="http://op.juhe.cn/ofpay/mobile/ordersta?key="+key+"&orderid=!";
    private  String orderListUrl="http://op.juhe.cn/ofpay/mobile/orderlist?key="+key;

    public HuafeiConfig(){

    }

    public HuafeiConfig(String key, String openId){
        this.key = key;
        this.openId = openId;
        this.telCheckUrl = "http://op.juhe.cn/ofpay/mobile/telcheck?cardnum=*&phoneno=!&key="+key;
        this.telQueryUrl="http://op.juhe.cn/ofpay/mobile/telquery?cardnum=*&phoneno=!&key="+key;
        this.onlineUrl="http://op.juhe.cn/ofpay/mobile/onlineorder?key="+key+"&phoneno=!&cardnum=*&orderid=@&sign=$";
        this.yueUrl="http://op.juhe.cn/ofpay/mobile/yue?key="+key+"&"+"timestamp=%&sign=$";
        this.orderstaUrl="http://op.juhe.cn/ofpay/mobile/ordersta?key="+key+"&orderid=!";
        this.orderListUrl="http://op.juhe.cn/ofpay/mobile/orderlist?key="+key;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTelCheckUrl() {
        return telCheckUrl;
    }

    public void setTelCheckUrl(String telCheckUrl) {
        this.telCheckUrl = telCheckUrl;
    }

    public String getTelQueryUrl() {
        return telQueryUrl;
    }

    public void setTelQueryUrl(String telQueryUrl) {
        this.telQueryUrl = telQueryUrl;
    }

    public String getOnlineUrl() {
        return onlineUrl;
    }

    public void setOnlineUrl(String onlineUrl) {
        this.onlineUrl = onlineUrl;
    }

    public String getYueUrl() {
        return yueUrl;
    }

    public void setYueUrl(String yueUrl) {
        this.yueUrl = yueUrl;
    }

    public String getOrderstaUrl() {
        return orderstaUrl;
    }

    public void setOrderstaUrl(String orderstaUrl) {
        this.orderstaUrl = orderstaUrl;
    }

    public String getOrderListUrl() {
        return orderListUrl;
    }

    public void setOrderListUrl(String orderListUrl) {
        this.orderListUrl = orderListUrl;
    }
}
