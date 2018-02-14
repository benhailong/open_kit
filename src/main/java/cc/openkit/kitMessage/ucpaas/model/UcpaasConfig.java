package cc.openkit.kitMessage.ucpaas.model;

public class UcpaasConfig {
    private String sid;
    private String token;
    private String appid;


    public UcpaasConfig(){

    }

    public UcpaasConfig(String sid, String token, String appid){
        this.sid = sid;
        this.token = token;
        this.appid = appid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }


}
