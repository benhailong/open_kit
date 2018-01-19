package cc.openkit.kitMessage.alidayu.model;

public class AliDayuModel {
    private String accessKeyId;
    private String accessKeySecret;
    //必填:待发送手机号
    private String phone;
    //必填:短信签名-可在短信控制台中找到
    private String signName;
    //必填:短信模板-可在短信控制台中找到
    private String templateCode;
    //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为 {"name":"Tom", "code":"123"}
    private String templateParam;
    //选填-上行短信扩展码(无特殊需求用户请忽略此字段)(90997)
    private String smsUpExtendCode;
    //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者 ("yourOutId")
    private String outId;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getSmsUpExtendCode() {
        return smsUpExtendCode;
    }

    public void setSmsUpExtendCode(String smsUpExtendCode) {
        this.smsUpExtendCode = smsUpExtendCode;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }
}
