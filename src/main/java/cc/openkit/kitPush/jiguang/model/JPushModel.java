package cc.openkit.kitPush.jiguang.model;

import java.security.PrivateKey;
import java.util.Map;

/**
 * 极光推送实体类
 */
public class JPushModel {
    private String appkey;  // 极光推动的 appkey
    private String mastersecret; // 极光推动的 mastersecret
    private String con; // 极光推动的 内容
    private String[] userid; // 极光推动的 推送的用户
    private Map<String, String> extras; // 推送的附加参数的map集合
    private String sound; // 声音  默认是 happy


    public JPushModel(){

    }

    public JPushModel(String appkey,String mastersecret,String con){
        this.appkey = appkey;
        this.mastersecret = mastersecret;
        this.con = con;
        this.sound = "happy";
    }

    public JPushModel(String appkey,String mastersecret,String con,String[] userid){
        this.appkey = appkey;
        this.mastersecret = mastersecret;
        this.con = con;
        this.userid = userid;
        this.sound = "happy";
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getMastersecret() {
        return mastersecret;
    }

    public void setMastersecret(String mastersecret) {
        this.mastersecret = mastersecret;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String[] getUserid() {
        return userid;
    }

    public void setUserid(String[] userid) {
        this.userid = userid;
    }

    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }


    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
