package cc.openkit.kitMessage.ucpaas.model;



/**
 * 云之讯
 * 验证码短信模板
 */
public class UcpaasModel {
    // 指定模板单发、指定模板群发  需要发送的  额外参数
    private String param;  // 参数 多个参数 , 号隔开
    private String mobile;  //  接收的手机号码
    private String uid;  //  推送的唯一id
    private String templateid;  // 短信模板

    // 增加、编辑模板的时候 需要的额外参数
    private String type;
    private String template_name;
    private String autograph;
    private String content;

    // 查询的时候需要的额外参数
    private String page_num;
    private String page_size;


    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPage_num() {
        return page_num;
    }

    public void setPage_num(String page_num) {
        this.page_num = page_num;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }
}
