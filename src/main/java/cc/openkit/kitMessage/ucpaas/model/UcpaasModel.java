package cc.openkit.kitMessage.ucpaas.model;



/**
 * 云之讯
 * 验证码短信模板
 */
public class UcpaasModel {
    private String accountSid;
    private String authToken;
    private String templateId;
    private String appId;
    private String phone;
    private String code;

    public UcpaasModel(){

    }

    public UcpaasModel(String accountSid, String authToken, String templateId, String appId, String phone, String code){
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.templateId = templateId;
        this.appId = appId;
        this.phone = phone;
        this.code = code;
    }

    public String getAccountSid() {
        return accountSid;
    }
    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setTemplateId(String templateId) {

        this.templateId = templateId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
