package cc.openkit.kitMemory.qiniu.service;

import cc.openkit.kitMemory.qiniu.config.QiniuConfig;
import com.qiniu.util.Auth;

public class QIniuService {

    /**
     * 简单的上传凭证
     * @param qiniuConfig
     * @return
     * @throws Exception
     */
    public static String simpleVoucher(QiniuConfig qiniuConfig) throws Exception {
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucket();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    /**
     * 覆盖上传的凭证
     * @param qiniuConfig
     * @return
     * @throws Exception
     */
    public static String reviseCoucher(QiniuConfig qiniuConfig)throws Exception{
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucket();
        String key = qiniuConfig.getKey();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        System.out.println(upToken);
        return upToken;
    }


}
