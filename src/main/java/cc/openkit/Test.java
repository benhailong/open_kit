package cc.openkit;

import cc.openkit.kitPay.alipay.config.AliPayConfig;
import cc.openkit.kitPay.alipay.model.AlipayRefundModel;
import cc.openkit.kitPay.alipay.service.AlipayService;
import cc.openkit.kitPay.alipay.service.impl.AlipayServiceImpl;

public class Test {

    public static void main(String[] args) {
        // 支付宝退款
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("2018050760145056");
        aliPayConfig.setPrivateKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC65lV/RgYOeYISacdB3gIH2lS9zhC0lEpiQ0MEDHnoos4CWNcn0puCi7xmUlLc/yvaRDH+ixvHxdHc8EHa5BMy4hl5NBYZT2HeF1e3COKB26n3LOhVIwLWFlf7u7zXf1LbMNvePdDQQzSCoIxiMxY3amMPWIJUmSrRTIfgimnl+RozpTvpm1Ppg7Ecvf4VZBj+a8r1+6mfFNc4pmJ8IA44zAwlHuhDiOy4R9MxkjTSExwnZt3y/wHLpqgevzOlE5tnUMFtbmDEoc1fSOw9N4Au9YSH906kBeId1k2VTkuq1gEil9PoTo00I41AhWRBeIjxNyvYksrqP/YRnoXfAtl3AgMBAAECggEAVIrOT9UP9ko2cTfR/1R6XK0BOh5VZinR/+LnFJTELFxAjcU8BfJ5j7K/1RUWEIuIfaHtb3PjbBlqleNEFsymdpTZ6v6JpIdJANpUPiJRu2Xu2zVAHwrIRKk0wVUp1dztUOMoAb66jwpnXVNcTStIuGZySsXBppzmRmi06fgScQjYFFusGFm2OkBAPf2CFDain9pX7bZqZcC3jplm3JOKZBfQJsn9jnPREfhaQ74Ed1hqGdM16FBlIhbYt5RmkQX59ATHtd8vEolLSbNJ+Z6pWCR2iOGFSGlfriqoDQDvU0bR/uBj4N36JthjVFAJz5XWGI5WAKMr7qCjjJ5HGc1hWQKBgQDl0oJ8aWAiSHKINmD6waUKNNKTvfGt21lz7uFYGJQcUJej8upBlyTfFq5hvlaRfwbxE5KXRhotKkypbWPoFuobQCpZ1Qh1MRfSasMz5VQisyGMNkBS60eDMzMXtJogms99gUvN6IDa5vMyaz30qkkZuA/gpWwtSDUb5WHZ3+63IwKBgQDQMDnuNdITyzRI6N6qhZfPi5zuTNJcckfgXvYsNuFZvC3Xh1ePvgV2wNbL6AjZxuB1xcvDhe+5iVYaGSeRLgtI/UC19zVawtUjAbrOMSTJxlqtouEqmIk+h1fqXPFxahNNEJjLmocBhnscawzi0Uv4Du5CjBhe8NqWN7lGta5jnQKBgQCOROSWE715O5P7En6yfFGooc6BuyHzWEhl5kkFeiGl7ZYR3fx6IhCnMak9xNBePV6UumMS1ki6EOdoMtmYASdnOy98cM5NjdiLX5/7bknJOU7ZN3RWYGPiqj1EvX50FKHBtdqxWu75k+KVIaI25XtfOnxJut3eokaOQE90ypVCNQKBgQCzyGHOj1XKWBnfuJHJKjLOPR+ZPmgPA3WEkhz+U6pJhtMDo9H+xLcNNTyIu+kgv7jIm7X6NCivzaS4Ru6/VcbTEjiWq1O8/DF42J6MPy4ovQ1DkzvlP/KNN+246uhp65OdYm7ArMJXk92uzddD7EAxiBtDBp5pJo9tV9O891oQlQKBgEK3e4mPaCl3P3iy77mRmtBS9OSU5AJWxmoRnmLaT4afzE89yd87aZeW2T9RHNqYZEwHXSOVOjSUQqhhNPrdCgQ0Gq4CDwV4j2rSRgq/N2lsroppI/4QkVSq5or6P5v82gw8Lc14lJFgcbJDMzZi0Pue2NxIgAcIQuZQZM2FRFjo");
//        aliPayConfig.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuuZVf0YGDnmCEmnHQd4CB9pUvc4QtJRKYkNDBAx56KLOAljXJ9Kbgou8ZlJS3P8r2kQx/osbx8XR3PBB2uQTMuIZeTQWGU9h3hdXtwjigdup9yzoVSMC1hZX+7u8139S2zDb3j3Q0EM0gqCMYjMWN2pjD1iCVJkq0UyH4Ipp5fkaM6U76ZtT6YOxHL3+FWQY/mvK9fupnxTXOKZifCAOOMwMJR7oQ4jsuEfTMZI00hMcJ2bd8v8By6aoHr8zpRObZ1DBbW5gxKHNX0jsPTeALvWEh/dOpAXiHdZNlU5LqtYBIpfT6E6NNCONQIVkQXiI8Tcr2JLK6j/2EZ6F3wLZdwIDAQAB");
        aliPayConfig.setPublicKey("" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmUZ12be5ee9q5c8c1JFNCYxDCE4VnQR6jTaCiWXLj+gmCyEzHXrKRr8uS/F18nmSIZdjTpl7/7YSO1/FMRhQPsR/Kb4G4XbbHoivyjiWhfenzZxWV37UVB6pl2hHNL9ILx8T64mXTuDoIS+HtMHckZuBvNmb93k/mcS8GxQBuISrf40lDmNY1Jcyt85yDzXBUsBR+h3xt58DK3/8Q69HlTar1IDzG+Eo+y8sNIG1+z/ECeUXGQ3vEbyqDcP/KVdSV1N2dYGK29cN/Cl093IoKGYwFFlkcP/N9DFdaBHLlUP0x3aa2jpl+BmYLmBqWeeqPQn2P/kpST9dQNiAy9eKwIDAQAB"
                +"");
        aliPayConfig.setServerUrl("https://openapi.alipay.com/gateway.do");
        aliPayConfig.setCharset("UTF-8");
        aliPayConfig.setFormat("JSON");
        aliPayConfig.setSignType("RSA2");
        aliPayConfig.setDoMain("http://wqsj.xuanwumobile.com/");

        AlipayRefundModel alipayRefundModel = new AlipayRefundModel();
//        alipayRefundModel.setTradeNo("2018050821001004630517115323");
        alipayRefundModel.setTradeNo("201805081926447477");
        alipayRefundModel.setRefundAmount("0.01");


        AlipayService alipayService = new AlipayServiceImpl();

        boolean refund = alipayService.refund(aliPayConfig, alipayRefundModel);

        System.out.println(refund);

    }

}
