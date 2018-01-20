package cc.openkit.kitMessage.ucpaas.service;

import cc.openkit.kitMessage.ucpaas.demo.client.AbsRestClient;
import cc.openkit.kitMessage.ucpaas.demo.client.JsonReqClient;
import cc.openkit.kitMessage.ucpaas.demo.client.XmlReqClient;
import cc.openkit.kitMessage.ucpaas.model.UcpaasModel;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UcpaasService {

    static AbsRestClient InstantiationRestAPI(boolean enable) {
        if(enable) {
            return new JsonReqClient();
        } else {
            return new XmlReqClient();
        }
    }

    public static String testTemplateSMS(boolean json,String accountSid,String authToken,String appId,String templateId,String to,String param){
        String result = null;
        try {
            result=InstantiationRestAPI(json).templateSMS(accountSid, authToken, appId, templateId, to, param);
            System.out.println("Response content is: " + result);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送短信
     * @param ucpaasModel 云之讯短信模板
     * @return 返回值告诉你是成功还是失败
     */
    public static boolean xin(UcpaasModel ucpaasModel){
        System.out.println("请输入参数，以空格隔开...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("111111");
        String accountSid=ucpaasModel.getAccountSid();
        String token=ucpaasModel.getAuthToken();
        String appId=ucpaasModel.getAppId();
        String templateId = ucpaasModel.getTemplateId();

        String to=ucpaasModel.getPhone();
        String para=ucpaasModel.getCode();
        String result = testTemplateSMS(true, accountSid,token,appId, templateId,to,para);//短信发送接口

        JSONObject jsonObject = JSONObject.fromObject(result);
        System.out.println(jsonObject);

        JSONObject j = (JSONObject) jsonObject.get("resp");
        String f = (String) j.get("respCode");

        if("000000".equals(f)){
            return true;
        }else {
            return false;
        }
    }

}
