package cc.openkit.kitPay.alipay.service.impl;


import cc.openkit.common.KitUtil;
import cc.openkit.kitPay.alipay.config.AliPayConfig;
import cc.openkit.kitPay.alipay.model.Alipay;
import cc.openkit.kitPay.alipay.model.AlipayRefundModel;
import cc.openkit.kitPay.alipay.model.AlipayToIndividual;
import cc.openkit.kitPay.alipay.model.GoodsDetail;
import cc.openkit.kitPay.alipay.service.AlipayService;
import cc.openkit.kitPay.weichart.util.XMLUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AlipayServiceImpl implements AlipayService {

    /**
     * 原生付款
     */
    public Map<String, Object> aliAppPay(AliPayConfig aliPayConfig,Alipay alipay) {

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getServerUrl(), aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(), aliPayConfig.getPublicKey(), aliPayConfig.getSignType());
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(alipay.getBody());
        model.setSubject(alipay.getSubject());
        model.setOutTradeNo(alipay.getOutTradeNo());
        model.setTimeoutExpress(alipay.getTimeoutExpress());
        model.setTotalAmount(alipay.getTotalAmount());
        model.setProductCode(alipay.getProductCode());

        request.setBizModel(model);
        request.setNotifyUrl(alipay.getNotifyUrl());

        String aliInfo = null;
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            if(response==null){
                resultMap = KitUtil.returnMap("101","调用失败");
                return resultMap;
            }
            aliInfo = response.getBody();
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        resultMap.put("msg", "200");
        resultMap.put("body", aliInfo);
        resultMap.put("desc", "");

        return resultMap;
    }

    /**
     * 单笔转账到个人支付宝账号
     */
    public boolean alipayToIndividual(AliPayConfig aliPayConfig,AlipayToIndividual alipayToIndividual) {

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getServerUrl(), aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(), aliPayConfig.getPublicKey(), aliPayConfig.getSignType());

        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        request.setBizContent("{" +
                "\"out_biz_no\":\""+alipayToIndividual.getOutBizNo()+"\"," +
                "\"payee_type\":\""+alipayToIndividual.getPayeeType()+"\"," +
                "\"payee_account\":\""+alipayToIndividual.getPayeeAccount()+"\"," +
                "\"amount\":\""+alipayToIndividual.getAmount()+"\"," +
                "\"payer_show_name\":\""+alipayToIndividual.getPayerShowName()+"\"," +
                "\"payee_real_name\":\""+alipayToIndividual.getPayeeRealName()+"\"," +
                "\"remark\":\""+alipayToIndividual.getRemark()+"\"," +
                "}");



//            AlipayFundTransToaccountTransferResponse execute = alipayClient.execute(request);

        AlipayFundTransToaccountTransferResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return returnResponse(response);
    }

    /**
     * 支付宝订单退款
     * @param aliPayConfig
     * @param alipayRefundModel
     * @return
     */
    public boolean refund(AliPayConfig aliPayConfig, AlipayRefundModel alipayRefundModel) {

        String alipayOpenRefundUrl = "https://openapi.alipay.com/gateway.do";

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(alipayOpenRefundUrl, aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(), aliPayConfig.getPublicKey(), aliPayConfig.getSignType());

        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        StringBuffer json = new StringBuffer("{");
        json.append("\"refund_amount\":\""+alipayRefundModel.getRefundAmount()+"\"");

        if(isNull(alipayRefundModel.getOutTradeNo())){
            json.append(",\"out_trade_no\":\""+alipayRefundModel.getOutTradeNo()+"\"");
        }
        if(isNull(alipayRefundModel.getTradeNo())){
            json.append(",\"trade_no\":\""+alipayRefundModel.getTradeNo()+"\"");
        }

        if(isNull(alipayRefundModel.getRefundCurrency())) {
            json.append(",\"refund_currency\":\"" + alipayRefundModel.getRefundCurrency() + "\"");
        }
        if(isNull(alipayRefundModel.getRefundReason())) {
            json.append(",\"refund_reason\":\"" + alipayRefundModel.getRefundReason() + "\"");
        }
        if(isNull(alipayRefundModel.getOutRequestNo())) {
            json.append(",\"out_request_no\":\"" + alipayRefundModel.getOutRequestNo() + "\"");
        }
        if(alipayRefundModel.getGoodsDetail()!=null && !"".equals(alipayRefundModel.getGoodsDetail())) {
            json.append(",\"operator_id\":\"" + alipayRefundModel.getGoodsDetail() + "\"");
        }
        if(isNull(alipayRefundModel.getStoreId())) {
            json.append(",\"store_id\":\"" + alipayRefundModel.getStoreId() + "\"");
        }
        if(isNull(alipayRefundModel.getTerminalId())) {
            json.append(",\"terminal_id\":\"" + alipayRefundModel.getTerminalId() + "\"");
        }
        int i = 0;
        if(alipayRefundModel.getGoodsDetail()!=null && !"".equals(alipayRefundModel.getGoodsDetail())){
            i = alipayRefundModel.getGoodsDetail().size();
        }

        if(i>0){
            json.append( "\"goods_detail\":[{");
            for(int m = 0; m < i; m++){
                GoodsDetail gd = alipayRefundModel.getGoodsDetail().get(m);
                json.append("\"goods_id\":\""+gd.getGoodsId()+"\"");
                if(isNull(gd.getAlipayGoodsId())){
                    json.append(",\"alipay_goods_id\":\"" + gd.getAlipayGoodsId() + "\"");
                }
                json.append(",\"goods_name\":\""+gd.getGoodsName()+"\"");
                json.append(",\"quantity\":\""+gd.getQuantity()+"\"");
                json.append(",\"price\":\""+gd.getPrice()+"\"");
                if(isNull(gd.getGoodsCategory())){
                    json.append(",\"goods_category\":\"" + gd.getGoodsCategory() + "\"");
                }
                if(isNull(gd.getBody())){
                    json.append(",\"body\":\"" + gd.getBody() + "\"");
                }
                if(isNull(gd.getShowUrl())){
                    json.append(",\"show_url\":\"" + gd.getShowUrl() + "\"");
                }
            }
            json.append( "}]");
        }
        json.append( "}");

        System.out.println("请求的json格式："+json.toString());
        request.setBizContent(json.toString());

        AlipayFundTransToaccountTransferResponse response = new AlipayFundTransToaccountTransferResponse();
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return returnResponse(response);
    }

    private boolean isNull(String outTradeNo) {
        return outTradeNo != null && !"".equals(outTradeNo);
    }

    private boolean returnResponse(AlipayFundTransToaccountTransferResponse response) {
        if(response.isSuccess()){
            System.out.println("调用成功");
            return true;
        } else {
            System.out.println("调用失败");
            System.out.println(response.getBody());
            return false;
        }
    }


}
