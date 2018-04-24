package cc.openkit.kitPay.alipay.service;

import cc.openkit.kitPay.alipay.config.AliPayConfig;
import cc.openkit.kitPay.alipay.model.Alipay;
import cc.openkit.kitPay.alipay.model.AlipayRefundModel;
import cc.openkit.kitPay.alipay.model.AlipayToIndividual;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface AlipayService {

    public  Map<String, Object> aliAppPay(AliPayConfig aliPayConfig,Alipay alipay);

    public boolean alipayToIndividual(AliPayConfig aliPayConfig,AlipayToIndividual alipayToIndividual);

    public boolean refund(AliPayConfig aliPayConfig, AlipayRefundModel alipayRefundModel);
}