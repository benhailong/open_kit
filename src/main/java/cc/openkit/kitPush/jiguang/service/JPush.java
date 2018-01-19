package cc.openkit.kitPush.jiguang.service;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cc.openkit.kitPush.jiguang.Model.JPushModel;
import org.apache.log4j.Logger;

/**
 * Created by benhailong on 2017/11/2.
 */
public class JPush {
    private static Logger LOG = Logger.getLogger(JPush.class);

    /**
     * 统一推动
     * @param jPushModel 极光推送对象
     */
    public static void tui(JPushModel jPushModel){

        final String MASTERSECRET = jPushModel.getAppkey();
        final String APPKEY = jPushModel.getMastersecret();

        JPushClient jpushClient = new JPushClient(MASTERSECRET, APPKEY, null, ClientConfig.getInstance());

        PushPayload payload = null;
        PushPayload payload2 = null;
        if(jPushModel.getType()==1){
            try {
                // 推送给所有人
                payload = buildPushObject_all_all_alert(jPushModel.getCon());
                payload2 = buildPushObject_all_all_alert2(jPushModel.getCon());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jPushModel.getType()==2){
            try {
                //  调用推送给一个人
                payload = buildPushObject_all_alias_alert(jPushModel.getCon(), jPushModel.getUserid());
                payload2 = buildPushObject_all_alias_alert2(jPushModel.getCon(), jPushModel.getUserid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jPushModel.getType()==3){
            try {
                // 执法消息
                payload = buildPushObject_all_alias_alert_message(jPushModel.getCon(), jPushModel.getUserid());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            PushResult result = jpushClient.sendPush(payload);
            PushResult result2 = jpushClient.sendPush(payload2);
            LOG.info("Got result - " + result);
            LOG.info("Got result2 - " + result2);
            // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
            jpushClient.close();
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    // 推送给所有人
    public static PushPayload buildPushObject_all_all_alert(String con) {
//        return PushPayload.alertAll(con);
        return PushPayload.messageAll(con);
    }

    // 推送给所有人
    public static PushPayload buildPushObject_all_all_alert2(String con) {
//        return PushPayload.alertAll(con);
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(con)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(con)
                                .addExtra("from", "JPush")
                                .build())
                        .build())


                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
//                .setMessage(Message.content(con))
                .build();
    }

    //  推送给制定用户
    public static PushPayload buildPushObject_all_alias_alert( String con, String userid) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(userid))
//                .setNotification(Notification.alert(con))
                .setMessage(Message.content(con))
                .build();
    }

    //  推送给指定用户
    public static PushPayload buildPushObject_all_alias_alert2( String con, String userid) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(userid))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(con)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(con)
                                .addExtra("from", "JPush")
                                .build())
                        .build())


                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
//                .setMessage(Message.content(con))
                .build();
    }


    /*
     推送自定义消息
      */
    public static PushPayload buildPushObject_all_alias_alert_message( String con, String userid) {

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(userid))
                .setMessage(Message.content(con))
                .build();
    }

    // 测试

    public static void main(String[] args) {

        String a = "{\"msg\":\"9001\",\"money\":\"50\"}";
        String c = "{\"msg\":\"9002\",\"code\":\"50\"}";

        String b = "哈哈测试";


    }
}
