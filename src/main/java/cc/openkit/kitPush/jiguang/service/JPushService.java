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
import cc.openkit.kitPush.jiguang.model.JPushModel;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by benhailong on 2017/11/2.
 */
public class JPushService {
    private static Logger LOG = Logger.getLogger(JPushService.class);


    /**
     * 透传给所有人
     * @param jPushModel
     * @return PushResult 结果
     */
    public static PushResult touAll(JPushModel jPushModel){
        JPushClient jpushClient = getjPushConfig(jPushModel);
        PushPayload payload = buildPushObject_tou_all(jPushModel.getCon());
        PushResult result = null;
        return getPushResult(jpushClient, payload, result);
    }

    public static PushPayload buildPushObject_tou_all(String con) {
        return PushPayload.messageAll(con);
    }


    /**
     * 透传给一群人（包括1个人）
     * @param jPushModel
     * @return PushResult 结果
     */
    public static PushResult touGroup(JPushModel jPushModel){
        JPushClient jpushClient = getjPushConfig(jPushModel);
        PushPayload payload = buildPushObject_tou_group(jPushModel);
        PushResult result = null;
        return getPushResult(jpushClient, payload, result);
    }

    public static PushPayload buildPushObject_tou_group(JPushModel jPushModel) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(jPushModel.getUserid()))
                .setMessage(Message.content(jPushModel.getCon()))
                .build();
    }


    /**
     * 推送给所有人
     * @param jPushModel
     * @return PushResult 结果
     */

    public static PushResult tuiAll(JPushModel jPushModel){
        JPushClient jpushClient = getjPushConfig(jPushModel);
        PushPayload payload = buildPushObject_tui_all(jPushModel);
        PushResult result = null;
        return getPushResult(jpushClient, payload, result);
    }


    public static PushPayload buildPushObject_tui_all(JPushModel jPushModel) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(jPushModel.getCon())
                                .setSound(jPushModel.getSound())
                                .addExtras(jPushModel.getExtras())
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(jPushModel.getCon())
                                .addExtras(jPushModel.getExtras())
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }


    /**
     * 推送给一群人（包括1个人）
     * @param jPushModel
     * @return PushResult 结果
     */
    public static PushResult tuiGroup(JPushModel jPushModel){
        JPushClient jpushClient = getjPushConfig(jPushModel);
        PushPayload payload = buildPushObject_tui_group(jPushModel);
        PushResult result = null;
        return getPushResult(jpushClient, payload, result);
    }


    public static PushPayload buildPushObject_tui_group(JPushModel jPushModel) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(jPushModel.getUserid()))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(jPushModel.getCon())
                                .setSound(jPushModel.getSound())
                                .addExtras(jPushModel.getExtras())
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(jPushModel.getCon())
                                .addExtras(jPushModel.getExtras())
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }



    private static PushResult getPushResult(JPushClient jpushClient, PushPayload payload, PushResult result) {
        try {
            result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
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
        } finally {
            return result;
        }
    }


    private static JPushClient getjPushConfig(JPushModel jPushModel) {
        final String MASTERSECRET = jPushModel.getMastersecret();
        final String APPKEY = jPushModel.getAppkey();
        return new JPushClient(MASTERSECRET, APPKEY, null, ClientConfig.getInstance());
    }


}
