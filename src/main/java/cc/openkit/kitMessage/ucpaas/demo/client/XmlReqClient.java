/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package cc.openkit.kitMessage.ucpaas.demo.client;

import cc.openkit.kitMessage.ucpaas.demo.DateUtil;
import cc.openkit.kitMessage.ucpaas.demo.EncryptUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.util.Date;


public class XmlReqClient extends AbsRestClient {
    private static Logger logger = Logger.getLogger(XmlReqClient.class);


    @Override
    public String callback(String accountSid, String authToken, String appId,
                           String fromClient, String to, String fromSerNum, String toSerNum) {
        // TODO Auto-generated method stub
        String result = "";
        DefaultHttpClient httpclient = getDefaultHttpClient();
        try {
            //MD5加密
            EncryptUtil encryptUtil = new EncryptUtil();
            // 构造请求URL内容
            String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);// 时间戳
            String signature = getSignature(accountSid, authToken, timestamp, encryptUtil);
            String url = getStringBuffer().append("/").append(version)
                    .append("/Accounts/").append(accountSid)
                    .append("/Calls/callBack")
                    .append(".xml?sig=").append(signature).toString();
            String body = (new StringBuilder("<?xml version='1.0' encoding='utf-8'?><callback>")
                    .append("<appId>").append(appId).append("</appId>")
                    .append("<fromClient>").append(fromClient).append("</fromClient>")
                    .append("<to>").append(to).append("</to>")
                    .append("<fromSerNum>").append(fromSerNum).append("</fromSerNum>")
                    .append("<toSerNum>").append(toSerNum).append("</toSerNum>")
                    .append("</callback>")).toString();
            HttpResponse response = post("application/xml", accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            httpclient.getConnectionManager().shutdown();
        }
        return result;
    }


    /**
     * 短信发送接口
     * @param accountSid 注册云之讯官网，在控制台中即可获取此参数
     * @param authToken 注册云之讯官网，在控制台中即可获取此参数
     * @param appId 创建应用时系统分配的唯一标示，在“应用列表”中可以查询
     * @param templateId 创建短信模板时系统分配的唯一标示，在“短信管理”中可以查询
     * @param to 需要下发短信的手机号码,支持国际号码，需要加国家码
     * @param param 需要下发短信的手机号码,支持国际号码，需要加国家码
     * @return String
     * templateSMS
     */
    @Override
    public String templateSMS(String accountSid, String authToken,
                              String appId, String templateId, String to, String param) {
        // TODO Auto-generated method stub
        String result = "";
        DefaultHttpClient httpclient = getDefaultHttpClient();
        try {
            //MD5加密
            EncryptUtil encryptUtil = new EncryptUtil();
            // 构造请求URL内容
            String timestamp = DateUtil.dateToStr(new Date(),
                    DateUtil.DATE_TIME_NO_SLASH);// 时间戳
            String signature = getSignature(accountSid, authToken, timestamp, encryptUtil);
            String url = getStringBuffer().append("/").append(version)
                    .append("/Accounts/").append(accountSid)
                    .append("/Messages/templateSMS")
                    .append(".xml?sig=").append(signature).toString();
            String body = (new StringBuilder("<?xml version='1.0' encoding='utf-8'?><templateSMS>")
                    .append("<appId>").append(appId).append("</appId>")
                    .append("<templateId>").append(templateId).append("</templateId>")
                    .append("<to>").append(to).append("</to>")
                    .append("<param>").append(param).append("</param>")
                    .append("</templateSMS>")).toString();
            HttpResponse response = post("application/xml", accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            httpclient.getConnectionManager().shutdown();
        }
        return result;
    }
}
