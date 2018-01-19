package cc.openkit.kitChat.rongcloud.model;

/***
 * 融云实体类
 */
public class RongcoludModel {
    private String appkey;
    private String appservice;

    public RongcoludModel(){

    }

    public RongcoludModel(String appkey,String appservice){
        this.appkey = appkey;
        this.appservice = appservice;

    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppservice() {
        return appservice;
    }

    public void setAppservice(String appservice) {
        this.appservice = appservice;
    }
}
