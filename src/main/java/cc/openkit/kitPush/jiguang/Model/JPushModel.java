package cc.openkit.kitPush.jiguang.Model;

public class JPushModel {
    private String appkey;  // 极光推动的 appkey
    private String mastersecret; // 极光推动的 mastersecret
    private int type; // 极光推动的 状态
    private String con; // 极光推动的 内容
    private String userid; // 极光推动的 推送的用户

    public JPushModel(){

    }

    public JPushModel(String appkey,String mastersecret,int type,String con){
        this.appkey = appkey;
        this.mastersecret = mastersecret;
        this.type = type;
        this.con = con;
        this.userid = "";
    }

    public JPushModel(String appkey,String mastersecret,int type,String con,String userid){
        this.appkey = appkey;
        this.mastersecret = mastersecret;
        this.type = type;
        this.con = con;
        this.userid = userid;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
