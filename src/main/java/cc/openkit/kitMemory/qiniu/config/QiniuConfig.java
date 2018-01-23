package cc.openkit.kitMemory.qiniu.config;

/**
 * 七牛云配置
 */
public class QiniuConfig {
    private String accessKey ;
    private String secretKey ;

    public QiniuConfig(){

    }

    public QiniuConfig(String accessKey,String secretKey){
        this.accessKey=accessKey;
        this.secretKey=secretKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
