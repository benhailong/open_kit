package cc.openkit.kitPay.weichart.service.impl;

import cc.openkit.kitPay.weichart.handler.PrepayIdRequestHandler;
import cc.openkit.kitPay.weichart.model.WeichartModel;
import cc.openkit.kitPay.weichart.model.WeichartRefundModel;
import cc.openkit.kitPay.weichart.service.WeixinPayService;
//import cc.openkit.kitPay.weichart.util.ConstantUtil;
import cc.openkit.kitPay.weichart.util.Md5Util;
import cc.openkit.kitPay.weichart.util.WXUtil;
import cc.openkit.kitPay.weichart.util.XMLUtil;
import org.jdom2.JDOMException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by benhailong on 2017/11/1.
 */

public class WeixinPayServiceImpl implements WeixinPayService {

    /**
     * 生成预支付订单，获取prepayId,统一生成订单接口
     * @param weichartModel    微信配置
     * @param request    total_fee   订单价格
     * @param response
     * @return code 根据这个判断微信支付订单是否生成成功，1：失败，0：成功
     * @throws Exception
     */
    @Override
    public Map<String, Object> getOrder(HttpServletRequest request, HttpServletResponse response, WeichartModel weichartModel,String totalFee, String out_trade_no, String notify_url)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        /**
         * 接收参数
         */
        if(notify_url==null || "".equals(notify_url)){
            notify_url = weichartModel.getNotifyUrl();
        }

        // 获取生成预支付订单的请求类
        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);

        int total_fee=(int) (Float.valueOf(totalFee)*100);
        System.out.println("total:"+total_fee);
        System.out.println("total_fee:" + total_fee); // 价格
        prepayReqHandler.setParameter("appid", weichartModel.getAppId());
        prepayReqHandler.setParameter("body", weichartModel.getBody());
        prepayReqHandler.setParameter("mch_id", weichartModel.getMchId());
        String nonce_str = WXUtil.getNonceStr();
        prepayReqHandler.setParameter("nonce_str", nonce_str);
        prepayReqHandler.setParameter("notify_url", notify_url);
        prepayReqHandler.setParameter("out_trade_no", out_trade_no);

        System.out.println("IP:"+weichartModel.getSpbillCreateIp());
        // 这里是获取服务器的请求的Ip地址，上线之后可以用上面的代替，或者再config里边代替
        prepayReqHandler.setParameter("spbill_create_ip", weichartModel.getSpbillCreateIp());

        System.out.println("prepayReqHandler:"+prepayReqHandler.getParameter("spbill_create_ip"));

        String timestamp = WXUtil.getTimeStamp();
        prepayReqHandler.setParameter("time_start", timestamp);
        System.out.println(String.valueOf(total_fee));
        prepayReqHandler.setParameter("total_fee", String.valueOf(total_fee));
        prepayReqHandler.setParameter("trade_type", "APP");
        /**
         * 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
         */
        prepayReqHandler.setParameter("sign", prepayReqHandler.createMD5Sign());
        prepayReqHandler.setGateUrl(weichartModel.getGateUrl());

        String prepayid = prepayReqHandler.sendPrepay();
        // 若获取prepayid成功，将相关信息返回客户端
        if (prepayid != null && !prepayid.equals("")) {
            // 返回值加密
            String signs = "appid=" + weichartModel.getAppId() + "&noncestr=" + nonce_str + "&package=Sign=WXPay&partnerid="
                    + weichartModel.getPartnerId() + "&prepayid=" + prepayid + "&timestamp=" + timestamp + "&key="
                    + weichartModel.getAppKey();
            map.put("code", 0);
            map.put("info", "success");
            map.put("prepayid", prepayid);
            /**
             * 签名方式与上面类似
             */
            map.put("sign", Md5Util.MD5Encode(signs, "utf8").toUpperCase());
            map.put("appid", weichartModel.getAppId());
            map.put("timestamp", timestamp);  //等于请求prepayId时的time_start
            map.put("noncestr", nonce_str);   //与请求prepayId时值一致
            map.put("package", "Sign=WXPay");  //固定常量
            map.put("partnerid", weichartModel.getPartnerId());
        } else {
            map.put("code", 1);
            map.put("info", "获取prepayid失败");
        }
        return map;
    }

    /**
     * 接收微信支付成功通知
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public Map<String, String> getnotify(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter writer = response.getWriter();
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        String result = new String(outSteam.toByteArray(), "utf-8");
        System.out.println("微信支付通知结果：" + result);
        Map<String, String> map = null;
        try {
            /**
             * 解析微信通知返回的信息
             */
            map = XMLUtil.doXMLParse(result);
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("=========:" + result);

        return map;
    }



    /**
     * 退款接口
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public Map<String, String> refund(HttpServletRequest request, HttpServletResponse response, WeichartModel weichartModel, WeichartRefundModel weichartRefundModel)
            throws Exception {
        String gateUrl = "https://api.mch.weixin.qq.com/secapi/pay/refund";

        // 获取生成预支付订单的请求类
        PrepayIdRequestHandler prepayReqHandler = new PrepayIdRequestHandler(request, response);

        String signs = "";

        prepayReqHandler.setParameter("appid", weichartModel.getAppId());
        signs = signs + "appid="+weichartModel.getAppId();
        prepayReqHandler.setParameter("mch_id", weichartModel.getMchId());
        signs = signs + "&mch_id="+weichartModel.getMchId();

        // 加密一会儿处理
        prepayReqHandler.setParameter("nonce_str", weichartRefundModel.getNonceStr());
        signs = signs + "&nonce_str="+weichartRefundModel.getNonceStr();
        if(isNull(weichartRefundModel.getNotifyUrl())){
            prepayReqHandler.setParameter("notify_url", weichartRefundModel.getNotifyUrl());
            signs = signs + "&notify_url="+weichartRefundModel.getNotifyUrl();
        }
        prepayReqHandler.setParameter("out_refund_no", weichartRefundModel.getOutRefundNo());
        signs = signs + "&out_refund_no="+weichartRefundModel.getOutRefundNo();
        if(isNull(weichartRefundModel.getOutTradeNo())){
            prepayReqHandler.setParameter("out_trade_no", weichartRefundModel.getOutTradeNo());
            signs = signs + "&out_trade_no="+weichartRefundModel.getOutTradeNo();
        }
        if(isNull(weichartRefundModel.getRefundAccount())){
            prepayReqHandler.setParameter("refund_account", weichartRefundModel.getRefundAccount());
            signs = signs + "&refund_account="+weichartRefundModel.getRefundAccount();
        }
        if(isNull(weichartRefundModel.getRefundDesc())){
            prepayReqHandler.setParameter("refund_desc", weichartRefundModel.getRefundDesc());
            signs = signs + "&refund_desc="+weichartRefundModel.getRefundDesc();
        }
        prepayReqHandler.setParameter("refund_fee", weichartRefundModel.getRefundFee());
        signs = signs + "&refund_fee="+weichartRefundModel.getRefundFee();
        if(isNull(weichartRefundModel.getRefundFeeType())){
            prepayReqHandler.setParameter("refund_fee_type", weichartRefundModel.getRefundFeeType());
            signs = signs + "&refund_fee_type="+weichartRefundModel.getRefundFeeType();
        }

        // 判断字段是否为空
        if(isNull(weichartRefundModel.getSignType())){
            prepayReqHandler.setParameter("sign_type", weichartRefundModel.getSignType());
            signs = signs + "&sign_type="+weichartRefundModel.getSignType();
        }
        prepayReqHandler.setParameter("total_fee", weichartRefundModel.getTotalFee());
        signs = signs + "&total_fee="+weichartRefundModel.getTotalFee();
        if(isNull(weichartRefundModel.getTransactionId())){
            prepayReqHandler.setParameter("transaction_id", weichartRefundModel.getTransactionId());
            signs = signs + "&transaction_id="+weichartRefundModel.getTransactionId();
        }
        signs = signs + "&key="+weichartModel.getAppKey();
        System.out.println("拼接好的 sign = "+ signs);


        /**
         * 注意签名（sign）的生成方式，具体见官方文档（传参都要参与生成签名，且参数名按照字典序排序，最后接上APP_KEY,转化成大写）
         */
        prepayReqHandler.setParameter("sign", Md5Util.MD5Encode(signs, "utf8").toUpperCase());
        prepayReqHandler.setGateUrl(weichartModel.getGateUrl());

        // 请求地址
        prepayReqHandler.setGateUrl(gateUrl);
        String prepayid = prepayReqHandler.sendPrepay();
        System.out.println(prepayid);
        // 返回值
        Map<String, String> map = new HashMap<>();

        // 若获取prepayid成功，将相关信息返回客户端
        if (isNull(prepayid)) {
            // 返回值加密
            map.put("code", "0");
            map.put("info", "success");
            map.put("prepayid", prepayid);
        } else {
            map.put("code", "1");
            map.put("info", "获取prepayid失败");
        }
        return map;
    }

    private boolean isNull(String notifyUrl) {
        return notifyUrl != null && !"".equals(notifyUrl);
    }


}
