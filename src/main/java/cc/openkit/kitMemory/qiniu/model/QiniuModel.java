package cc.openkit.kitMemory.qiniu.model;


import com.qiniu.util.Auth;

public class QiniuModel {

    public static void main(String[] args) throws Exception {
        String accessKey = "6Hugjd97SpnBsMSvJZMcNVrfirhdMP6dYapFl0bx";
        String secretKey = "SAUabjqmktwuOiqvUd8KqTq9wpTl1_sZQSlr8ZyJ";
        String bucket = "cjtd";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }
}
