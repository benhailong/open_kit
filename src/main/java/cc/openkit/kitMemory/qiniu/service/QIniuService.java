package cc.openkit.kitMemory.qiniu.service;

import cc.openkit.common.KitUtil;
import cc.openkit.kitIsNull.KitVerification;
import cc.openkit.kitMemory.qiniu.config.QiniuConfig;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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
    public static String reviseCoucher(QiniuConfig qiniuConfig) throws Exception{
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucket();
        String key = qiniuConfig.getKey();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        System.out.println(upToken);
        return upToken;
    }

    /**
     * 根据文件路径上传文件
     * @param qiniuConfig 七牛云基础配置  默认不指定key的情况下，以文件内容的hash值作为文件名
     * @param localFilePath 文件路径
     * @param zoneAdd 空间对应参数
     * @return map
     */
   public static Map<String,Object> uploadByFilePath(QiniuConfig qiniuConfig, String localFilePath, String zoneAdd){
       Map<String,Object> map = new HashMap<String,Object>();
       //构造一个带指定Zone对象的配置类
       Zone zone = getZone(zoneAdd);
       Configuration cfg = new Configuration(zone);
        //...其他参数参考类注释

       UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
       String accessKey = qiniuConfig.getAccessKey();
       String secretKey = qiniuConfig.getSecretKey();
       String bucket = qiniuConfig.getBucket();

       Auth auth = Auth.create(accessKey, secretKey);
       String upToken = auth.uploadToken(bucket);

       try {
           Response response = uploadManager.put(localFilePath, qiniuConfig.getKey(), upToken);
           //解析上传成功的结果
           DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
           map = KitUtil.returnMap("200","");
           map.put("putRet",putRet);
       } catch (QiniuException ex) {
           System.out.println("上传失败了，出现异常了");
           Response r = ex.response;
           System.err.println(r.toString());
           map = KitUtil.returnMap("101","上传失败");
           // 遇到异常 这里处理
           try {
               System.err.println(r.bodyString());
           } catch (QiniuException ex2) {
               //ignore
           }
       }
       return map;
   }

    private static Zone getZone(String zoneAdd) {
        Zone zone = new Zone();
        if("zone0".equals(zoneAdd)){
            zone = Zone.zone0();
        }
        if("zone1".equals(zoneAdd)){
            zone = Zone.zone1();
        }
        if("zone2".equals(zoneAdd)){
            zone = Zone.zone2();
        }
        if("zoneNa0".equals(zoneAdd)){
            zone = Zone.zoneNa0();
        }
        return zone;
    }

    /**
     * 字节数组上传
     * 可以支持将内存中的字节数组上传到空间中。
     * @param qiniuConfig
     * @param bytes 字节
     * @param charsetName 格式，默认UTF-8
     * @param zoneAdd 空间对应参数
     * @return map
     */
    public static Map<String,Object> uploadByByteArray(QiniuConfig qiniuConfig, String bytes, String charsetName, String zoneAdd){
        Map<String,Object> map = new HashMap<String,Object>();
        //构造一个带指定Zone对象的配置类
        Zone zone = getZone(zoneAdd);
        Configuration cfg = new Configuration(zone);
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucket();

        try {
            byte[] uploadBytes = bytes.getBytes(charsetName);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(uploadBytes, qiniuConfig.getKey(), upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                map = KitUtil.returnMap("200","");
                map.put("putRet",putRet);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                map = KitUtil.returnMap("101","上传失败");
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
            map = KitUtil.returnMap("101","上传失败");
        }
        return map;
    }


    /**
     * 数据流上传
     * @param qiniuConfig
     * @param bytes 数据流
     * @param charsetName 数据格式，比如
     * @param zoneAdd 空间对应参数
     * @return map
     */
    public static Map<String,Object> uploadByFileRecorder(QiniuConfig qiniuConfig, String bytes, String charsetName, String zoneAdd){
        Map<String,Object> map = new HashMap<String,Object>();
        //构造一个带指定Zone对象的配置类
        Zone zone = getZone(zoneAdd);
        Configuration cfg = new Configuration(zone);
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucket();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            byte[] uploadBytes = bytes.getBytes(charsetName);
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream,qiniuConfig.getKey(),upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                map = KitUtil.returnMap("200","");
                map.put("putRet",putRet);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                map = KitUtil.returnMap("101","上传失败");
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
            map = KitUtil.returnMap("101","上传失败");
        }
        return map;
    }

    /**
     * 断点续传
     * @param qiniuConfig 配置文件
     * @param localFilePath 文件路径  如果是Windows情况下，格式是 D:\\qiniu\\test.png
     * @param zoneAdd 空间对应参数
     * @return map
     */
    public static Map<String,Object> uploadByBreakingPoint(QiniuConfig qiniuConfig, String localFilePath, String zoneAdd){
        Map<String,Object> map = new HashMap<String,Object>();
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        //...生成上传凭证，然后准备上传
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucket();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), bucket).toString();
        try {
            //设置断点续传文件进度保存目录
            FileRecorder fileRecorder = new FileRecorder(localTempDir);
            UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
            try {
                Response response = uploadManager.put(localFilePath, qiniuConfig.getKey(), upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                map = KitUtil.returnMap("200","");
                map.put("putRet",putRet);

                System.out.println("上传成功了，key值："+putRet.key);
                System.out.println("上传成功了，hash值："+putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                map = KitUtil.returnMap("101","上传失败");
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            map = KitUtil.returnMap("101","上传失败");
        }

        return map;
    }




}
