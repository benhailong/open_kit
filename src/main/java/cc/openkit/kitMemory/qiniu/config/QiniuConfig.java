package cc.openkit.kitMemory.qiniu.config;

/**
 * 七牛云配置
 */
public class QiniuConfig {
    private String accessKey ;
    private String secretKey ;
    private String bucket ;
    // 需要替换的文件名字（可传）
    private String key;

    public QiniuConfig(){

    }

    public QiniuConfig(String accessKey,String secretKey,String bucket){
        this.accessKey=accessKey;
        this.secretKey=secretKey;
        this.bucket=bucket;
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

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
