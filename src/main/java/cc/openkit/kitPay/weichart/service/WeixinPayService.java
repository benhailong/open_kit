package cc.openkit.kitPay.weichart.service;

import cc.openkit.kitPay.weichart.model.WeichartModel;
import cc.openkit.kitPay.weichart.model.WeichartRefundModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by benhailong on 2017/11/1.
 */
public interface WeixinPayService {
    /**
     * 统一订单生成接口
     * @param request
     * @param response
     * @param weichartModel 微信配置
     * @param totalFee 价格
     * @param out_trade_no 订单号
     * @param notify_url 回调地址
     * @return code 根据这个判断微信支付订单是否生成成功，1：失败，0：成功
     * @throws Exception
     */

    Map<String, Object> getOrder(HttpServletRequest request, HttpServletResponse response, WeichartModel weichartModel, String totalFee, String out_trade_no, String notify_url) throws Exception;

    /**
     * 微信回调地址必须调用方法
     * 说明：
     * 此方法用于微信支付回调统一调用工具了，将 Xml 文件替换成 Map 文件返回
     * 参数说明：
     * 字段名          变量名          是否必填      类型           示例          描述
     * 返回状态码     return_code         是	     String(16)	    SUCCESS   SUCCESS/LFAI此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     * 返回信息      return_msg           否      String(128)    签名失败    返回信息，如非空，为错误原因，签名失败，参数格式校验错误
     * ----
     * 应用ID	     appid	             是	     String(32)	wx8888888888888888	微信开放平台审核通过的应用APPID
     * 商户号	     mch_id	             是	     String(32)	1900000109	        微信支付分配的商户号
     * 设备号	  device_info	         否	     String(32)	013467007045764	    微信支付分配的终端设备号，
     * 随机字符串   	nonce_str          	是	     String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位
     * 签名	         sign	            是	     String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名
     * 错误代码    	err_code	       否	String(32)	SYSTEMERROR   	错误返回的信息描述
     * 错误代码描述	err_code_des	    否	String(128)	系统错误	错误返回的信息描述
     * 用户标识    	openid	         是	     String(128)	wxd930ea5d5a258f4f	用户在商户appid下的唯一标识
     * 是否关注公众账号	is_subscribe	否	String(1)	Y	用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     * 交易类型	trade_type	是	String(16)	APP	APP
     * 付款银行	bank_type	是	String(16)	CMC	银行类型，采用字符串类型的银行标识，银行类型见
     * 总金额	total_fee	是	Int	100	订单总金额，单位为分
     * 货币种类	fee_type	否	String(8)	CNY	货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见
     * 现金支付金额	cash_fee	是	Int	100	现金支付金额订单现金支付金额
     * 现金支付货币类型	cash_fee_type	否	String(16)	CNY	货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
     * 代金券金额	coupon_fee	否	Int	10	代金券或立减优惠金额“小鱼等于”订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
     * 代金券使用数量	coupon_count	否	Int	1	代金券或立减优惠使用数量
     * 代金券ID	coupon_id_$n	否	String(20)	10000	代金券或立减优惠ID,$n为下标，从0开始编号
     * 单个代金券支付金额	coupon_fee_$n	否	Int	100	单个代金券或立减优惠支付金额,$n为下标，从0开始编号
     * 微信支付订单号	transaction_id	是	String(32)	1217752501201407033233368018	微信支付订单号
     * 商户订单号	out_trade_no	是	String(32)	1212321211201407033568112322	商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     * 商家数据包	attach	否	String(128)	123456	商家数据包，原样返回
     * 支付完成时间	time_end	是	String(14)	20141030133525	支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
     * @throws IOException
     * @return map
     */
    public Map<String, String> getnotify(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 退款接口
     * @param request
     * @param response
     * @throws IOException
     */

    public Map<String, String> refund(HttpServletRequest request, HttpServletResponse response,  WeichartModel weichartModel, WeichartRefundModel weichartRefundModel)
            throws Exception;
}
