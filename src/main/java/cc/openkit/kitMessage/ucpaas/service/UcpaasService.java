/**
 * @author Tony
 * @date 2018-01-10
 * @project rest_demo
 */
package cc.openkit.kitMessage.ucpaas.service;

import cc.openkit.kitMessage.ucpaas.model.UcpaasConfig;
import cc.openkit.kitMessage.ucpaas.model.UcpaasModel;
import cc.openkit.kitMessage.ucpaas.restDemo.client.AbsRestClient;
import cc.openkit.kitMessage.ucpaas.restDemo.client.JsonReqClient;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UcpaasService {

	static AbsRestClient InstantiationRestAPI() {
		return new JsonReqClient();
	}

	public static String testSendSms(String sid, String token, String appid, String templateid, String param, String mobile, String uid){
		String result = "";
		try {
			result=InstantiationRestAPI().sendSms(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String testSendSmsBatch(String sid, String token, String appid, String templateid, String param, String mobile, String uid){
		String result = "";
		try {
			result=InstantiationRestAPI().sendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String testAddSmsTemplate(String sid, String token, String appid, String type, String template_name, String autograph, String content){
		String result = "";
		try {
			result=InstantiationRestAPI().addSmsTemplate(sid, token, appid, type, template_name, autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public static String testGetSmsTemplate(String sid, String token, String appid, String templateid, String page_num, String page_size){
		String result = "";
		try {
			result=InstantiationRestAPI().getSmsTemplate(sid, token, appid, templateid, page_num, page_size);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public static String testEditSmsTemplate(String sid, String token, String appid, String templateid, String type, String template_name, String autograph, String content){
		String result = "";
		try {
			result=InstantiationRestAPI().editSmsTemplate(sid, token, appid, templateid, type, template_name, autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public static String testDeleterSmsTemplate(String sid, String token, String appid, String templateid){
		String result = "";
		try {
			result=InstantiationRestAPI().deleterSmsTemplate(sid, token, appid, templateid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 指定模板单发
	 * @param config 配置文件
	 * @param model 内容模型
	 * @return String 返回值
	 */
	public static String sendSms(UcpaasConfig config, UcpaasModel model){
		return testSendSms(config.getSid(), config.getToken(), config.getAppid(), model.getTemplateid(), model.getParam(), model.getMobile(), model.getUid());
	}

	/**
	 * 指定模板群发
	 * @param config 配置文件
	 * @param model 内容模型
	 * @return String 返回值
	 */
	public static String sendSmsBatch(UcpaasConfig config, UcpaasModel model){
		return testSendSmsBatch(config.getSid(), config.getToken(), config.getAppid(), model.getTemplateid(), model.getParam(), model.getMobile(), model.getUid());
	}

	/**
	 * 增加模板
	 * @param config 配置文件
	 * @param model 内容模型
	 * @return String 返回值
	 */
	public static String addSmsTemplate(UcpaasConfig config, UcpaasModel model){
		return testAddSmsTemplate(config.getSid(), config.getToken(), config.getAppid(), model.getType(), model.getTemplate_name(), model.getAutograph(), model.getContent());
	}

	/**
	 * 查询模板
	 * @param config 配置文件
	 * @param model 内容模型
	 * @return String 返回值
	 */
	public static String getSmsTemplate(UcpaasConfig config, UcpaasModel model){
		return testGetSmsTemplate(config.getSid(), config.getToken(), config.getAppid(), model.getTemplateid(), model.getPage_num(), model.getPage_size());
	}

	/**
	 * 编辑模板
	 * @param config 配置文件
	 * @param model 内容模型
	 * @return String 返回值
	 */
	public static String editSmsTemplate(UcpaasConfig config, UcpaasModel model){
		return testEditSmsTemplate(config.getSid(), config.getToken(), config.getAppid(), model.getTemplateid(), model.getType(), model.getTemplate_name(), model.getAutograph(), model.getContent());
	}

	/**
	 * 删除模板
	 * @param config 配置文件
	 * @param model 内容模型
	 * @return String 返回值
	 */
	public static String deleterSmsTemplate(UcpaasConfig config, UcpaasModel model){
		return testDeleterSmsTemplate(config.getSid(), config.getToken(), config.getAppid(), model.getTemplateid());
	}

}
